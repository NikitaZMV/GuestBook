package GuestBook.valdation;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.GuestBookException;
import GuestBook.exeptions.InvalidModelException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ValidateNull implements Validation {
    @Override
    public void validate(GuestBookEntity entity) throws GuestBookException {
        if (entity.getEmail() == null || entity.getUsername() == null || entity.getText() == null) {
            throw new InvalidModelException(entity.getId());
        }
    }
}
