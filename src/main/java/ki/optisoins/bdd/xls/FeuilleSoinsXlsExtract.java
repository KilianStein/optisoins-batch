package ki.optisoins.bdd.xls;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.utils.ReflectUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
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

public class FeuilleSoinsXlsExtract {

  public final static String XLS_EXTENSION = ".xls";

  public List<FeuilleSoinsXls> extract() {
    return extract(OptiSoinsConfiguration.dossierDonnees);
  }

  private List<FeuilleSoinsXls> extract(String dataDirectory) {
    List<FeuilleSoinsXls> feuilleSoinXls = new ArrayList<>();
    try (DirectoryStream<Path> dataDirStream = Files.newDirectoryStream(Paths.get(dataDirectory))) {
      for (Path pathFichier : dataDirStream) {
        if (pathFichier.toString().endsWith(XLS_EXTENSION)) {
          feuilleSoinXls.addAll(extract(pathFichier));
        }
      }
    } catch (IOException e) {
      OptiSoinsLogger.printError(e);
      throw new RuntimeException(e);
    }
    return feuilleSoinXls;
  }

  protected List<FeuilleSoinsXls> extract(Path pathXls) throws IOException {
    return extract(Files.newInputStream(pathXls), pathXls.getFileName().toString());
  }

  private List<FeuilleSoinsXls> extract(InputStream inputStream, String filename) throws IOException {
    List<FeuilleSoinsXls> feuillesSoinsXls = new ArrayList<>();
    HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
    for (Sheet basicSheet : workbook) {
      if (isSheetValid(basicSheet)) {
        feuillesSoinsXls.addAll(extract((HSSFSheet) basicSheet, filename));
      }
    }
    workbook.close();
    inputStream.close();
    return feuillesSoinsXls;
  }

  private List<FeuilleSoinsXls> extract(HSSFSheet sheet, String filename) {
    List<FeuilleSoinsXls> feuillesSoinsXls = new ArrayList<>();
    int numberTotalRow = sheet.getPhysicalNumberOfRows();
    int numberTotalColumn = sheet.getRow(0).getPhysicalNumberOfCells();

    List<String> nomColumn = extractColumnsName(sheet);
    for (int rowNumber = 1; rowNumber < numberTotalRow; rowNumber++) {
      Map<String, Object> mapLine = new HashMap<>();
      for (int columnNumber = 0; columnNumber < numberTotalColumn; columnNumber++) {
        HSSFRow row = sheet.getRow(rowNumber);
        if (row != null){
          Object objectCell = toObjectCell(row.getCell(columnNumber));
          if (isNotEmpty(objectCell)) {
            mapLine.put(nomColumn.get(columnNumber), objectCell);
          }
        }
      }
      if (!mapLine.isEmpty()) {
        feuillesSoinsXls.add(createFeuilleSoinsXls(mapLine, filename, sheet.getSheetName(), rowNumber));
      }
    }
    return feuillesSoinsXls;
  }

  private FeuilleSoinsXls createFeuilleSoinsXls(Map<String, Object> mapLine, String filename, String sheetName, int rowNumber) {
    FeuilleSoinsXls feuilleSoinsXls = new FeuilleSoinsXls();
    feuilleSoinsXls.setNomFichier(filename);
    feuilleSoinsXls.setNomFeuille(sheetName);
    feuilleSoinsXls.setNumeroLigne(String.valueOf(rowNumber));

      for (String nomChamp : mapLine.keySet()) {
        try {
          ReflectUtils.setFieldValue(feuilleSoinsXls, nomChamp, mapLine.get(nomChamp));
        } catch (Exception e){
          OptiSoinsLogger.printError("Erreur sur la feuille " + feuilleSoinsXls.getInformations() + ", le nom '" + nomChamp + "' n'est pas géré");
          OptiSoinsLogger.printError("Voici la liste des champs autorisés : " + FeuilleSoinsXls.getNomsChampsAutorises());
          throw e;
        }
      }
    return feuilleSoinsXls;
  }

  private List<String> extractColumnsName(HSSFSheet sheet) {
    List<String> columnsName = new ArrayList<>();
    for (Cell row : sheet.getRow(0)) {
      columnsName.add(toStringCell(row));
    }
    return columnsName;
  }

  private boolean isSheetValid(Sheet sheet) {
    return sheet instanceof HSSFSheet && sheet.getPhysicalNumberOfRows() > 1;
  }

  private String toStringCell(Cell cell) {
    return String.valueOf(toObjectCell(cell));
  }

  private Object toObjectCell(Cell cell) {
    if (cell == null) {
      return "";
    }
    switch (cell.getCellType()) {
      case Cell.CELL_TYPE_NUMERIC:
        return tranformDoubleToString(cell.getNumericCellValue());
      case Cell.CELL_TYPE_STRING:
        return cell.getStringCellValue().trim();
      case Cell.CELL_TYPE_BLANK:
        return "";
    }
    throw new RuntimeException("type non géré");
  }

  private String tranformDoubleToString(double d) {
    return String.valueOf(d).replace(".00", "").replace(".0", "");
  }

  private boolean isNotEmpty(Object objectCell) {
    return objectCell != null && !"".equals(objectCell);
  }
}
