package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.CommentToWork;

import java.util.List;

/**
 * Created by vadim on 11.07.17.
 */
public interface CommentToWorkService {
    void saveCommentToWork(CommentToWork commentToWork);
    CommentToWork getCommentToWorkByIdCommentToWork(int idCommentToWork);

    List<CommentToWork> getAllCommentsToWork(Integer idUser, Integer idWork);
}
