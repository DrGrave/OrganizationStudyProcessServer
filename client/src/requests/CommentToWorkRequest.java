package requests;

import com.vkkzlabs.api.entity.CommentToWork;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.Work;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class CommentToWorkRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public CommentToWork[] getCommentsToWorkByIdUserAndIdWork(MyUser myUser,int idWork, String token){
        CommentToWork[] commentToWorks;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<CommentToWork[]> achievementsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/CommentToWork/IdUser/"+myUser.getIdUser()+"/IdWork/"+idWork, HttpMethod.GET, entity, CommentToWork[].class);
        commentToWorks = achievementsHttpEntity.getBody();
        return commentToWorks;
    }
}
