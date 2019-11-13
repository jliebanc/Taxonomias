package Principal;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// recogemos los valores de las listas necesarias

		// el orden de estos arrylist es de la dependencia mas externa, disciplina,
		// hasta la mas interna, turbina

		ArrayList<Dato> lista_valores_1 = ParseoDicc.parseoDicc("LISTAS/Tipo de Generación-Generation Type.csv", 0, 1,
				1, 19, 17, 21);
		ArrayList<Dato> lista_valores_2 = ParseoDicc.parseoDicc("LISTAS/Instalaciones-Faciltie.csv", 1, 1, 1, 19, 17,
				21);
		ArrayList<Dato> lista_valores_3 = ParseoDicc.parseoDicc("LISTAS/Tecnología-Technology.csv", 2, 1, 1, 19, 21, 21);
		ArrayList<Dato> lista_valores_4 = ParseoDicc.parseoDicc("LISTAS/Modelo-Model.csv", 3, 1, 1, 21, 22, 19);

		// creamos las taxonomias
		ArrayList<Taxo> lista_taxonomia = CrearTaxonomia.generarTaxo(lista_valores_1, lista_valores_2, lista_valores_3,
				lista_valores_4);

		// generamos los excels
		CrearExcel.creacionExcel(lista_taxonomia, "ae_tx_ceco_modelo", "TAXONOMIAS/ae_tx_ceco_modelo.xls");
	}

}
