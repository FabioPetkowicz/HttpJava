package usando_gson_google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class Json2Java {
	public static void main(String[] args) {

		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(new FileReader("E:\\temp\\file.json"));

			//Converte String JSON para objeto Java
			Informacoes obj = gson.fromJson(br, Informacoes.class);

			System.out.println(obj);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
