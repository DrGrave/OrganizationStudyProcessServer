package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.CommentToStudent;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vadim on 19.06.17.
 */
public interface CommentToStudentDAO extends CrudRepository<CommentToStudent, Long> {
    CommentToStudent getByIdCommentOfStudent(int idCommentToStudent);
}
