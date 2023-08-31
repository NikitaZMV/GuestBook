package GuestBook.service;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.*;
import GuestBook.dto.GuestBookDto;
import GuestBook.repository.GuestBookRepo;
import GuestBook.valdation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookService {

    @Autowired
    private GuestBookRepo guestBookRepo;

    public GuestBookDto<Long> saveMessage(GuestBookEntity post) throws GuestBookException {
        ValidationService.validate(post);
        guestBookRepo.save(post);
        return new GuestBookDto<>(post.getId());
    }

    public GuestBookDto<GuestBookEntity> getOne(Long id) throws GuestBookException {
        if (guestBookRepo.findById(id).isEmpty()) {
            throw new GuestPostNotFoundException(id);
        }
        return new GuestBookDto<>(guestBookRepo.findById(id).orElseThrow());
    }

    public GuestBookDto<Long> delete(long id) throws GuestBookException {
        if (guestBookRepo.findById(id).isEmpty()) {
            throw new GuestPostNotFoundException(id);
        }
        guestBookRepo.deleteById(id);
        return new GuestBookDto<>(id);
    }

    public GuestBookDto<Long> put(GuestBookEntity post) throws GuestBookException {
        if (!guestBookRepo.existsById(post.getId())) {
            throw new GuestPostNotFoundException(post.getId());
        }
        GuestBookEntity edited = guestBookRepo.findById(post.getId()).get();
        edited.setText(post.getText());
        guestBookRepo.save(edited);
        return new GuestBookDto<>(post.getId());
    }
}
