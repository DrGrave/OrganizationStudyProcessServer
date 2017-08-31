package requests;

import com.vkkzlabs.api.entity.Timetable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EventsRequest {

    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public Timetable[] getAllEvents(int iUser, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Timetable[]> eventEntity = restTemplate.exchange(REST_SERVICE_URI + "/Timetable/GetAllTimetable/"+iUser, HttpMethod.GET, entity, Timetable[].class);
            return eventEntity.getBody();
        } catch (HttpClientErrorException ex){
            return null;
        }
    }

    public Timetable saveEvent(Timetable timetable, String token) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("Authorization", token);
                HttpEntity<?> entity = new HttpEntity<>(timetable, httpHeaders);
                HttpEntity<Timetable> timetableEntity = restTemplate.exchange(REST_SERVICE_URI + "/Timetable/Save", HttpMethod.POST, entity, Timetable.class);
                return timetableEntity.getBody();
            } catch (HttpClientErrorException exception){
                return null;
            }

    }
}
