package com.vkkzlabs.service;

import com.vkkzlabs.dao.TopicsDAO;
import com.vkkzlabs.entity.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicsServiceImpl implements TopicsService{
    @Autowired
    private TopicsDAO topicsDAO;

    @Override
    public Topics getTopicByIdTopic(int idTopic) {
        return topicsDAO.getByIdTopic(idTopic);
    }
}
