package requests;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.Timetable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vadim on 21.08.17.
 */
public class TimetableRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public Timetable getTimetableByProfessorIdAndSubjectId(MyUser myUser, int idSubject, String token){
        try {
            Timetable timetable;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Timetable> timetableHttpEntity = restTemplate.exchange(REST_SERVICE_URI + "/Timetable/GetToStudent/IdProfessor/" + myUser.getIdUser() + "/IdSubject/" + idSubject, HttpMethod.GET, entity, Timetable.class);
            timetable = timetableHttpEntity.getBody();
            return timetable;
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
