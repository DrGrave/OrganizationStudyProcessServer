package com.vkkzlabs.dao;

import com.vkkzlabs.entity.CommentToStudent;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vadim on 19.06.17.
 */
public interface CommentToStudentDAO extends CrudRepository<CommentToStudent, Long> {
    CommentToStudent findByIdCommentOfStudent(int id);
}
