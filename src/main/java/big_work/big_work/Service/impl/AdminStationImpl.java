package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.AdminStationMapper;
import big_work.big_work.Pojo.station;
import big_work.big_work.Service.AdminStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminStationImpl implements AdminStationService {
    @Autowired
    private AdminStationMapper adminStationMapper;
    @Override
    public List<station> getAllStation() {
        return adminStationMapper.getAllStation();
    }

    @Override
    public void addStation(station station) {
        adminStationMapper.addStation(station);
    }
}
