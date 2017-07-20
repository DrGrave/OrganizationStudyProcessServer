package requests;
import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


public class LoginController {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public String loginEvent(MyUserCredentials myUserCredentials) {
        System.out.println("Testing create User API----------");
        String string = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();



            HttpEntity<?> entity = new HttpEntity<>( myUserCredentials, httpHeaders ); // for request
            HttpEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/login", HttpMethod.POST, entity, String.class);
            String result= response.getBody();
            HttpHeaders headers = response.getHeaders();


            if (headers.get("Authorization") != null) {
                String str = headers.get("Authorization").get(0);
                return str;
            } return null;
        }catch (HttpClientErrorException ex){
            return null;
        }

    }

    public MyUser getUserByLogin(MyUserCredentials myUserCredentials, String token){
        MyUser myUser = new MyUser();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(myUserCredentials, httpHeaders);
        HttpEntity<MyUser> myUserCredentialsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/GetUser", HttpMethod.POST, entity, MyUser.class);
        myUser = myUserCredentialsHttpEntity.getBody();
        return myUser;
    }

}
