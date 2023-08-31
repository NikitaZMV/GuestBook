package GuestBook.exeptions;

public class GuestExistException extends GuestBookException{
    public GuestExistException() {
        super("Пользователь уже существует");
    }
}
