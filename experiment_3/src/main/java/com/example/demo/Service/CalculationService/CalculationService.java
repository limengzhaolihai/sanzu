package com.example.demo.Service.CalculationService;

import com.example.demo.Pojo.Po.Profit;
import com.example.demo.Pojo.Po.SubjectBank;
import com.example.demo.Pojo.Po.TestCalTemp;
import com.example.demo.Pojo.Po.TesteeAction;

import java.util.Map;

/**
 * 类的模板注释
 *
 * @author bosonghua
 * @date 2022/10/31 - 15:24
 */
public interface CalculationService {

    SubjectBank findProblem(String testee_id);

    void saveCalTemp(TestCalTemp testCalTemp);

    Profit effortIncome(String testee_id);

}
