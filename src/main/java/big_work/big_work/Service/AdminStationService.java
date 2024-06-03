package big_work.big_work.Service;

import big_work.big_work.Pojo.station;

import java.util.List;

public interface AdminStationService {
    List<station> getAllStation();

    void addStation(station station);
}
