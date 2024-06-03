package big_work.big_work.Mapper;

import big_work.big_work.Pojo.Guest;
import big_work.big_work.Pojo.Operator;
import big_work.big_work.Pojo.Order;
import org.apache.ibatis.annotations.*;
import big_work.big_work.Pojo.seat;
import big_work.big_work.Pojo.BookingRequest;

import java.util.List;
import java.util.Map;

@Mapper
public interface tourGuestsMapper {
    @Insert("INSERT INTO big_homework.guests (username, password, Age, DiscountID,IsElderly,IsStudent) " +
            "VALUES (#{username}, #{password}, #{age}, #{discount},#{isElderly},#{isStudent})")
    void tourRegister(Guest guest);

    @Select("select * from big_homework.guests where username=#{username} and password=#{password}")
    Guest login(Guest guest);


    @Select("SELECT " +
            "    g.*, " +
            "    JSON_ARRAYAGG( " +
            "        JSON_OBJECT( " +
            "            'orderID', o.OrderID, " +
            "            'departureStationName', s1.StationName, " +
            "            'arrivalStationName', s2.StationName, " +
            "            'seatID', c.SeatID, " +
            "            'orderStatus', o.OrderStatus, " +
            "             'departureTime',t.DepartureTime ,   " +
            "            'seat', JSON_OBJECT('seatID', c.SeatID, 'trainID', c.TrainID, 'seatNumber', c.SeatNumber, 'isOccupied', c.IsOccupied, 'carriageNumber', c.CarriageNumber) " +
            "        ) " +
            "    ) AS orders " +
            "FROM " +
            "    big_homework.guests AS g " +
            "LEFT JOIN " +
            "    big_homework.orders AS o ON g.GuestID = o.GuestID " +
            "LEFT JOIN " +
            "    big_homework.trains AS t ON o.TrainID = t.TrainID " +
            "LEFT JOIN " +
            "    big_homework.stations AS s1 ON t.DepartureStationID = s1.StationID " +
            "LEFT JOIN " +
            "    big_homework.stations AS s2 ON t.ArrivalStationID = s2.StationID " +
            "LEFT JOIN " +
            "    big_homework.seats AS c ON o.SeatID = c.SeatID " +
            "WHERE " +
            "    g.username = #{username} " +
            "GROUP BY " +
            "    g.GuestID")
    @Results({
            @Result(property = "guestID", column = "GuestID"),
            @Result(property = "age", column = "age"),
            @Result(property = "isStudent", column = "isStudent"),
            @Result(property = "isElderly", column = "isElderly"),
            @Result(property = "discountID", column = "discountID"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "orders", column = "orders", javaType = String.class)
    })
    Guest tourInformation(String username);

    @Insert("INSERT INTO orders (GuestID, TrainID, OrderStatus, SeatID) " +
            "VALUES (#{GuestID}, #{trainID}, #{status}, #{seatID})")
    void addOrder(BookingRequest bookingRequest);

    @Update("UPDATE trains SET SeatCount = SeatCount - 1 WHERE TrainID = #{trainID} AND SeatCount > 0")
    void alterTrain(BookingRequest bookingRequest);

    @Update("UPDATE seats SET IsOccupied = 1 WHERE SeatID = #{seatID} AND IsOccupied = 0")
    void alterSeat(BookingRequest bookingRequest);
}