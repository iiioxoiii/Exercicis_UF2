package forecast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class forecast {

    public static void main(String[] args) {
        //passem la ciutat en l'argument del main
        String current = forecast.getHTML("http://api.openweathermap.org/data/2.5/weather?q="+ "Barcelona" +"&units=metric&appid=644da4f2a1231c6611d2e2d8abb1fc90");
        System.out.println(current);
    }


    /**
     * Rep una URL i retorna el resultat de cridar-la
     * @param urlToRead URL
     * @return Retorn del servidor al cridar la URL
     */
    public static String getHTML(String urlToRead) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        }
        catch (Exception e) {
            return "";
        }
    }


}
