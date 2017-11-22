import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        HttpURLConnection http = new HttpURLConnection();
        try {
         //   http.GetCustomerAccountBalances("60659");
        //    http.GetCustomerLastTransaction("60659");
            http.healthCheck("Sql/DemoAccountingMicroservice");
        } catch (Exception e) {
            e.printStackTrace();
        }
    //    System.out.println(readHTML());


    }



    public static String readHTML(){
        String result = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src\\main\\resources\\report.html"), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                result+=line;
            }
        } catch (IOException e) {
            // log error
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log warning
                }
            }
        }

        return result;

    }
}
