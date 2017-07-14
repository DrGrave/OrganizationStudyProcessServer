package com.vkkzlabs.service.Impl;

import com.vkkzlabs.dao.TopicsDAO;
import com.vkkzlabs.entity.Topics;
import com.vkkzlabs.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
