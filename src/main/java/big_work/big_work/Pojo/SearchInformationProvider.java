package big_work.big_work.Pojo;

import org.apache.ibatis.annotations.Param;

public class SearchInformationProvider {
    public String searchTrain(String departure, String destination, String date) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT t.*, s1.StationName AS DepartureStationName, s2.StationName AS ArrivalStationName ")
                .append("FROM big_homework.trains AS t ")
                .append("JOIN big_homework.stations AS s1 ON t.DepartureStationID = s1.StationID ")
                .append("JOIN big_homework.stations AS s2 ON t.ArrivalStationID = s2.StationID ");

        boolean hasCondition = false; // 标记是否存在查询条件

        if (departure != null && !departure.isEmpty()) {
            sql.append("WHERE "); // 如果有查询条件，添加 WHERE 关键字
            sql.append("s1.StationName = '").append(departure).append("'");
            hasCondition = true;
        }
        if (destination != null && !destination.isEmpty()) {
            if (hasCondition) {
                sql.append(" AND "); // 如果已存在查询条件，添加 AND 连接符
            } else {
                sql.append("WHERE "); // 如果没有查询条件但添加了新的条件，添加 WHERE 关键字
                hasCondition = true;
            }
            sql.append("s2.StationName = '").append(destination).append("'");
        }
        if (date != null && !date.isEmpty()) {
            if (hasCondition) {
                sql.append(" AND "); // 如果已存在查询条件，添加 AND 连接符
            } else {
                sql.append("WHERE "); // 如果没有查询条件但添加了新的条件，添加 WHERE 关键字
                hasCondition = true;
            }
            sql.append("DATE(t.DepartureTime) = '").append(date).append("'");
        }

        return sql.toString();
    }
}

