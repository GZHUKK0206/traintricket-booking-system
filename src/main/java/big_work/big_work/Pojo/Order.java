package big_work.big_work.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer OrderID;
    private Integer GuestID;
    private Integer TrainID;
    /*private Train train;*/
    private String OrderStatus;
    private Integer seatID;
    private seat seat;
    // 新增字段
    private String departureStationName;
    private String arrivalStationName;
    private Date departureTime;
}
