package controllers.converters;

import com.vkkzlabs.api.entity.TypeOfWork;
import javafx.util.StringConverter;
import requests.TypeOfWorkRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static controllers.Controller.token;

public class TypeOfWorkConverter extends StringConverter<TypeOfWork> {
    @Override
    public String toString(TypeOfWork object) {
        return object.getNameTypeOfWOrk();
    }

    @Override
    public TypeOfWork fromString(String string) {
        TypeOfWorkRequest getTypeOfWorkControl = new TypeOfWorkRequest();
        TypeOfWork[] typeOfWorks = getTypeOfWorkControl.listAllTypesOfWork(token);
        List<TypeOfWork> typeOfWorkArrayList = new ArrayList<>();
        typeOfWorkArrayList.addAll(Arrays.asList(typeOfWorks));
        return typeOfWorkArrayList.get(Integer.parseInt(string));
    }
}