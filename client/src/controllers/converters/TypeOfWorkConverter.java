package controllers.converters;

import com.vkkzlabs.api.entity.TypeOfWork;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeOfWorkConverter extends StringConverter<TypeOfWork> {
    @Override
    public String toString(TypeOfWork object) {
        return object.getNameTypeOfWOrk();
    }

    @Override
    public TypeOfWork fromString(String string) {
        //GetTypeOfWorkControl getTypeOfWorkControl = new GetTypeOfWorkControl();
        TypeOfWork[] typeOfWorks = new TypeOfWork[0];
        List<TypeOfWork> typeOfWorkArrayList = new ArrayList<>();
        typeOfWorkArrayList.addAll(Arrays.asList(typeOfWorks));
        return typeOfWorkArrayList.get(Integer.parseInt(string));
    }
}