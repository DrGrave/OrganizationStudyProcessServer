package com.vkkzlabs.service;

import com.vkkzlabs.dao.CommentToWorkDAO;
import com.vkkzlabs.entity.CommentToWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentToWorkServiceImpl implements CommentToWorkService{
    @Autowired
    CommentToWorkDAO commentToWorkDAO;

    @Override
    public CommentToWork getCommentToWorkByIdCommentToWork(int idCommentToWork) {
        return commentToWorkDAO.getByIdCommentToWork(idCommentToWork);
    }
}
