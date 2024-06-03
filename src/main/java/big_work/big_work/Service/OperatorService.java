package big_work.big_work.Service;

import big_work.big_work.Pojo.Operator;

public interface OperatorService {

    Operator login(Operator operator);

    void register(Operator operator);

    void exit(String newName, String oldName);
}
