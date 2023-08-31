package GuestBook.exeptions;

public class InvalidPhoneException extends GuestBookException {
    public InvalidPhoneException(Long id) {
        super("неправильный формат телефонного номера в запросе с id " + id);
    }
}
