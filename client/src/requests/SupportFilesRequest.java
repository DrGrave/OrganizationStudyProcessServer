package requests;

import com.vkkzlabs.entity.SubjectSupportFile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SupportFilesRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public SubjectSupportFile[] getSubjectSupportFileByIdSubject(int i, String token) {
        RestTemplate restTemplate = new RestTemplate();
        SubjectSupportFile[] subjectSupportFile;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<SubjectSupportFile[]> request =  restTemplate.exchange(REST_SERVICE_URI+"/SubjectSupportFile/Subject/"+i, HttpMethod.GET, entity, SubjectSupportFile[].class);
        subjectSupportFile = request.getBody();
        return subjectSupportFile;
    }

    public void sendFile(String fileInputStream, String token, int id) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
        Path path = Paths.get("client/3.rar");

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path)) {
            @Override
            public String getFilename() {
                return "f.rar";
            }
        };
        data.add("file", resource);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data, requestHeaders);

        final ResponseEntity<String> responseEntity = restTemplate.exchange(REST_SERVICE_URI+"/File/Upload/Subject/"+id, HttpMethod.POST, requestEntity, String.class);

    }
}
