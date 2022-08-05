package hotel;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("mapservice")
public class NaverMapService {
	
	public JsonNode get(String requestURL) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			String newURL1= requestURL.replaceAll(" ","");
			String newURL= newURL1.replaceAll(",","");
			HttpGet getRequest = new HttpGet("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+newURL);
			
			getRequest.setHeader("X-NCP-APIGW-API-KEY-ID", "hb8r593xf9");
			getRequest.setHeader("X-NCP-APIGW-API-KEY", "hZBvxuaDB6JRE2nbiDYRbnSa1q5JJ3wMzSThh6XR");

			HttpResponse response = client.execute(getRequest);
			System.out.println(response);
			//Response 출력
			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				String body = handler.handleResponse(response);

				ObjectMapper mapper = new ObjectMapper();
				JsonNode bodyJson = mapper.readTree(body);
				return bodyJson;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
