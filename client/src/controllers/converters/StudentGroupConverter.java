package controllers.converters;

import com.vkkzlabs.api.entity.StudentGroup;
import com.vkkzlabs.api.entity.TypeOfWork;
import javafx.util.StringConverter;
import requests.StudentGroupRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static controllers.Controller.iUser;
import static controllers.Controller.token;

public class StudentGroupConverter extends StringConverter<StudentGroup> {

    @Override
    public String toString(StudentGroup object) {
        return object.getNumberOfGroup();
    }

    @Override
    public StudentGroup fromString(String string) {
        StudentGroupRequest studentGroupRequest = new StudentGroupRequest();
        StudentGroup[] studentGroups = studentGroupRequest.getAllProfessorsGroup(token, iUser);
        List<StudentGroup> studentGroupArrayList = new ArrayList<>();
        studentGroupArrayList.addAll(Arrays.asList(studentGroups));
        return studentGroupArrayList.get(Integer.parseInt(string));
    }
}
