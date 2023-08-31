package GuestBook.controller;

import GuestBook.entity.GuestBookEntity;
import GuestBook.exeptions.GuestBookException;
import GuestBook.dto.ErrorDto;
import GuestBook.dto.GuestBookDto;
import GuestBook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guestbook/post")
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GuestBookDto<Long>> post(@RequestBody GuestBookEntity guest) throws GuestBookException {
        return ResponseEntity.ok().body(guestBookService.saveMessage(guest));
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GuestBookDto<GuestBookEntity>> get(@PathVariable("id") long id) throws GuestBookException {
            return ResponseEntity.ok().body(guestBookService.getOne(id));

    }

    @PutMapping
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<GuestBookDto<Long>> put(@RequestBody GuestBookEntity guest) throws GuestBookException {
            return ResponseEntity.ok().body(guestBookService.put(guest));
    }

    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GuestBookDto<Long>> delete(@PathVariable("id") long id) throws GuestBookException {
            return ResponseEntity.ok().body(guestBookService.delete(id));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorDto(e.getClass().getSimpleName() + "  |||  " + e.getMessage()));
    }

}

