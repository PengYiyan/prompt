package com.example.prompt.Util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConvertUtil {

    //转换多个PO和VO
    public static <E, T> List<E> createImportList(List<T> excelList, E param) throws Exception {
        Class<?> clazz = param.getClass();
        List<E> importList = excelList.stream()
                .map(item -> {
                    E managePO = null;
                    try {
                        managePO = (E) CustomerConvert.convert(item, clazz);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    isValidItem(managePO);
                    return managePO;
                })
                .collect(Collectors.toList());
        return importList;
    }

    //转换单个PO和VO, 途中是把T转换成E类型
    public static <E,T> E convertOne(T ori, E param) throws Exception {
        Class<?> clazz = param.getClass();
        E managePO = null;
        try {
            managePO = (E) CustomerConvert.convert(ori, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        isValidItem(managePO);
        return managePO;
    }

    private static <E> void isValidItem(E managePO) {
        if(Objects.isNull(managePO)) {
            throw new RuntimeException("参数异常");
        }
    }

}

