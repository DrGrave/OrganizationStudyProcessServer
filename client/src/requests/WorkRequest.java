package requests;

import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Work;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class WorkRequest {

    private static final String REST_SERVICE_URI = "http://localhost:8080";
    public Work[] listAllWorksSubjectProfessor(int idUser, int idSubject, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Work[]> workEntity = restTemplate.exchange(REST_SERVICE_URI + "/Work/ListToProfessor/"+ idUser +"/Subject/"+idSubject, HttpMethod.GET, entity, Work[].class);
            return workEntity.getBody();
        } catch (HttpClientErrorException ex){
            return null;
        }
    }

    public Subject[] listOfSubjectToAddWorks(int idUser, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Subject[]> subjectEntity = restTemplate.exchange(REST_SERVICE_URI + "/ProfessorSubject/GetSubjects/"+idUser, HttpMethod.GET, entity, Subject[].class);
            return subjectEntity.getBody();
        } catch (HttpClientErrorException ex){
            return null;
        }
    }

    public void deleteWork(Work selectedItem, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(selectedItem, httpHeaders);
            HttpEntity<Work[]> workEntity = restTemplate.exchange(REST_SERVICE_URI + "/Work/Delete", HttpMethod.POST, entity, Work[].class);
        } catch (HttpClientErrorException exception){
            exception.printStackTrace();
        }
    }

    public void updateWork(Work work, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(work, httpHeaders);
            HttpEntity<Work[]> workEntity = restTemplate.exchange(REST_SERVICE_URI + "/Work/Change", HttpMethod.POST, entity, Work[].class);
        } catch (HttpClientErrorException exception){
            exception.printStackTrace();
        }
    }

    public void createWork(Work work, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(work, httpHeaders);
            HttpEntity<Work[]> workEntity = restTemplate.exchange(REST_SERVICE_URI + "/Work/Save", HttpMethod.POST, entity, Work[].class);
        } catch (HttpClientErrorException exception){
            exception.printStackTrace();
        }
    }
}
