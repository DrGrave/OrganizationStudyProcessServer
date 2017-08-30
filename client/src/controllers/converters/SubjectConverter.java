package controllers.converters;

import com.vkkzlabs.api.entity.Subject;
import javafx.util.StringConverter;

public class SubjectConverter extends StringConverter<Subject>{

    public SubjectConverter() {
        super();
    }

    @Override
    public String toString(Subject object) {
        return object.getNameSubject();
    }

    @Override
    public Subject fromString(String string) {
        Subject subject = new Subject();
        subject.setNameSubject(string);
        return subject;
    }
}
