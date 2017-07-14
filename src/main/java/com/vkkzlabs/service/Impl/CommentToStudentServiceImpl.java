package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.CommentToStudentDAO;
import com.vkkzlabs.entity.CommentToStudent;
import com.vkkzlabs.service.CommentToStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentToStudentServiceImpl implements CommentToStudentService {
    @Autowired
    private CommentToStudentDAO commentToStudentDAO;

    @Override
    public void saveCommentToStudent(CommentToStudent commentToStudent) {
        commentToStudentDAO.save(commentToStudent);
    }

    @Override
    public CommentToStudent getCommentToStudentByIdCommentToStudent(int idCommentToStudent) {
        return commentToStudentDAO.getByIdCommentOfStudent(idCommentToStudent);
    }
}
