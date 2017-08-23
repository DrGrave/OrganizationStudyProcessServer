package requests;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



public class LoginController {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public String loginEvent(MyUserCredentials myUserCredentials) {
        System.out.println("Testing create User API----------");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>( myUserCredentials, httpHeaders ); // for request
            HttpEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/login", HttpMethod.POST, entity, String.class);
            HttpHeaders headers = response.getHeaders();
            if (headers.get("Authorization") != null) {
                return headers.get("Authorization").get(0);
            } return null;
        }catch (HttpClientErrorException ex){
            return null;
        }

    }

    public MyUser getUserByLogin(MyUserCredentials myUserCredentials, String token){
        MyUser myUser;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(myUserCredentials, httpHeaders);
        HttpEntity<MyUser> myUserCredentialsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/GetUser", HttpMethod.POST, entity, MyUser.class);
        myUser = myUserCredentialsHttpEntity.getBody();
        return myUser;
    }

}
