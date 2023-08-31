package GuestBook.service;

import GuestBook.entity.UserEntity;
import GuestBook.exeptions.GuestBookException;
import GuestBook.exeptions.GuestNotFoundException;
import GuestBook.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserEntityRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            UserEntity user = userRepo.findUserEntityByUsername(username).orElseThrow(() -> new GuestNotFoundException(username));
        } catch (GuestBookException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
