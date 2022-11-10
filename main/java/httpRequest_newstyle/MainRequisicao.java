package httpRequest_newstyle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

//https://simplificandoredes.com/http-requisicoes-get-post-api-java/
//https://github.com/julianazanelatto/HTTPClient/blob/master/src/com/httpexamples/getRequest.java
public class MainRequisicao {

	public static void main(String[] args) throws IOException, InterruptedException {
		//"http://httpbin.org/get"
		//https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
		final String URL_GET = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"; 
		
		// cliente HTTP
		HttpClient client = HttpClient.newHttpClient();
		// criar a requisição
		HttpRequest request = HttpRequest.newBuilder()
		          .GET()
		          .timeout(Duration.ofSeconds(10))
		          .uri(URI.create(URL_GET))
		          .build();
		
		// enviando uma solicitação
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.toString());
		System.out.println("======================");
		//imprimir o conteúdo recebido
		System.out.println(response.statusCode());
		System.out.println(response.body());
		System.out.println(response.uri());
		System.out.println(response.headers());
		
	}

}
