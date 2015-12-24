package ki.optisoins;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XlsExtract {

    public List<FeuilleSoins> extract() {
        List<FeuilleSoins> feuilleSoins = new ArrayList<>();
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get("donnees"))) {
            for (Path path : dirStream) {
                if (path.toString().endsWith(".xls")) {
                    List<FeuilleSoins> feuillesSoins = extract(path);
                    if (!feuillesSoins.isEmpty()) {
                        feuilleSoins.addAll(feuillesSoins);
                    }
                }
            }
        } catch (IOException e) {
            OptiSoinsLogger.printError(e);
        }
        return feuilleSoins;
    }

    private List<FeuilleSoins> extract(Path dataExcel) {
        List<Map<String, Object>> donneesExtraites = new ArrayList<>();
        try {
            InputStream inputStream = Files.newInputStream(dataExcel);
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            for (Sheet basicSheet : workbook) {
                HSSFSheet sheet = (HSSFSheet) basicSheet;
                int numberTotalRow = sheet.getPhysicalNumberOfRows();
                if (numberTotalRow != 0) {
                    int numberTotalColumn = sheet.getRow(0).getPhysicalNumberOfCells();

                    List<String> nomColumn = new ArrayList<>();
                    for (Cell row : sheet.getRow(0)) {
                        nomColumn.add(toStringCell(row));
                    }

                    for (int rowNumber = 1; rowNumber < numberTotalRow; rowNumber++) {
                        Map<String, Object> map = new HashMap<>();
                        for (int columnNumber = 0; columnNumber < numberTotalColumn; columnNumber++) {
                            Object objectCell = toObjectCell(sheet.getRow(rowNumber).getCell(columnNumber));
                            if (isNotEmpty(objectCell)) {
                                map.put(nomColumn.get(columnNumber), objectCell);
                            }
                        }
                        if (!map.isEmpty()) {
                            if (OptiSoinsProperties.getConfigurationBoolean(OptiSoinsPropertiesValue.UN_DOSSIER_PAR_EXCEL)) {
                                map.put(FeuilleSoinsChamps.NOMDOSSIER_CHAMP, getSubstring(dataExcel));
                            }
                            donneesExtraites.add(map);
                        }
                    }
                    printDonneesExtraite(donneesExtraites);
                    inputStream.close();
                    workbook.close();
                }
            }
        } catch (Exception e) {
            OptiSoinsLogger.printError(e);
            return new ArrayList<>();
        }
        return new FeuilleSoinsMapper().map(donneesExtraites);
    }

    private String getSubstring(Path dataExcel) {
        String fileName = dataExcel.getFileName().toString();
        return fileName.substring(0, fileName.length() - 4);
    }

    private boolean isNotEmpty(Object objectCell) {
        return objectCell != null && !"".equals(objectCell);
    }


    public void printDonneesExtraite(List<Map<String, Object>> donneesExtraites) {
        for (Map<String, Object> map : donneesExtraites) {
            OptiSoinsLogger.printTrace("---------------------------");
            for (String key : map.keySet()) {
                OptiSoinsLogger.printTrace(key + ": " + String.valueOf(map.get(key)));
            }
            OptiSoinsLogger.printTrace("---------------------------");
        }
    }

    private String toStringCell(Cell cell) {
        return String.valueOf(toObjectCell(cell));
    }

    private Object toObjectCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_BLANK:
                return "";

        }
        throw new RuntimeException("type non géré");
    }
}
