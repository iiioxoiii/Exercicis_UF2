package forecast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class forecast {

    public static void main(String[] args) {
        //passem la ciutat en l'argument del main
        String current = forecast.getHTML("http://api.openweathermap.org/data/2.5/weather?q="+ args[0] +"&units=metric&appid=644da4f2a1231c6611d2e2d8abb1fc90");
        String [] array = netejar(current);

        System.out.println("Dades de la ciutat de "+ args[0]);
        System.out.println("Temperatura: "+ array[19]+"C");
        System.out.println("Temps: "+ array[12]);
        System.out.println("Humitat: "+ array[23]+"%");
        System.out.println("Pressió: "+ array[21]+" bars");
        System.out.println("Vent(velocitat): "+ array[32]);
        System.out.print("Vent(direccio): " + array[34]);
    }


    public static String [] netejar (String dades){
        dades = dades.replace(" ","ç");
        dades = dades.replace("{","");
        dades = dades.replace(":","");
        dades = dades.replace("[","");
        dades = dades.replace("}","");
        dades = dades.replace(",","");
        dades = dades.replace("]","");
        dades = dades.replace("\"\"","\"");
        dades = dades.replace("\""," ");

        String [] array = dades.split("\\s+");

        //netejem les parales amb la ç trencada
        for (int i = 0; i <array.length ; i++) {
            array[i]= array[i].replace("ç"," ");
        }

        return array;
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
