package com.common.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.core.vo.ImportResultVo;
import com.common.demo.entity.ExcelImport;
import com.common.demo.vo.ExcelImportVo;

import org.springframework.web.multipart.MultipartFile;

/**
 * ExcelService
 *
 * @author Wenzhou
 * @since 2023/7/16 13:39
 */
public interface ExcelImportService extends IService<ExcelImport> {
    /**
     * 测试导入功能
     *
     * @param file MultipartFile
     * @return ImportResultVo
     */
    ImportResultVo<ExcelImportVo> testImport(MultipartFile file);
}
