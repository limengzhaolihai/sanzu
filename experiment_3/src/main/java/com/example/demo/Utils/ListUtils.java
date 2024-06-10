package com.example.demo.Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: tyland
 * @BelongsPackage: com.jeesite.modules.common
 * @Author: BeafJerky
 * @CreateTime: 2022-10-26  15:10
 * @Description: TODO
 * @Version: 1.0
 */
public class ListUtils {

    /**
     * @Description: Object转List
     * @Author: BeafJerky
     * @Date: 2022/10/26 16:29
     * @Param: [obj, clazz]
     * @ParamsType: [java.lang.Object, java.lang.Class<T>]
     * @Return: java.util.List<T>
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<>();
// 如果不是List<?>对象，是没有办法转换的
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
// 根据业务需要来决定这里要不要将null值还原放进去
                if (o == null) {
                    result.add(clazz.cast(null));
                    continue;
                }
// 转换前的前置判断，避免clazz.cast的时候出现类转换异常
                if (o.getClass().equals(clazz)) {
// 将对应的元素进行类型转换
                    result.add(clazz.cast(o));
                }
            }
            return result;
        }
        return result;
    }

    /**
     * @Description: Object转List
     * @Author: BeafJerky
     * @Date: 2022/10/26 16:30
     * @Param: [obj]
     * @ParamsType: [java.lang.Object]
     * @Return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    public static List<Map<String, Object>> castListMap(Object obj) throws IllegalAccessException {
        List<Map<String, Object>> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                Map<String, Object> map = new HashMap<>(16);
                Class<?> clazz = o.getClass();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = field.get(key);
                    if (value == null) {
                        value = "";
                    }
                    map.put(key, value);
                }
                result.add(map);
            }
            return result;
        }
        return null;
    }

    /**
     * @Description: Object转List
     * @Author: BeafJerky
     * @Date: 2022/10/26 16:30
     * @Param: [obj, vClass]
     * @ParamsType: [java.lang.Object, java.lang.Class<V>]
     * @Return: java.util.List<java.util.Map < java.lang.String, V>>
     */
    public static <V> List<Map<String, V>> castListMap(Object obj, Class<V> vClass) throws IllegalAccessException {
        List<Map<String, V>> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                Map<String, V> map = new HashMap<>(16);
                Class<?> oClass = o.getClass();
                for (Field field : oClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = field.get(key);
                    if (value == null) {
                        value = "";
                    }
                    map.put(key, vClass.cast(value));
                }
                result.add(map);
            }
            return result;
        }
        return null;
    }

    /**
     * @Description: Object转List
     * @Author: BeafJerky
     * @Date: 2022/10/26 16:30
     * @Param: [obj, kCalzz, vCalzz]
     * @ParamsType: [java.lang.Object, java.lang.Class<K>, java.lang.Class<V>]
     * @Return: java.util.List<java.util.Map < K, V>>
     */
    public static <K, V> List<Map<K, V>> castListMap(Object obj, Class<K> kCalzz, Class<V> vCalzz) {
        List<Map<K, V>> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object mapObj : (List<?>) obj) {
                if (mapObj instanceof Map<?, ?>) {
                    Map<K, V> map = new HashMap<>(16);
                    for (Map.Entry<?, ?> entry : ((Map<?, ?>) mapObj).entrySet()) {
                        map.put(kCalzz.cast(entry.getKey()), vCalzz.cast(entry.getValue()));
                    }
                    result.add(map);
                }
            }
            return result;
        }
        return null;
    }

}