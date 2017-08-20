package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.CommentToWorkDAO;
import com.vkkzlabs.api.entity.CommentToWork;
import com.vkkzlabs.api.service.CommentToWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  сервис для работы с комментариями на работы студента
 */

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

    @Override
    public List<CommentToWork> getAllCommentsToWork(Integer idUser, Integer idWork) {
        return commentToWorkDAO.findAllByStudent_IdUserAndWork_IdOfWork(idUser, idWork);
    }
}
