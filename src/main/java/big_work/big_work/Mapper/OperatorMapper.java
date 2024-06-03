package big_work.big_work.Mapper;

import big_work.big_work.Pojo.Operator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OperatorMapper {



    @Select("select * from big_homework.operators where username=#{username} and password=#{password}")
    Operator login(Operator operator);

    @Insert("INSERT INTO big_homework.operators (username, password, email, phone) " +
            "VALUES (#{username}, #{password}, #{email}, #{phone})")
    void register(Operator operator);


    @Update("UPDATE big_homework.operators SET username =#{newName} WHERE username=#{oldName}")
    void exit(String newName, String oldName);
}
