package requests;


import com.vkkzlabs.entity.M2MStudentWork;
import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;

public class StudentWorksController {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public M2MStudentWork[] getSubjectsToList(int idUser, String token) {
        RestTemplate restTemplate = new RestTemplate();
        M2MStudentWork[] m2MStudentWork;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<M2MStudentWork[]> request =  restTemplate.exchange(REST_SERVICE_URI+"/StudentWork/subject/toStudentWorks/"+idUser, HttpMethod.GET, entity, M2MStudentWork[].class);
        m2MStudentWork = request.getBody();
        return m2MStudentWork;
    }

    public M2MStudentWork[] getWorksByUserIdAndSubjectId(MyUser iUser, Subject newValue, String token) {
        RestTemplate restTemplate = new RestTemplate();
        M2MStudentWork[] m2MStudentWorks;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<M2MStudentWork[]> request = restTemplate.exchange(REST_SERVICE_URI+"/StudentWork/User/"+iUser.getIdUser()+"/Subject/"+newValue.getIdSubject(), HttpMethod.GET, entity, M2MStudentWork[].class);
        m2MStudentWorks = request.getBody();
        return m2MStudentWorks;
    }

    public Date getServerDate(String token) {
        RestTemplate restTemplate = new RestTemplate();
        Date date;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<Date> request = restTemplate.exchange(REST_SERVICE_URI+"/GetServerDate/Get", HttpMethod.GET, entity, Date.class);
        date = request.getBody();
        return date;
    }
}
