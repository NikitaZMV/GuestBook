package GuestBook.exeptions;

public class GuestPostNotFoundException extends GuestBookException {
    public GuestPostNotFoundException(long id) {
        super("Поcт c id" + id + " не найден");
    }
}
