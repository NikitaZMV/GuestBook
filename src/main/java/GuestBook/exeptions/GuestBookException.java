package GuestBook.exeptions;

public abstract class GuestBookException extends Exception{
    public GuestBookException(String message) {
        super(message);
    }
}
