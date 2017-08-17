package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.TopicsDAO;
import com.vkkzlabs.api.entity.Topics;
import com.vkkzlabs.api.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Сервис для работы с темами
 */

@Service
public class TopicsServiceImpl implements TopicsService {
    @Autowired
    private TopicsDAO topicsDAO;

    @Override
    public void saveTopic(Topics topic) {
        topicsDAO.save(topic);
    }

    @Override
    public Topics getTopicByIdTopic(int idTopic) {
        return topicsDAO.getByIdTopic(idTopic);
    }
}
