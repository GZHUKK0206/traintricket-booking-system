package big_work.big_work.Mapper;

import big_work.big_work.Pojo.Train;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface AdminTrainMapper {
    @Select("SELECT t.*, s1.StationName AS DepartureStationName, s2.StationName AS ArrivalStationName " +
            "FROM big_homework.trains AS t " +
            "JOIN big_homework.stations AS s1 ON t.DepartureStationID = s1.StationID " +
            "JOIN big_homework.stations AS s2 ON t.ArrivalStationID = s2.StationID")
    List<Train> getAllTrain();


    @Delete("delete FROM big_homework.trains WHERE TrainID= #{id}")
    void deleteTrainById(Integer id);

    @Insert("INSERT INTO big_homework.trains (DepartureStationID,ArrivalStationID, departuretime, arrivaltime, price) VALUES (#{departureStationID}, #{arrivalStationID},#{departureTime},#{arrivalTime},#{price})")
    void addTrain(Train train);
}
