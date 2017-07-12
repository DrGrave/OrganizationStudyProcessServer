package com.vkkzlabs.service;

import com.vkkzlabs.entity.CommentToStudent;

/**
 * Created by vadim on 11.07.17.
 */
public interface CommentToStudentService {
    void saveCommentToStudent(CommentToStudent commentToStudent);
    CommentToStudent getCommentToStudentByIdCommentToStudent(int idCommentToStudent);
}
