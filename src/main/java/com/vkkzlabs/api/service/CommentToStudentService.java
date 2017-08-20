package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.CommentToStudent;

/**
 * Created by vadim on 11.07.17.
 */
public interface CommentToStudentService {
    void saveCommentToStudent(CommentToStudent commentToStudent);
    CommentToStudent getCommentToStudentByIdCommentToStudent(int idCommentToStudent);
}
