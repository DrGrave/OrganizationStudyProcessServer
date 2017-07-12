package com.vkkzlabs.service;

import com.vkkzlabs.entity.Topics;

/**
 * Created by vadim on 11.07.17.
 */
public interface TopicsService {
    void saveTopic(Topics topic);
    Topics getTopicByIdTopic(int idTopic);
}
