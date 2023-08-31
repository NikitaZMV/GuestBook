package GuestBook.exeptions;

public class WrongNameException extends GuestBookException {
    public WrongNameException() {
        super("нельзя Козловым, они козлы");
    }

    public WrongNameException(Long id) {
        super("неправильный формат имени в запросе с id " + id);
    }
}
