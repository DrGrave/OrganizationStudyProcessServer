package requests;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.Queue;
import com.vkkzlabs.api.entity.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.http.HTTPException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vadim on 21.08.17.
 */
public class QueueRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public Queue[] stayInQueue(Queue queue, String token){
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(queue, httpHeaders);
            HttpEntity<Queue[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/StayInQueue", HttpMethod.POST, entity, Queue[].class);
            return queueEntity.getBody();
        } catch (HttpClientErrorException exception){
            return null;
        }
    }

    public Queue[] getAllQueueToUser(Queue queue, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Queue[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/GetToStudent/"+queue.getTimetable().getIdTimetable(), HttpMethod.GET, entity, Queue[].class);
            return queueEntity.getBody();
        } catch (HttpClientErrorException ex){
            return null;
        }
    }

    public Queue[] getSubjectsToStudent(int idTimetable, int idUser, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Queue[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/GetSubjects/"+idUser+"/Timetable/"+idTimetable, HttpMethod.GET, entity, Queue[].class);
            return queueEntity.getBody();
        } catch (HttpClientErrorException ex) {
            return null;
        }
    }

    public Queue[] tryToGetQueueToUser(MyUser iUser, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Queue[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/TryGetQueueToStudent/"+iUser.getIdUser(), HttpMethod.GET, entity, Queue[].class);
            return queueEntity.getBody();
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
