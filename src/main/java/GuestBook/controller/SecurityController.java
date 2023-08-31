package GuestBook.controller;

import GuestBook.config.JwtCore;
import GuestBook.dto.ErrorDto;
import GuestBook.dto.GuestBookDto;
import GuestBook.dto.SignInDto;
import GuestBook.dto.SignUpDto;
import GuestBook.entity.UserEntity;
import GuestBook.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guestbook/auth")
public class SecurityController {
    @Autowired
    private UserEntityRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCore jwtCore;

    @PostMapping("/signup")
    public ResponseEntity<GuestBookDto<?>> signUp(@RequestBody SignUpDto dto) {
        if (repo.existUserEntityByUsername(dto.getUsername())) {
            //trow
        }
        if (repo.existUserEntityByEmail(dto.getEmail())) {
            //trow
        }
        UserEntity user = new UserEntity();
        String hashed = passwordEncoder.encode(dto.getPassword());
        user.setUserName(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(hashed);
        repo.save(user);
        return ResponseEntity.ok().body(new GuestBookDto<>(dto.getUsername() + "зарегестрирован"));
    }

    @PostMapping("/signin")
    public ResponseEntity<GuestBookDto<String>> signIn(@RequestBody SignInDto dto) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt =jwtCore.generateToken(auth);
        return ResponseEntity.ok().body(new GuestBookDto<>(jwt));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorDto(e.getClass().getSimpleName() + "  |||  " + e.getMessage()));
    }
}
