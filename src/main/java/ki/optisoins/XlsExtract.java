package ki.optisoins;

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

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class XlsExtract {

	public List<FeuilleSoins> extract() {
		List<FeuilleSoins> feuilleSoins = new ArrayList<>();
	    try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get("donnees"))) {
	    	for(Path path : dirStream){
	    		if (path.toString().endsWith(".xls")){
	    			feuilleSoins.addAll(extract(path));
	    		}
	    	}
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    return feuilleSoins;
	}

	public List<FeuilleSoins> extract(Path dataExcel) {
		List<Map<String, Object>> donneesExtraites = new ArrayList<>();
		try {
			InputStream inputStream = Files.newInputStream(dataExcel);
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			for (Sheet basicSheet : workbook) {
				HSSFSheet sheet = (HSSFSheet) basicSheet;

				int numberTotalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
				int numberTotalRow = sheet.getPhysicalNumberOfRows();

				List<String> nomColumn = new ArrayList<>();
				for (Cell row : sheet.getRow(0)) {
					nomColumn.add(toStringCell(row));
				}

				for (int rowNumber = 1; rowNumber < numberTotalRow; rowNumber++) {
					Map<String, Object> map = new HashMap<>();
					for (int columnNumber = 0; columnNumber < numberTotalColumn; columnNumber++) {
						map.put(nomColumn.get(columnNumber), toObjectCell(sheet.getRow(rowNumber).getCell(columnNumber)));
					}
					donneesExtraites.add(map);
				}
				printDonneesExtraite(donneesExtraites);
				inputStream.close();
				workbook.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return new FeuilleSoinsMapper().map(donneesExtraites);
	}
	

	public void printDonneesExtraite(List<Map<String, Object>> donneesExtraites) {
		for (Map<String, Object> map : donneesExtraites) {
			System.out.println("---------------------------");
			for (String key : map.keySet()) {
				System.out.println(key + ": " + String.valueOf(map.get(key)));
			}
			System.out.println("---------------------------");
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
