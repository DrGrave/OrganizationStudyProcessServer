package com.vkkzlabs.service;

import com.vkkzlabs.dao.GroupTimetableDAO;
import com.vkkzlabs.entity.M2MGroupTimetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupTimetableServiceImpl implements GroupTimeTableService{
    @Autowired
    private GroupTimetableDAO groupTimetableDAO;

    @Override
    public M2MGroupTimetable getGroupTimetableByIdGroupTimetable(int idGroupTimetable) {
        return groupTimetableDAO.getByIdGroupTimetable(idGroupTimetable);
    }
}
