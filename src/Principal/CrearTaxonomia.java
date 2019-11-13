package Principal;

import java.util.ArrayList;

import com.sun.org.glassfish.external.arc.Taxonomy;

public class CrearTaxonomia {
	public static ArrayList<Taxo> generarTaxo(ArrayList<Dato> lista_valores1, ArrayList<Dato> lista_valores2,
			ArrayList<Dato> lista_valores3, ArrayList<Dato> lista_valores4) {

		// arrylist de taxonomias para luego crear el excel
		ArrayList<Taxo> lista_taxonomia = new ArrayList<Taxo>();

		// vamos sacando todos los datos de nuestros objetos y creando listas, se podria
		// hacer de otr aforma pero en los ifs necesito sacar un valor exacto de un
		// metodo y no se me ocurria como hacerlo

		ArrayList<String> lista_nombre_depen1 = new ArrayList<String>();
		ArrayList<String> lista_locale_depen1 = new ArrayList<String>();
		for (Dato value1 : lista_valores1) {
			lista_nombre_depen1.add(value1.getNombre());
			lista_locale_depen1.add(value1.getLocale());
		}

		ArrayList<String> lista_nombre_depen2 = new ArrayList<String>();
		ArrayList<String> lista_locale_depen2 = new ArrayList<String>();
		ArrayList<String> lista_dependencia1_depen2 = new ArrayList<String>();
		for (Dato value2 : lista_valores2) {
			lista_nombre_depen2.add(value2.getNombre());
			lista_locale_depen2.add(value2.getLocale());
			lista_dependencia1_depen2.add(value2.getDependencia());
		}

		ArrayList<String> lista_nombre_depen3 = new ArrayList<String>();
		ArrayList<String> lista_locale_depen3 = new ArrayList<String>();
		ArrayList<String> lista_dependencia1_depen3 = new ArrayList<String>();
		ArrayList<String> lista_dependencia2_depen3 = new ArrayList<String>();
		for (Dato value3 : lista_valores3) {
			lista_nombre_depen3.add(value3.getNombre());
			lista_locale_depen3.add(value3.getLocale());
			lista_dependencia1_depen3.add(value3.getDependencia());
			lista_dependencia2_depen3.add(value3.getDependencia_aux_1());
		}

		ArrayList<String> lista_nombre_depen4 = new ArrayList<String>();
		ArrayList<String> lista_locale_depen4 = new ArrayList<String>();
		ArrayList<String> lista_dependencia1_depen4 = new ArrayList<String>();
		ArrayList<String> lista_dependencia2_depen4 = new ArrayList<String>();
		ArrayList<String> lista_dependencia3_depen4 = new ArrayList<String>();
		for (Dato value4 : lista_valores4) {
			lista_nombre_depen4.add(value4.getNombre());
			lista_locale_depen4.add(value4.getLocale());
			lista_dependencia1_depen4.add(value4.getDependencia());
			lista_dependencia2_depen4.add(value4.getDependencia_aux_1());
			lista_dependencia3_depen4.add(value4.getDependencia_aux_2());
		}

		// recorremos desde la dependencia mas externa a la mas interna
		//en el if antes del for comprobamos que la dependecia se encuentre en la lista
		//despues del for comprobamos si es esa dependencia la que estamos buscando

		for (int i = 0; i < lista_valores1.size(); i++) {
			String nombre_depen1 = lista_nombre_depen1.get(i);
			String id_depen1 = lista_locale_depen1.get(i);
			if (lista_dependencia1_depen2.contains(nombre_depen1)) {
				for (int j = 0; j < lista_valores2.size(); j++) {
					if (lista_dependencia1_depen2.get(j).equals(nombre_depen1)) {
						
						String nombre_depen2 = lista_nombre_depen2.get(j);					
						String id_depen2 = id_depen1 + "_" + lista_locale_depen2.get(j);
						if (lista_dependencia2_depen3.contains(nombre_depen2)) {
							for (int k = 0; k < lista_valores3.size(); k++) {
								if (lista_dependencia2_depen3.get(k).equals(nombre_depen2)
										&& lista_dependencia1_depen3.get(k).equals(nombre_depen1)) {
									String nombre_depen3 = lista_nombre_depen3.get(k);
									String id_depen3 = id_depen2 + "_" + lista_locale_depen3.get(k);
									if (lista_dependencia3_depen4.contains(nombre_depen3)) {
										for (int l = 0; l < lista_valores4.size(); l++) {
											if (lista_dependencia3_depen4.get(l).equals(nombre_depen3)
													&& lista_dependencia2_depen4.get(l).equals(nombre_depen2)
													&& lista_dependencia1_depen4.get(l).equals(nombre_depen1)) {
												String nombre_depen4 = lista_nombre_depen4.get(l);

												String id_depen4 = id_depen3 + "_" + lista_locale_depen4.get(l);
												Taxo t = new Taxo(nombre_depen1, nombre_depen2, nombre_depen3,
														nombre_depen4, id_depen1, id_depen2, id_depen3, id_depen4);
												lista_taxonomia.add(t);
											}
										}
									} else {
										Taxo t = new Taxo(nombre_depen1, nombre_depen2, nombre_depen3, "", id_depen1,
												id_depen2, id_depen3, "");
										lista_taxonomia.add(t);
									}
								}
							}
						} else {
							Taxo t = new Taxo(nombre_depen1, nombre_depen2, "", "", id_depen1, id_depen2, "", "");
							lista_taxonomia.add(t);
						}
					}

				}
			} else {
				Taxo t = new Taxo(nombre_depen1, "", "", "", id_depen1, "", "", "");
				lista_taxonomia.add(t);
			}

		}
		
		

		return lista_taxonomia;

	}
}
