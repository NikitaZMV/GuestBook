package GuestBook.exeptions;

public class InvalidEmailException extends GuestBookException {
    public InvalidEmailException(Long id) {
        super("неправильный формат электронной почты в запросе с id " + id);
    }
}
