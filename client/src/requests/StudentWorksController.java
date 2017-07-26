package requests;


import com.vkkzlabs.entity.M2MStudentWork;
import org.springframework.web.client.RestTemplate;

public class StudentWorksController {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public M2MStudentWork[] getSubjectsToList(int idUser) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(REST_SERVICE_URI+"/StudentWork/subject/toStudentWorks/"+idUser, M2MStudentWork[].class);
    }
}
