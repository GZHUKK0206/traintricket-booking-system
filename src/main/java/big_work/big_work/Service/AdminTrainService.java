package big_work.big_work.Service;

import big_work.big_work.Pojo.Department;
import big_work.big_work.Pojo.Train;

import java.util.List;

public interface AdminTrainService {
    List<Train>  getAllTrain();

    void deleteTrainById(Integer id);

    void addTrain(Train train);
}
