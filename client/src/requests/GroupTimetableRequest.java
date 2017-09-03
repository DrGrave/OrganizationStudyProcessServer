package requests;

import com.vkkzlabs.api.entity.M2MGroupTimetable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class GroupTimetableRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public void saveGroupTimetable(M2MGroupTimetable m2MGroupTimetable, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(m2MGroupTimetable, httpHeaders);
            HttpEntity<M2MGroupTimetable> timetableEntity = restTemplate.exchange(REST_SERVICE_URI + "/GroupTimetable/Save", HttpMethod.POST, entity, M2MGroupTimetable.class);

        } catch (HttpClientErrorException exception){
            exception.printStackTrace();
        }
    }
}
