package requests;

import com.vkkzlabs.entity.M2MUserSettings;
import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.UserSettings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SettingsRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public M2MUserSettings getSettingByUserAndSittingId(MyUser iUser, String token, int i) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            M2MUserSettings userSettings;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", token);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<M2MUserSettings> request = restTemplate.exchange(REST_SERVICE_URI + "/UserSettings/User/" + iUser.getIdUser() + "/Setting/" + i, HttpMethod.GET, entity, M2MUserSettings.class);
            userSettings = request.getBody();
            return userSettings;
        }catch (HttpClientErrorException e){
            return null;
        }
    }

    public UserSettings getSettingById(int i, String token) {
        RestTemplate restTemplate = new RestTemplate();
        UserSettings userSettings;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<UserSettings> request =  restTemplate.exchange(REST_SERVICE_URI+"/Settings/"+i, HttpMethod.GET, entity, UserSettings.class);
        userSettings = request.getBody();
        return userSettings;
    }

    public void saveUserSetting(M2MUserSettings m2MUserSettings, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(m2MUserSettings, httpHeaders);
        HttpEntity<M2MUserSettings> myUserCredentialsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/UserSettings/Save", HttpMethod.POST, entity, M2MUserSettings.class);
    }

    public void editUserSetting(M2MUserSettings m2MUserSettings, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(m2MUserSettings, httpHeaders);
        HttpEntity<M2MUserSettings> myUserCredentialsHttpEntity = restTemplate.exchange(REST_SERVICE_URI+"/UserSettings/Edit", HttpMethod.POST, entity, M2MUserSettings.class);
    }
}
