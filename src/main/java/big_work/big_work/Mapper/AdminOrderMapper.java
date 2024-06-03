package big_work.big_work.Mapper;

import big_work.big_work.Pojo.Order;
import big_work.big_work.Pojo.Train;
import big_work.big_work.Pojo.seat;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminOrderMapper {

    @Select("SELECT a.*, c.SeatID, b1.StationName AS arrivalStationName, b2.StationName AS departureStationName " +
            "FROM big_homework.orders AS a " +
            "JOIN big_homework.trains AS b ON a.TrainID = b.TrainID " +
            "JOIN big_homework.stations AS b1 ON b.ArrivalStationID = b1.StationID " +
            "JOIN big_homework.stations AS b2 ON b.DepartureStationID = b2.StationID " +
            "JOIN big_homework.seats AS c ON a.SeatID = c.SeatID")
    @Results({
            @Result(property = "orderID", column = "OrderID"),
            @Result(property = "guestID", column = "GuestID"),
            @Result(property = "trainID", column = "TrainID"),
            @Result(property = "orderStatus", column = "OrderStatus"),
            @Result(property = "seatID", column = "SeatID"),
            /*@Result(property = "train", column = "TrainID",
                    javaType = Train.class,
                    one = @One(select = "getTrainById")),*/
            @Result(property = "seat", column = "SeatID",
                    javaType = seat.class,
                    one = @One(select = "getSeatByID")),
            @Result(property = "departureStationName", column = "departureStationName"),
            @Result(property = "arrivalStationName", column = "arrivalStationName")
    })
    List<Order> getAllOrders();

    /*@Select("select * from big_homework.trains where TrainID = #{trainID}")
    Train getTrainById(Integer trainID);*/

    @Select("select * from big_homework.seats where SeatID=#{seatID}")
    seat getSeatByID(Integer seatID);
}
