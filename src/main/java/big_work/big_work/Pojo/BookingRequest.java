package big_work.big_work.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private int GuestID;
    private int trainID;
    private int seatID;
    private String status;
    // getters and setters
}

