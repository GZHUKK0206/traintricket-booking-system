package big_work.big_work.Mapper;

import big_work.big_work.Pojo.SearchInformationProvider;
import big_work.big_work.Pojo.Train;
import big_work.big_work.Pojo.seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import java.util.List;

@Mapper
public interface SearchInformationMapper {

    @SelectProvider(type = SearchInformationProvider.class, method = "searchTrain")
    List<Train> Search(@Param("departure") String departure,
                            @Param("destination") String destination,
                            @Param("date") String date);

    @Select("select seats.SeatID,SeatNumber from big_homework.seats where TrainID=#{trainId} and IsOccupied=0")
    List<seat> getAvailableSeats(Integer trainId);
}


