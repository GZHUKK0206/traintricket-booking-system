package big_work.big_work.Service;

import big_work.big_work.Pojo.BookingRequest;
import big_work.big_work.Pojo.Guest;
import big_work.big_work.Pojo.Operator;
import big_work.big_work.Pojo.Order;

import java.util.List;

public interface tourGuestsService {
    void tourRegister(Guest guest);

    Guest login(Guest guest);

    Guest tourInformation(String username);

    List<Order> getOrdersList(String Orders);

    void bookticket(BookingRequest bookingRequest);
}
