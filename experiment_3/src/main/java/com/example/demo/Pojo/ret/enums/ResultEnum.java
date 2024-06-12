package com.example.demo.Pojo.ret.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(500, "服务器异常"),
    WRAN(601, "警告");
    private Integer code;
    private String msg;
}