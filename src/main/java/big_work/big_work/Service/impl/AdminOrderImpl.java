package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.AdminOrderMapper;
import big_work.big_work.Pojo.Order;
import big_work.big_work.Pojo.Train;
import big_work.big_work.Pojo.seat;
import big_work.big_work.Service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOrderImpl implements AdminOrderService {
    @Autowired
    private AdminOrderMapper adminOrderMapper;
    @Override
    public List<Order> getAllOrder() {

        List<Order> orders = adminOrderMapper.getAllOrders();
        for (Order order : orders) {
            // 获取火车信息并赋值给订单对象的 train 字段

            /*Train train = adminOrderMapper.getTrainById(order.getTrainID());
            System.out.println("座位id"+order.getSeatID());*/
            seat seat = adminOrderMapper.getSeatByID(order.getSeatID());
            /*order.setTrain(train);*/
            order.setSeat(seat);
        }
        return orders;
    }
}
