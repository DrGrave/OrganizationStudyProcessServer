package requests;

import com.vkkzlabs.entity.TypeOfAcceptWork;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class TypeOfAcceptWorkRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";
    public TypeOfAcceptWork getTypeOfAcceptWorkById(int i, String token) {
            RestTemplate restTemplate = new RestTemplate();
            TypeOfAcceptWork typeOfAcceptWork;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<TypeOfAcceptWork> request =  restTemplate.exchange(REST_SERVICE_URI+"/TypeOfAcceptWork/"+i, HttpMethod.GET, entity, TypeOfAcceptWork.class);
            typeOfAcceptWork = request.getBody();
            return typeOfAcceptWork;
    }
}
