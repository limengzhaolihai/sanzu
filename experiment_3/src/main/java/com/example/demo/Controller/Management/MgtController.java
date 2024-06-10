package com.example.demo.Controller.Management;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo.Controller.Login.LoginController;
import com.example.demo.DemoApplication;
import com.example.demo.Service.ExperimentSession.ExperimentSessionService;
import com.example.demo.Service.Export.ExportService;
import com.example.demo.Service.FundInfo.FundInfoService;
import com.example.demo.Service.FundSum.FundSumService;
import com.example.demo.Service.GlobalConfig.GlobalConfigService;
import com.example.demo.Service.InitExp.InitExpService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: experiment
 * @BelongsPackage: com.example.demo.Controller.management
 * @Author: BeafJerky
 * @CreateTime: 2022-10-29  17:11
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Controller
public class MgtController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private FundInfoService fundInfoService;
    @Autowired
    private FundSumService fundSumService;
    @Autowired
    private GlobalConfigService globalConfigService;
    @Autowired
    private ExperimentSessionService experimentSessionService;
    @Autowired
    private InitExpService initExpService;
    @Autowired
    private ExportService exportService;

    @RequestMapping(value = "/mgtController/listFundSum")
    @ResponseBody
    public Map<String, Object> listFundSum() {
        return fundSumService.listFundSum();
    }

    @RequestMapping(value = "/mgtController/insertFundSum")
    @ResponseBody
    public Map<String, Object> insertFundSum(@RequestBody Map<String, Object> request) {
        return fundSumService.insertFundSum(request);
    }

    @RequestMapping(value = "/mgtController/selectFundSum")
    @ResponseBody
    public Map<String, Object> selectFundSum(@RequestBody Map<String, Object> request) {
        return fundSumService.selectFundSum(request);

    }

    @RequestMapping(value = "/mgtController/updateFundSum")
    @ResponseBody
    public Map<String, Object> updateFundSum(@RequestBody Map<String, Object> request) {
        return fundSumService.updateFundSum(request);
    }

    @RequestMapping(value = "/mgtController/deleteFundSum")
    @ResponseBody
    public Map<String, Object> deleteFundSum(@RequestBody Map<String, Object> request) {
        return fundSumService.deleteFundSum(request);
    }

    @RequestMapping(value = "/exceltest/test")
    @ResponseBody
    public Map<String, Object> asd(@RequestParam MultipartFile file) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
//            List<TestEntity> listEntity = reader.readAll(TestEntity.class);
//            List<Map<String, Object>> listEntity = reader.readAll();
            List<List<Object>> listEntity = reader.read();
            result.put("result", listEntity);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", "出错");
        }
        return result;
    }

    @RequestMapping(value = "/mgtController/listFundInfo")
    @ResponseBody
    public Map<String, Object> listFundInfo() {
        return fundInfoService.listFundInfo();
    }

    @RequestMapping(value = "/mgtController/insertFundInfo")
    @ResponseBody
    public Map<String, Object> insertFundInfo(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "data") String request) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List<Map<String, Object>> listEntity = reader.readAll();
            Map<String, Object> params = (Map<String, Object>) JSON.parse(request);
            fundInfoService.insertFundInfo(params, listEntity);
            result.put("result", "完成");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", "出错");
        }
        return result;
    }

    @RequestMapping(value = "/mgtController/selectFundInfo")
    @ResponseBody
    public Map<String, Object> selectFundInfo(@RequestBody Map<String, Object> request) {
        return fundInfoService.selectFundInfo(request);

    }

    @RequestMapping(value = "/mgtController/updateFundInfo")
    @ResponseBody
    public Map<String, Object> updateFundInfo(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "data") String request) {
        Map<String, Object> result = new HashMap<>(3);
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List<Map<String, Object>> listEntity = reader.readAll();
            Map<String, Object> params = (Map<String, Object>) JSON.parse(request);
            fundInfoService.updateFundInfo(params, listEntity);
            result.put("result", "完成");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", "出错");
        }
        return result;
    }

    @RequestMapping(value = "/mgtController/deleteFundInfo")
    @ResponseBody
    public Map<String, Object> deleteFundInfo(@RequestBody Map<String, Object> request) {
        return fundInfoService.deleteFundInfo(request);
    }

    @RequestMapping(value = "/mgtController/deleteAllFundInfo")
    @ResponseBody
    public Map<String, Object> deleteAllFundInfo() {
        return fundInfoService.deleteAllFundInfo();
    }

    @RequestMapping(value = "/mgtController/selectGlobalConfig")
    @ResponseBody
    public Map<String, Object> selectGlobalConfig() {
        return globalConfigService.selectGlobalConfig();
    }

    @RequestMapping(value = "/mgtController/updateGlobalConfig")
    @ResponseBody
    public Map<String, Object> updateGlobalConfig(@RequestBody Map<String, Object> request) {
        return globalConfigService.updateGlobalConfig(request);
    }

    @RequestMapping(value = "/mgtController/listExpSession")
    @ResponseBody
    public Map<String, Object> listExpSession() {
        return experimentSessionService.listExpSession();
    }

    @RequestMapping(value = "/mgtController/insertExpSession")
    @ResponseBody
    public Map<String, Object> insertExpSession(@RequestBody Map<String, Object> param) {
        return experimentSessionService.insertExpSession(param);
    }

    @RequestMapping(value = "/mgtController/updateExpSession")
    @ResponseBody
    public Map<String, Object> updateExpSession(@RequestBody Map<String, Object> param) {
        return experimentSessionService.updateExpSession(param);
    }

    @RequestMapping(value = "/mgtController/selectExpSession")
    @ResponseBody
    public Map<String, Object> selectExpSession(@RequestBody Map<String, Object> param) {
        return experimentSessionService.selectExpSession(param);
    }

    @RequestMapping(value = "/mgtController/deleteExpSession")
    @ResponseBody
    public Map<String, Object> deleteExpSession(@RequestBody Map<String, Object> param) {
        return experimentSessionService.deleteExpSession(param);
    }

    @RequestMapping(value = "/mgtController/selectExpStage")
    @ResponseBody
    public Map<String, Object> selectExpStage(@RequestBody Map<String, Object> param) {
        return experimentSessionService.selectExpStage(param);
    }

    @RequestMapping(value = "/mgtController/updateExpStage")
    @ResponseBody
    public Map<String, Object> updateExpStage(@RequestBody Map<String, Object> param) {
        return experimentSessionService.updateExpStage(param);
    }

    @RequestMapping(value = "/mgtController/startExp")
    @ResponseBody
    public Map<String, Object> startExp(@RequestBody Map<String, Object> param) {
        return experimentSessionService.startExp(param);
    }

    @RequestMapping(value = "/mgtController/finishExp")
    @ResponseBody
    public Map<String, Object> finishExp(@RequestBody Map<String, Object> param) {
        return experimentSessionService.finishExp(param);
    }

    @RequestMapping(value = "/mgtController/initExp")
    @ResponseBody
    public Map<String, Object> initExp(@RequestBody Map<String, Object> param) {
        return initExpService.initExp();
    }

    @RequestMapping(value = "/mgtController/listReward")
    @ResponseBody
    public Map<String, Object> listReward(@RequestBody Map<String, Object> param) {
        return experimentSessionService.listReward(param);
    }

    @RequestMapping(value = "/mgtController/listSchedule")
    @ResponseBody
    public Map<String, Object> listSchedule(@RequestBody Map<String, Object> param) {
        return experimentSessionService.listSchedule(param);
    }

    @RequestMapping(value = "/mgtController/exportTable")
    @ResponseBody
    public Map<String, Object> exportTable() {
        return exportService.exportTable();
    }

    @RequestMapping(value = "/mgtController/exportTableByPkeys")
    @ResponseBody
    public Map<String, Object> exportTableByPkeys(@RequestBody Map<String, Object> param) {
        return exportService.exportTableByPkeys(param);
    }

    /**
     * @param path     想要下载的文件的路径
     * @param response
     * @功能描述 下载文件:
     */

    @RequestMapping("/download")

    public void download(String path, HttpServletResponse response) {
        try {
// path是指想要下载的文件的路径
            File file = new File(path);
// 获取文件名
            String filename = file.getName();
// 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
// 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
// 清空response
            response.reset();
// 设置response的Header
            response.setCharacterEncoding("UTF-8");
//Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
//attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
// filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
// 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
