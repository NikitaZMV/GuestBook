package GuestBook.exeptions;

public class InvalidModelException  extends GuestBookException {
    public InvalidModelException(Long id) {
        super("Неправильная модель данных в запросе с id " + id);
    }
}
