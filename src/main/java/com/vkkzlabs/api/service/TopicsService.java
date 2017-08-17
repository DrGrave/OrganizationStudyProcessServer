package com.vkkzlabs.api.service;

import com.vkkzlabs.api.entity.Topics;

/**
 * Created by vadim on 11.07.17.
 */
public interface TopicsService {
    void saveTopic(Topics topic);
    Topics getTopicByIdTopic(int idTopic);
}
