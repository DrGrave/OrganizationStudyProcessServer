package requests;

import com.vkkzlabs.api.entity.M2MGroupTimetable;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.StudentGroup;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class StudentGroupRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public StudentGroup[] getAllProfessorsGroup(String token, MyUser iUser) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<StudentGroup[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Group/GetGroupsToProfessor/"+iUser.getIdUser(), HttpMethod.GET, entity, StudentGroup[].class);
            return queueEntity.getBody();
        } catch (HttpClientErrorException ex) {
            return null;
        }
    }


}
