package com.example.demo.Service.Export;

import java.util.Map;

public interface ExportService {
    Map<String, Object> exportTable();

    Map<String, Object> exportTableByPkeys(Map<String, Object> param);
}
