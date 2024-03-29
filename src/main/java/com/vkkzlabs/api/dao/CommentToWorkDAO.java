package com.vkkzlabs.api.dao;

import com.vkkzlabs.api.entity.CommentToWork;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by vadim on 19.06.17.
 */
public interface CommentToWorkDAO extends CrudRepository<CommentToWork, Long> {
    CommentToWork getByIdCommentToWork(int idCommentToWork);
    List<CommentToWork> findAllByStudent_IdUserAndWork_IdOfWork(int idStudent, int idWork);
}
