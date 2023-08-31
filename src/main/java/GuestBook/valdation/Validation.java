package GuestBook.valdation;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.GuestBookException;
import org.springframework.stereotype.Service;

@Service
public interface Validation {
    void validate(GuestBookEntity entity) throws GuestBookException;
}
