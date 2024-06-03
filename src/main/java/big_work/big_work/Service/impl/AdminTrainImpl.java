package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.AdminTrainMapper;
import big_work.big_work.Pojo.Train;
import big_work.big_work.Service.AdminTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTrainImpl implements AdminTrainService {
    @Autowired
    private AdminTrainMapper adminTrainMapper;
    @Override
    public List<Train> getAllTrain() {
        return adminTrainMapper.getAllTrain();
    }

    @Override
    public void deleteTrainById(Integer id) {
        adminTrainMapper.deleteTrainById(id);
    }

    @Override
    public void addTrain(Train train) {
        adminTrainMapper.addTrain(train);
    }
}
