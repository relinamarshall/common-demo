package com.common.demo.vo;

import java.time.LocalDate;

import lombok.Data;

/**
 * ExcelImportVo
 *
 * @author Wenzhou
 * @since 2023/7/16 15:02
 */
@Data
public class ExcelImportVo {
    private String name;
    private String address;
    private LocalDate birthdate;
    private String phone;
    private String info;
}
