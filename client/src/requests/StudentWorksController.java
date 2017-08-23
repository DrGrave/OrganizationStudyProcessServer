package requests;


import com.vkkzlabs.api.entity.M2MStudentWork;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Work;
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
        HttpEntity<M2MStudentWork[]> request =  restTemplate.exchange(REST_SERVICE_URI+"/StudentWork/Subject/ToStudentWorks/"+idUser, HttpMethod.GET, entity, M2MStudentWork[].class);
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

    public M2MStudentWork[] getStudentWorks(int idUser, String token){
        RestTemplate restTemplate = new RestTemplate();
        M2MStudentWork[] m2MStudentWork;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<M2MStudentWork[]> request =  restTemplate.exchange(REST_SERVICE_URI+"/StudentWork/Student/Works/"+idUser, HttpMethod.GET, entity, M2MStudentWork[].class);
        m2MStudentWork = request.getBody();
        return m2MStudentWork;
    }

    public void updateWork(M2MStudentWork work, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(work, httpHeaders);
        HttpEntity<Work> request = restTemplate.exchange(REST_SERVICE_URI+"/StudentWork/Edit", HttpMethod.POST, entity, Work.class);
    }

    public M2MStudentWork[] getAllNewWork(int idUser, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<M2MStudentWork[]> request = restTemplate.exchange(REST_SERVICE_URI+"/StudentWork/GetNewWorks/"+idUser, HttpMethod.GET, entity, M2MStudentWork[].class);
        M2MStudentWork[] works = request.getBody();
        return works;
    }

}
