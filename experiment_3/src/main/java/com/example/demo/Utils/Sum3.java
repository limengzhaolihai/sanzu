package com.example.demo.Utils;

import com.example.demo.DemoApplication;
import com.example.demo.Pojo.Subject300;
import com.example.demo.Service.Subject.SubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class Sum3 {

    @Autowired
    SubjectService subjectService;

    @Test
    public void addSubject() {
        final int EQUATION_NUM = 600;   // 习题中等式的数量
        final int ADD_MAX_VALUE = 200; // 加法算式约束：加法结果的最大值   .
        final int MAX_OPRT_VALUE = 90;  // 算式约束：操作数的最大值

        int[][] exercise;              // 习题集二维数组
        int e[];  //算式数组[操作数1，操作数2，操作符，结果]

        exercise = generateExerciseOfAdditionEquations(EQUATION_NUM,
                ADD_MAX_VALUE, MAX_OPRT_VALUE);  // 产生加法算式习题

        Subject300 subject300 = new Subject300();
        for (int i = 0; i < exercise.length; i++) {
            e = exercise[i];
            subject300.setNid(i + 1);
            subject300.setAdd1(e[0]);
            subject300.setAdd2(e[1]);
            subject300.setSum(e[3]);
            subjectService.addSubject(subject300);
        }
        //     formatAndDisplayExercise(exercise, NUM_PER_LINE); //打印习题
    }


    /**
     * 产生加法算式习题集
     *
     * @param equ_num：习题集中算式的数量
     * @param add_max_value：加法结果的最大值
     * @param max_oprt_value：操作数的最大值
     * @return：返回习题二维数组[equation_num][4]
     */
    public int[][] generateExerciseOfAdditionEquations(int equ_num,
                                                       int add_max_value, int max_oprt_value) {

        int e[];   // 算式     //[操作数1，操作数2，操作符，结果]
        int[][] exercise = new int[equ_num][4];
        int e_index = 0; //目前习题中算式的个数

        for (int i = 0; i < equ_num; i++) {
            do {
                e = generateAnAddEquation(add_max_value, max_oprt_value); //产生一个加法算式
            } while (occursIn(e, exercise, e_index));  //判断算式e是否出现在习题exercise中
            exercise[e_index++] = e;   // 把算式e存放在习题exercise中，游标加1
        }

        return exercise;
    }


    /**
     * 产生一个加法算式
     *
     * @param add_max_value：加法结果的最大值
     * @param max_oprt_value：        操作数的最大值
     * @return： 返回一个数组表示的算式[操作数1，操作数2，操作符，结果]，操作符：0--加法；1--减法
     */
    public int[] generateAnAddEquation(int add_max_value, int max_oprt_value) {

        int m, n, v;
        int e[] = new int[]{0, 0, 0, 0};
        do {
            m = generateOperand(max_oprt_value);  // 产生一个不超过max_oprt_value的操作数
            n = generateOperand(max_oprt_value);  // 产生一个不超过max_oprt_value的操作数
            v = m + n;
        } while (v > add_max_value);
        e[0] = m; //第一个操作数
        e[1] = n; //第二个操作数
        e[2] = 0; //操作符：0--加法；1--减法
        e[3] = v; // 计算结果
        return e;
    }


    /**
     * 产生一个不超过 max_value的随机数
     *
     * @param max_value
     * @return
     */
    public int generateOperand(int max_value) {
        Random random = new Random();
        return random.nextInt(max_value) + 10;
    }

    /**
     * 判断算式在习题中是否重复
     *
     * @param eq：                  算式[操作数1，操作数2，操作符，结果]
     * @param exercise：习题集二维数组
     * @param index：目前习题中算式的个数（游标）
     * @return：返回布尔值，重复返回1；不重复返回0.
     */
    public boolean occursIn(int[] eq, int[][] exercise, int index) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (isEqual(eq, exercise[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * 判断两个算式是否相等
     *
     * @param eq1：第一个算式 [操作数1，操作数2，操作符，结果]
     * @param eq2：第二个算式 [操作数1，操作数2，操作符，结果]
     * @return：如果相等，返回1；如果不相等，返回0
     */
    public boolean isEqual(int[] eq1, int[] eq2) {
        return (eq1[0] == eq2[0] && eq1[1] == eq2[1] && eq1[2] == eq2[2])
                || (eq1[0] == eq2[1] && eq1[1] == eq2[0] && eq1[2] == eq2[2]);
    }


}
