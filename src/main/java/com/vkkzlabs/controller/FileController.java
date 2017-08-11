package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Subject;
import com.vkkzlabs.entity.SubjectSupportFile;
import com.vkkzlabs.service.SubjectService;
import com.vkkzlabs.service.SubjectSupportFileService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class FileController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectSupportFileService subjectSupportFileService;


    @RequestMapping(value = "File/Upload/Subject/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(@RequestParam("file") MultipartFile uploadfile, @PathVariable(value = "id") int id) throws IOException {
        Subject subject = subjectService.getSubjectByIdSubject(id);
        String realPathtoUploads =  request.getServletContext().getRealPath("/")+subject.getChair().getFaculty().getUniversity().getNameUniversity()+"/"+subject.getChair().getFaculty().getNameFaculty()+"/"+ subject.getChair().getNameChair()+"/"+subject.getNameSubject()+"/";
        if(! new File(realPathtoUploads).exists())
        {
            new File(realPathtoUploads).mkdirs();
        }
        SubjectSupportFile subjectSupportFile = new SubjectSupportFile();
        subjectSupportFile.setSubject(subject);
        String orgName = uploadfile.getOriginalFilename();
        subjectSupportFile.setNameOfFile(orgName);
        String filePath = realPathtoUploads + orgName;
        subjectSupportFile.setPath(filePath);
        subjectSupportFileService.saveSubjectSupportFile(subjectSupportFile);
        File dest = new File(filePath);
        uploadfile.transferTo(dest);
    }

    @RequestMapping(value = "File/Download/SubjSupF/{id}", method = RequestMethod.GET)
    public void getLogFile(HttpSession session, HttpServletResponse response,@PathVariable(value = "id") int id) throws Exception {

        try {
            String filePathToBeServed = subjectSupportFileService.getSubjectSupportFileByIdSupFile(id).getPath();//complete file name with path;
                    File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+subjectSupportFileService.getSubjectSupportFileByIdSupFile(id).getNameOfFile());
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}


