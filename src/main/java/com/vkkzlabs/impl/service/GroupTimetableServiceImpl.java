package com.vkkzlabs.impl.service;

import com.vkkzlabs.api.dao.GroupTimetableDAO;
import com.vkkzlabs.api.entity.M2MGroupTimetable;
import com.vkkzlabs.api.service.GroupTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupTimetableServiceImpl implements GroupTimetableService {
    @Autowired
    private GroupTimetableDAO groupTimetableDAO;

    @Override
    public void saveGroupTimetable(M2MGroupTimetable groupTimetable) {
        groupTimetableDAO.save(groupTimetable);
    }

    @Override
    public M2MGroupTimetable getGroupTimetableByIdGroupTimetable(int idGroupTimetable) {
        return groupTimetableDAO.getByIdGroupTimetable(idGroupTimetable);
    }
}
