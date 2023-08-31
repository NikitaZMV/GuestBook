package GuestBook.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestBookDto<T> {
    private final String status = "success";
    private T payload;

    public GuestBookDto(T payload) {
        this.payload = payload;
    }
}
