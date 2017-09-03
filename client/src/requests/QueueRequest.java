package requests;

import com.vkkzlabs.api.entity.*;
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

    public Queue[] getAllQueueToUser(Timetable timetable, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Queue[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/GetByTimetable/"+timetable.getIdTimetable(), HttpMethod.GET, entity, Queue[].class);
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

    public void deleteQueueByQueue(int timetable, int idOfWork, int studentId, String token) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("Authorization", token);
                HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
                HttpEntity<Work[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/Delete/Timetable/"+timetable+"/Work/"+idOfWork+"/Student/"+studentId, HttpMethod.GET, entity, Work[].class);
            } catch (HttpClientErrorException exception){
                exception.printStackTrace();
            }
    }

    public Work[] listOfWorksQueueToStudent(int idUser, Timetable nowTimetable,String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Work[]> queueEntity = restTemplate.exchange(REST_SERVICE_URI + "/Queue/Student/"+idUser+"/Timetable/"+nowTimetable.getIdTimetable(), HttpMethod.GET, entity, Work[].class);
            return queueEntity.getBody();
        } catch (HttpClientErrorException exception){
            exception.printStackTrace();
            return null;
        }
    }
}
