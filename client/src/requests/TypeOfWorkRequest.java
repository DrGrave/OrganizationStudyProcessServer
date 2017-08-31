package requests;

import com.vkkzlabs.api.entity.TypeOfWork;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class TypeOfWorkRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public TypeOfWork[] listAllTypesOfWork(String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<TypeOfWork[]> typeOfWorkEntity = restTemplate.exchange(REST_SERVICE_URI + "/TypeOfWork/GetAll", HttpMethod.GET, entity, TypeOfWork[].class);
            return typeOfWorkEntity.getBody();
        } catch (HttpClientErrorException ex){
            return null;
        }
    }
}
