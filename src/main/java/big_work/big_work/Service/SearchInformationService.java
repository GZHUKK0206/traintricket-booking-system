package big_work.big_work.Service;

import big_work.big_work.Pojo.Train;
import big_work.big_work.Pojo.seat;

import java.util.List;

public interface SearchInformationService {
    List<Train> Search(String departure, String destination, String date);

    List<seat>getAvailableSeats(Integer trainId);
}
