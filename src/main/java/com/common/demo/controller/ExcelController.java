package com.common.demo.controller;

import com.common.core.util.R;
import com.common.core.vo.ImportResultVo;
import com.common.demo.service.ExcelImportService;
import com.common.demo.vo.ExcelImportVo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

/**
 * ExcelController
 *
 * @author Wenzhou
 * @since 2023/7/16 13:36
 */
@RestController
@RequestMapping("/excel")
@RequiredArgsConstructor
public class ExcelController {
    private final ExcelImportService excelService;

    @PostMapping("/_import")
    public R<ImportResultVo<ExcelImportVo>> testImport(@RequestParam("file") MultipartFile file) {
        return R.ok(excelService.testImport(file));
    }

}
