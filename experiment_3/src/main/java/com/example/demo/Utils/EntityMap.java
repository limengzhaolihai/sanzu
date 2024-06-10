package com.example.demo.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: EntityMap
 * @Author: BeafJerky
 * @Date: 2022/10/29 19:08
 */
public final class EntityMap {
    private static final char UNDERLINE = '_';

    /**
     * @Description: 类实体Map、变量名转换
     * @Author: BeafJerky
     * @Date: 2022/10/18 15:01
     * @Param: [map]
     * @ParamsType: [java.util.Map<java.lang.String, java.lang.Object>]
     * @Return: java.util.Map<java.lang.String, java.lang.Object>
     */
    public static Map<String, Object> toEntityMap(Map<String, Object> map) {
        Map<String, Object> entityMap = new HashMap<>(map.keySet().size() + 6);
        for (String key : map.keySet()) {
            Object value = map.get(key);
            entityMap.put(underlineToHump(key), value);
        }
        return entityMap;
    }

    /**
     * @Description: 下划线分割转小驼峰
     * @Author: BeafJerky
     * @Date: 2022/10/18 15:02
     * @Param: [key]
     * @ParamsType: [java.lang.String]
     * @Return: java.lang.String
     */
    public static String underlineToHump(String key) {
        if (key == null || "".equals(key.trim())) {
            return "";
        }
        int len = key.length();
        StringBuilder humpKey = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char a = Character.toLowerCase(key.charAt(i));
            if (a == UNDERLINE) {
                if (++i < len) {
                    humpKey.append(Character.toUpperCase(key.charAt(i)));
                }
            } else {
                humpKey.append(a);
            }
        }
        return humpKey.toString();
    }

}
