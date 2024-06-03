package big_work.big_work.Pojo;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private Integer GuestID;
    private Integer age;
    private boolean isStudent;
    private boolean isElderly;
    private Integer discountID;
    private String username;
    private String password;
    private String orders;
    private List<Order> order;

    public List<Order> getOrdersList() {
        List<Order> ordersList = new ArrayList<>();
        try {
            JSONArray jsonArray = JSONArray.parseArray(orders);
            int length = jsonArray.size();
            for (int i = 0; i < length; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // 解析JSON对象并将其转换为Order对象，然后添加到列表中
                Order order = new Order();
                order.setOrderID(jsonObject.getInteger("orderID"));
                // 解析其他字段并设置到Order对象中
                ordersList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordersList;
    }






}
