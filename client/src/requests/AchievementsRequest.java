package requests;


import com.vkkzlabs.entity.Achievements;
import com.vkkzlabs.entity.M2MUserAchievements;
import com.vkkzlabs.entity.MyUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class AchievementsRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public M2MUserAchievements[] getAchievementByUser(MyUser myUser, String token){
        M2MUserAchievements[] achievements;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<M2MUserAchievements[]> achievementsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/UserAchievement/IdUser/"+myUser.getIdUser(), HttpMethod.GET, entity, M2MUserAchievements[].class);
        achievements = achievementsHttpEntity.getBody();
        return achievements;
    }
}
