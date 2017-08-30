package requests;

import com.vkkzlabs.api.entity.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SubjectRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public Subject[] getSubjectsToProfessor(int idUser, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Subject[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/ProfessorSubject/GetSubjects/"+idUser, HttpMethod.GET, entity, Subject[].class);
            return queueEntity.getBody();
        } catch (HttpClientErrorException ex) {
            return null;
        }
    }
}
