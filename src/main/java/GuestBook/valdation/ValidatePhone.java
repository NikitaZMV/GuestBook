package GuestBook.valdation;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.GuestBookException;
import GuestBook.exeptions.InvalidPhoneException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ValidatePhone implements Validation {

    @Override
    public void validate(GuestBookEntity entity) throws GuestBookException {
        if (entity.getPhone() == null) {
            return;
        } else if (!isValidPhone(entity.getPhone())) {
            throw new InvalidPhoneException(entity.getId());
        }
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }
}
