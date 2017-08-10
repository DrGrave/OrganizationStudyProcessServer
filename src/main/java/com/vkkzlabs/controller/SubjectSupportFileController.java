package com.vkkzlabs.controller;


import com.vkkzlabs.entity.SubjectSupportFile;
import com.vkkzlabs.service.SubjectSupportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("SubjectSupportFile")
public class SubjectSupportFileController {
    @Autowired
    SubjectSupportFileService subjectSupportFileService;

    @GetMapping("Subject/{id}")
    public ResponseEntity<List<SubjectSupportFile>> getSubjectSupportFilesBySubjectIdId(@PathVariable("id") Integer id) {
        List<SubjectSupportFile> supportingDataForWork = subjectSupportFileService.getSubjectSupportFileByIdSubject(id);
        if (supportingDataForWork != null) {
            return new ResponseEntity<List<SubjectSupportFile>>(supportingDataForWork, HttpStatus.OK);
        } return new ResponseEntity<List<SubjectSupportFile>>(HttpStatus.NOT_FOUND);
    }
}
