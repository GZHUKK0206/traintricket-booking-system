package big_work.big_work.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    private Integer trainID;
    private Integer departureStationID;
    private Integer arrivalStationID;
    private Date departureTime;
    private Date arrivalTime;
    private Integer price;
    private Integer SeatCount;
    private String departureStationName; // 新增字段
    private String arrivalStationName; // 新增字段
}
