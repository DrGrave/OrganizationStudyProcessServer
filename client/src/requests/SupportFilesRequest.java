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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        Path path = Paths.get("client/2.docx");

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path)) {
            @Override
            public String getFilename() {
                return "2.docx";
            }
        };
        data.add("file", resource);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data, requestHeaders);

        final ResponseEntity<String> responseEntity = restTemplate.exchange(REST_SERVICE_URI+"/File/Upload/Subject/"+id, HttpMethod.POST, requestEntity, String.class);
    }

    public byte[] downloadFile(int id, String token, String path) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        String outputStream;
        HttpEntity<?> entity = new HttpEntity<>(requestHeaders);
        HttpEntity<String> request =  restTemplate.exchange(REST_SERVICE_URI+"/File/Download/SubjSupF/"+id, HttpMethod.GET, entity, String.class);
        outputStream = request.getBody();
        HttpHeaders respHeaders = request.getHeaders();
        if (requestHeaders.get("Content-Disposition") != null)
        {
        List<String> str = requestHeaders.get("Content-Disposition");
        }
        FileOutputStream fos = new FileOutputStream(path+"/");
        fos.write(outputStream.getBytes());
        fos.close();
        return outputStream.getBytes();
    }
}
