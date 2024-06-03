package big_work.big_work.Mapper;

import big_work.big_work.Pojo.station;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminStationMapper {
    @Select("select * from big_homework.stations")
    List<station> getAllStation();

    @Insert("INSERT INTO big_homework.stations (StationName) VALUES (#{StationName})")
    void addStation(station station);
}
