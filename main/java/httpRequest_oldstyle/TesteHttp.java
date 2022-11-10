package httpRequest_oldstyle;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
//https://www.twilio.com/blog/5-maneiras-de-fazer-uma-chamada-http-em-java
public class TesteHttp {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestProperty("accept", "application/json");

		InputStream responseStream = connection.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
//		String s = mapper.readValue(responseStream, String.class);
		
		APOD apod = mapper.readValue(responseStream, APOD.class);
		System.out.println(apod.title);
		System.out.println(apod.date);
		
//		System.out.println(s);

	}

}
