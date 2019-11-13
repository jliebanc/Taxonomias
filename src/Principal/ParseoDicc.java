package Principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseoDicc {
	public static ArrayList<Dato> parseoDicc(String ruta, int num, int name, int locale, int depen1, int depen2,
			int depen3) {
		BufferedReader br = null;
		String line = "";
		String splitPuntoComa = ";";
		ArrayList<Dato> lista = new ArrayList<Dato>();

		try {
			// volcamos los datos del excel
			br = new BufferedReader(new FileReader(ruta));
			while ((line = br.readLine()) != null) {

				// separamos las filas (el csv esta separado por ";")
				String[] data = line.split(splitPuntoComa);
				String nombre = data[1];
				if (!nombre.equals("object_name")) {
					if (num == 0) {
						Dato d = new Dato(data[name], data[locale], "", "", "");
						lista.add(d);
					} else if (num == 1) {
						Dato d = new Dato(data[name], data[locale], data[depen1], "", "");
						lista.add(d);
					} else if (num == 2) {
						Dato d = new Dato(data[name], data[locale], data[depen1], data[depen2], "");
						lista.add(d);

					} else if (num == 3) {
						Dato d = new Dato(data[name], data[locale], data[depen1], data[depen2], data[depen3]);
						lista.add(d);

					}
				}
			}

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return lista;

	}
}
