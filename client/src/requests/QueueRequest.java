package requests;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.Queue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vadim on 21.08.17.
 */
public class QueueRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public Queue[] stayInQueue(Queue queue, String token){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(queue, httpHeaders);
        HttpEntity<Queue[]> myUserCredentialsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/Queue/StayInQueue", HttpMethod.POST, entity, Queue[].class);
        Queue[] getQueue = myUserCredentialsHttpEntity.getBody();
        return getQueue;
    }
}
