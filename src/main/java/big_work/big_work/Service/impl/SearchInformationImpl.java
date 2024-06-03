package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.SearchInformationMapper;
import big_work.big_work.Pojo.Train;
import big_work.big_work.Pojo.seat;
import big_work.big_work.Service.SearchInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchInformationImpl implements SearchInformationService {
    @Autowired
    private SearchInformationMapper searchInformationMapper;

    @Override
    public List<Train> Search(String departure, String destination, String date) {
        // 对日期参数进行处理


        // 调用修改后的search方法
        return searchInformationMapper.Search(departure, destination, date);
    }

    @Override
    public List<seat> getAvailableSeats(Integer trainId) {
        return searchInformationMapper.getAvailableSeats(trainId);
    }


}

