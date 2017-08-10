package com.vkkzlabs.controller;

import com.vkkzlabs.entity.Subject;
import com.vkkzlabs.entity.SubjectSupportFile;
import com.vkkzlabs.service.SubjectService;
import com.vkkzlabs.service.SubjectSupportFileService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.exceptions.TemplateEngineException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

}


