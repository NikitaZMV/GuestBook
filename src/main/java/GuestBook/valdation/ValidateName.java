package GuestBook.valdation;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.GuestBookException;
import GuestBook.exeptions.WrongNameException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ValidateName implements Validation {
    @Override
    public void validate(GuestBookEntity entity) throws GuestBookException {
        if (entity.getUsername().matches("(.*)Козлов(.*)")) {
            throw new WrongNameException();
        } else if (!isValidName(entity.getUsername())) {
            throw new WrongNameException(entity.getId());
        }
    }

    public static boolean isValidName(String name) {
        return name.matches("^[A-ЯЁ][а-яё]+\\s[A-ЯЁ][а-яё]+$");
    }
}
