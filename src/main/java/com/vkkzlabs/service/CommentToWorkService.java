package com.vkkzlabs.service;

import com.vkkzlabs.entity.CommentToWork;

/**
 * Created by vadim on 11.07.17.
 */
public interface CommentToWorkService {
    void saveCommentToWork(CommentToWork commentToWork);
    CommentToWork getCommentToWorkByIdCommentToWork(int idCommentToWork);
}
