package com.vkkzlabs.impl.controller;


import com.vkkzlabs.api.entity.SubjectSupportFile;
import com.vkkzlabs.api.service.SubjectSupportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *  Данный класс предназначен для работы с путями файлов предназначенных для предметов
 */

@Controller
@RequestMapping("SubjectSupportFile")
public class SubjectSupportFileController {
    @Autowired
    SubjectSupportFileService subjectSupportFileService;

    @GetMapping("Subject/{id}")
    public ResponseEntity<List<SubjectSupportFile>> getSubjectSupportFilesBySubjectIdId(@PathVariable("id") Integer id) {
        List<SubjectSupportFile> supportingDataForWork = subjectSupportFileService.getListSubjectSupportFileByIdSubject(id);
        if (supportingDataForWork != null) {
            return new ResponseEntity<List<SubjectSupportFile>>(supportingDataForWork, HttpStatus.OK);
        } return new ResponseEntity<List<SubjectSupportFile>>(HttpStatus.NOT_FOUND);
    }
}
