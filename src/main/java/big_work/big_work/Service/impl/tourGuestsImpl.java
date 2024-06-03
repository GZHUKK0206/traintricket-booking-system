package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.tourGuestsMapper;
import big_work.big_work.Pojo.*;
import big_work.big_work.Service.tourGuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class tourGuestsImpl implements tourGuestsService {
    @Autowired
    private tourGuestsMapper tourGuestsMapper;
    @Override
    public void tourRegister(Guest guest) {
        tourGuestsMapper.tourRegister(guest);
    }

    @Override
    public Guest login(Guest guest) {
        return tourGuestsMapper.login(guest);
    }

    @Override
    public Guest tourInformation(String username) {

        return tourGuestsMapper.tourInformation(username);
    }

    @Override
    public List<Order> getOrdersList(String orders) {
        List<Order> ordersList = new ArrayList<>();
        if (!StringUtils.isEmpty(orders)) {
            try {
                JSONArray jsonArray = new JSONArray(orders);
                int length = jsonArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    // 解析JSON对象并将其转换为Order对象，然后添加到列表中
                    Order order = new Order();
                    order.setOrderID(jsonObject.optInt("orderID"));
                    order.setSeatID(jsonObject.optInt("seatID"));
                    order.setOrderStatus(jsonObject.optString("orderStatus"));
                    order.setDepartureStationName(jsonObject.optString("departureStationName"));
                    order.setArrivalStationName(jsonObject.optString("arrivalStationName"));

                    // 解析日期字符串并转换为Date对象
                    String departureTimeStr = jsonObject.optString("departureTime");
                    if (!departureTimeStr.isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                        SimpleDateFormat alternativeDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            Date departureTime = dateFormat.parse(departureTimeStr);
                            order.setDepartureTime(departureTime);
                        } catch (ParseException e) {
                            try {
                                Date departureTime = alternativeDateFormat.parse(departureTimeStr);
                                order.setDepartureTime(departureTime);
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                    // 添加解析座位信息的逻辑
                    JSONObject seatObject = jsonObject.optJSONObject("seat");
                    if (seatObject != null) {
                        seat seat = new seat();
                        seat.setSeatID(seatObject.optInt("seatID"));
                        seat.setTrainID(seatObject.optInt("trainID"));
                        seat.setSeatNumber(seatObject.optString("seatNumber"));
                        seat.setIsOccupied(seatObject.optInt("isOccupied"));
                        seat.setCarriageNumber(seatObject.optInt("carriageNumber"));
                        order.setSeat(seat);
                    }

                    ordersList.add(order);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ordersList;

    }

    @Override
    public void bookticket(BookingRequest bookingRequest) {
        tourGuestsMapper.addOrder(bookingRequest);
        tourGuestsMapper.alterTrain(bookingRequest);
        tourGuestsMapper.alterSeat(bookingRequest);
    }


}
