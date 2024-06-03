package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.OperatorMapper;
import big_work.big_work.Pojo.Operator;
import big_work.big_work.Service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorImpl implements OperatorService {
    @Autowired
    private OperatorMapper operatorMapper;
    @Override
    public Operator login(Operator operator) {
        return operatorMapper.login(operator);
    }

    @Override
    public void register(Operator operator) {
        operatorMapper.register(operator);
    }

    @Override
    public void exit(String newName, String oldName) {
        operatorMapper.exit(newName,oldName);
    }
}
