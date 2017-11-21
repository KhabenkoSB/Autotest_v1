public class Main {
    public static void main(String[] args) {
        HttpURLConnection http = new HttpURLConnection();
        try {
            http.GetCustomerAccountBalances("51921");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
