package com.common.demo.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.core.excel.ImportDataListener;
import com.common.core.exception.ImportException;
import com.common.core.vo.ImportResultVo;
import com.common.demo.entity.ExcelImport;
import com.common.demo.mapper.ExcelImportMapper;
import com.common.demo.service.ExcelImportService;
import com.common.demo.vo.ExcelImportVo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

/**
 * @author Wenzhou
 * @since 2023/7/16 13:46
 */
@Service
@RequiredArgsConstructor
public class ExcelImportServiceImpl extends ServiceImpl<ExcelImportMapper, ExcelImport>
        implements ExcelImportService {
    @Transactional(rollbackFor = RuntimeException.class)
    public ImportResultVo<ExcelImportVo> testImport(MultipartFile file) {
        try {
            String[] head = new String[]{"名称", "地址", "生日", "手机号"};
            ImportDataListener<ExcelImportVo> listener = new ImportDataListener<>(head, (item) -> {
                if (StringUtils.isNotEmpty(item.getName()) && item.getName().startsWith("周")) {
                    return true;
                }
                item.setInfo("名称必须以周开头");
                return false;
            }, (item) -> this.saveBatch(item.stream().map(vo -> ExcelImport.builder()
                    .name(vo.getName()).phone(vo.getPhone()).address(vo.getAddress())
                    .birthdate(vo.getBirthdate()).build()).collect(Collectors.toList()))
            );
            EasyExcel.read(file.getInputStream(), ExcelImportVo.class, listener).sheet().doRead();
            return listener.buildResult();
        } catch (IOException e) {
            throw new ImportException(e);
        }
    }
}
