package com.example.demo.Service.Export;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.demo.Dao.ExportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Service.Export
 * @Author: BeafJerky
 * @CreateTime: 2022-11-07  16:18
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ExportServiceImpl implements ExportService {
    @Autowired
    private ExportMapper exportMapper;

    @Override
    public Map<String, Object> exportTable() {
        File dirFile = new File("C:/expExport");
        deleteDirectory(dirFile);
        Map<String, Object> result = new HashMap<>(2);
        List<String> list = new ArrayList<>();
        list.add(exportExcel("投资决策表", exportMapper.listInvestDecision(), "/total", "total"));
        list.add(exportExcel("实验轮次收益表", exportMapper.listTestIncome(), "/total", "total"));
        list.add(exportExcel("计算临时表", exportMapper.listCalTmp(), "/total", "total"));
        list.add(exportExcel("彩票表", exportMapper.listLottery(), "/total", "total"));
        list.add(exportExcel("问卷表", exportMapper.listQuest(), "/total", "total"));
        list.add(exportExcel("阶段收益表", exportMapper.listStageIncome(), "/total", "total"));
        list.add(exportExcel("被试者行为表", exportMapper.listAction(), "/total", "total"));
        result.put("pathList", list);
        return result;
    }

    @Override
    public Map<String, Object> exportTableByPkeys(Map<String, Object> param) {
        File dirFile = new File("C:/expExport");
        deleteDirectory(dirFile);
        Map<String, Object> result = new HashMap<>(2);
        List<String> list = new ArrayList<>();
        list.add(exportExcel("投资决策表", exportMapper.listInvestDecisionByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        list.add(exportExcel("实验轮次收益表", exportMapper.listTestIncomeByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        list.add(exportExcel("计算临时表", exportMapper.listCalTmpByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        list.add(exportExcel("彩票表", exportMapper.listLotteryByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        list.add(exportExcel("问卷表", exportMapper.listQuestByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        list.add(exportExcel("阶段收益表", exportMapper.listStageIncomeByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        list.add(exportExcel("被试者行为表", exportMapper.listActionByPkeys(param), "/" + param.get("testId") + "-" + param.get("testSessionId"), param.get("testId") + "-" + param.get("testSessionId")));
        result.put("pathList", list);
        return result;
    }

    private String exportExcel(String title, List<Map<String, Object>> data, String path, String prefix) {
        String fPath = "C:/expExport" + path + "/" + prefix + "-" + title + ".xlsx";
        ExcelWriter writer = ExcelUtil.getWriter(fPath);
// 合并单元格后的标题行，使用默认标题样式
//        writer.merge(data.get(0).size() - 1, title);

        writer.merge(data.isEmpty() ? 1 : data.get(0).size() - 1, title);
// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data, true);
// 关闭writer，释放内存
        writer.close();
        return fPath;
    }

    public static void deleteDirectory(File file) {
        if (file.isFile()) {
            file.delete();//清理文件
        } else {
            File list[] = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    deleteDirectory(f);
                }
                file.delete();//清理目录
            }
        }
    }
}
