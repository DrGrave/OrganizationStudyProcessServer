package com.vkkzlabs.service;

import com.vkkzlabs.dao.CommentToStudentDAO;
import com.vkkzlabs.entity.CommentToStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentToStudentServiceImpl implements CommentToStudentService{
    @Autowired
    private CommentToStudentDAO commentToStudentDAO;

    @Override
    public CommentToStudent getCommentToStudentByIdCommentToStudent(int idCommentToStudent) {
        return commentToStudentDAO.getByIdCommentOfStudent(idCommentToStudent);
    }
}
