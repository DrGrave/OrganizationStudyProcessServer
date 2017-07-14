package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.CommentToWorkDAO;
import com.vkkzlabs.entity.CommentToWork;
import com.vkkzlabs.service.CommentToWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentToWorkServiceImpl implements CommentToWorkService {
    @Autowired
    private CommentToWorkDAO commentToWorkDAO;

    @Override
    public void saveCommentToWork(CommentToWork commentToWork) {
        commentToWorkDAO.save(commentToWork);
    }

    @Override
    public CommentToWork getCommentToWorkByIdCommentToWork(int idCommentToWork) {
        return commentToWorkDAO.getByIdCommentToWork(idCommentToWork);
    }
}
