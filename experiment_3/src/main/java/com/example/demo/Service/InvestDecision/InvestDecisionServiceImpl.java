package com.example.demo.Service.InvestDecision;

import com.example.demo.Dao.InvestDecisionMapper;
import com.example.demo.Pojo.Po.InvestDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestDecisionServiceImpl implements InvestDecisionService {
    @Autowired
    InvestDecisionMapper investDecisionMapper;
    @Override
    public int addInvestDecision(InvestDecision investDecision) {
        int i = investDecisionMapper.addInvestDecision(investDecision);
        return i;
    }
}
