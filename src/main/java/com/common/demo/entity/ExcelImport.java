package com.common.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.common.mybatis.base.BaseEntity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ExcelImport
 *
 * @author Wenzhou
 * @since 2023/7/16 13:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExcelImport extends BaseEntity {
    @TableId(type = IdType.ASSIGN_UUID, value = "id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("address")
    private String address;
    @TableField("birthdate")
    private LocalDate birthdate;
    @TableField("phone")
    private String phone;
}
