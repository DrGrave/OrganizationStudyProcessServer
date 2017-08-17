package com.vkkzlabs.api.service;


import com.vkkzlabs.api.entity.M2MGroupTimetable;

public interface GroupTimetableService {
    void saveGroupTimetable(M2MGroupTimetable groupTimetable);
    M2MGroupTimetable getGroupTimetableByIdGroupTimetable(int idGroupTimetable);
}
