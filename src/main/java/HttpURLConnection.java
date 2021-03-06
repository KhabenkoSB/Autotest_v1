import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.xerces.dom3.as.ASElementDeclaration;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;


public class HttpURLConnection {

    // HTTP POST request
    public synchronized String GetCustomerAccountBalances(String param1) throws Exception {
        String url = "http://kyiv-win-inf01:"+param1+"/Sql/DemoAccountingMicroservice/GetCustomerAccountBalances";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
      //  post.setHeader("Authorization", "Basic U3VwZXJ2aXNvcjpTdXBlcnZpc29y");
        HashMap<String,String> map = new HashMap();
        map.put("CustomerID","0");


        Gson gson = new Gson();
        StringEntity entity = new StringEntity(gson.toJson(map));

        System.out.println(entity);

        post.setEntity(entity);
        System.out.println(post.getEntity().getContentType());
        System.out.println(post.getEntity());

        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity responseEntity = response.getEntity();
       // System.out.println(response.getStatusLine());
        String result = EntityUtils.toString(responseEntity);
        System.out.println(result);
        return result;

    }


    // HTTP POST request
    public synchronized String GetCustomerLastTransaction(String param1) throws Exception {
        String url = "http://kyiv-win-inf01:"+param1+"/Sql/DemoAccountingMicroservice/GetCustomerLastTransaction";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
        //  post.setHeader("Authorization", "Basic U3VwZXJ2aXNvcjpTdXBlcnZpc29y");
        HashMap<String,String> map = new HashMap();
        map.put("CustomerID","0");


        Gson gson = new Gson();
        StringEntity entity = new StringEntity(gson.toJson(map));

       // System.out.println(entity);

        post.setEntity(entity);
        System.out.println(post.getEntity().getContentType());
        System.out.println(post.getEntity());

        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity responseEntity = response.getEntity();
        // System.out.println(response.getStatusLine());
        String result = EntityUtils.toString(responseEntity);
        System.out.println(result);
        return result;

    }


    public synchronized boolean healthCheck(String param1) throws Exception {
        String url = "http://kyiv-win-inf01:9999/"+param1+"/healthCheck";
        System.out.println(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet post = new HttpGet(url);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
        HashMap<String,String> map = new HashMap();
        Gson gson = new Gson();
        StringEntity entity = new StringEntity(gson.toJson(map));
        System.out.println(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity responseEntity = response.getEntity();
        System.out.println(response.getStatusLine());
        String result = EntityUtils.toString(responseEntity);
        System.out.println(result);
        HealthCheck healthCheck = gson.fromJson(result,HealthCheck.class);
       return healthCheck.isAlive();


    }








}