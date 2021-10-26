package lessons.util;

import api.entities.RegisteredUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import util.User;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpHelper {

    private static final String basePage = "https://charliebackendapi.azurewebsites.net/api/v1";
    private static final String authPage = basePage + "/accounts/auth";
    private static final Logger log = Logger.getLogger(HttpHelper.class);

    public static RegisteredUser logInAPI(User user) throws Exception {
        URL url = new URL(authPage);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Authorization", "Bearer {token}");
        http.setRequestProperty("Content-Type", "application/json");
        String data = "{ \"email\": \"" +user.getMail()+"\", \"password\":\"" + user.getPass() + "\"}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        stream.close();
        int responseCode = http.getResponseCode();
        InputStream inputStream;
        if (200 <= responseCode && responseCode <= 299) {
            inputStream = http.getInputStream();
        } else {
            inputStream = http.getErrorStream();
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        inputStream));
        RegisteredUser userApi = new ObjectMapper().readValue(in.readLine(), RegisteredUser.class);
        log.info("Logged in as " + userApi.getFirstName() + " " + userApi.getLastName());
        userApi.setToken(http.getHeaderField("Authorization"));
        in.close();
        http.disconnect();
        return userApi;
    }

    public static boolean postRequest(String address, String data, String token) throws IOException {
        URL url = new URL(address);
        HttpURLConnection http= (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json-patch+json");
        http.addRequestProperty("Authorization", token);
        OutputStream os = http.getOutputStream();
        os.write(data.getBytes(StandardCharsets.UTF_8));
        os.close();
        int code = http.getResponseCode();
        if(http.getResponseCode() >= 200 && http.getResponseCode() < 300){
            log.info(http.getResponseCode() +" "+ http.getResponseMessage());
            return true;
        }
        return false;
    }
}
