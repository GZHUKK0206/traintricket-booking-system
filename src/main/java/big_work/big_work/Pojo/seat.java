package big_work.big_work.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class seat {
    private Integer seatID;
    private Integer trainID;
    private String seatNumber;//座位号
    private Integer isOccupied;//是否被预定
    private Integer carriageNumber;//车厢号
}
