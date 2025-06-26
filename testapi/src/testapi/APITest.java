package testapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class APITest {
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		String apiKey = "6a594745646b696d3435774a61436d";
        String urlStr = "http://openapi.seoul.go.kr:8088/" + apiKey + "/json/TbVwAttractions/1/10/";
        
        URL url = new URL(urlStr);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        System.out.println("응답코드: " + conn.getResponseCode());

        BufferedReader rd = new BufferedReader(
            new InputStreamReader(conn.getInputStream(), "UTF-8")
        );
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();
        
        System.out.println(sb);
//        
//        JsonArray rows = json.getAsJsonObject("TbVwAttractions").getAsJsonArray("row");
//
//        Gson gson = new Gson();
//        
	}
}
