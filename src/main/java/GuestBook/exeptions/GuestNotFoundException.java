package GuestBook.exeptions;

public class GuestNotFoundException extends GuestBookException {
    public GuestNotFoundException(String name) {
        super("Пользователь с именем " + name + " не найден");
    }
}
