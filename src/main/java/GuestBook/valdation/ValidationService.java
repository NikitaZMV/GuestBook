package GuestBook.valdation;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.GuestBookException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ValidationService {
    private static final Set<Validation> VALIDATIONS = new HashSet<>();

    private static void addValidations() {
        VALIDATIONS.add(new ValidateNull());
        VALIDATIONS.add(new ValidatePhone());
        VALIDATIONS.add(new ValidateEmail());
        VALIDATIONS.add(new ValidateName());
    }

    public static void validate(GuestBookEntity entity) throws GuestBookException {
        addValidations();
        for (Validation validation : VALIDATIONS) {
            validation.validate(entity);
        }
    }
}
