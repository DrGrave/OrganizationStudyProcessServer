package com.vkkzlabs.service;


import com.vkkzlabs.entity.M2MGroupTimetable;

public interface GroupTimetableService {
    void saveGroupTimetable(M2MGroupTimetable groupTimetable);
    M2MGroupTimetable getGroupTimetableByIdGroupTimetable(int idGroupTimetable);
}
