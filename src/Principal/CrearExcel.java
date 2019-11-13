package Principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CrearExcel {

	public static void creacionExcel(ArrayList<Taxo> lista_taxonomia, String nombre, String ruta) {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(nombre);
		wb.getSheetAt(0);
		HSSFRow rowcolumna = sheet.createRow(0);
		HSSFCell celldic1 = rowcolumna.createCell(0);
		HSSFCell celldic2 = rowcolumna.createCell(1);
		HSSFCell celldic3 = rowcolumna.createCell(2);
		HSSFCell celldic4 = rowcolumna.createCell(3);
		celldic1.setCellValue("ae_dct_ceco_tipo_generacion");
		celldic2.setCellValue("ae_dct_ceco_instalaciones");
		celldic3.setCellValue("ae_dct_ceco_cuenca");
		celldic4.setCellValue("ae_dct_ceco_turbina");
		for (int i = 0; i < lista_taxonomia.size(); i++) {
			HSSFRow row = sheet.createRow(i+1);
			HSSFCell cell_disciplina = row.createCell(0);
			HSSFCell cell_categoria = row.createCell(1);
			HSSFCell cell_subcategoria = row.createCell(2);
			HSSFCell cell_concepto = row.createCell(3);
			cell_disciplina.setCellValue(lista_taxonomia.get(i).getDepn1());
			cell_categoria.setCellValue(lista_taxonomia.get(i).getDepen2());
			cell_subcategoria.setCellValue(lista_taxonomia.get(i).getDepen3());
			cell_concepto.setCellValue(lista_taxonomia.get(i).getDepen4());
		}

		HSSFSheet dicsheet = wb.createSheet("defaults");
		HSSFRow diccrowcolumna = dicsheet.createRow(0);
		HSSFCell dicccelldic1 = diccrowcolumna.createCell(0);
		HSSFCell dicccelldic2 = diccrowcolumna.createCell(1);
		HSSFCell dicccelldic3 = diccrowcolumna.createCell(2);
		HSSFCell dicccelldic4 = diccrowcolumna.createCell(3);
		dicccelldic1.setCellValue("ae_dct_ceco_tipo_generacion");
		dicccelldic2.setCellValue("ae_dct_ceco_instalaciones");
		dicccelldic3.setCellValue("ae_dct_ceco_cuenca");
		dicccelldic4.setCellValue("ae_dct_ceco_turbina");

		try {
			wb.write(new FileOutputStream(ruta));
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}