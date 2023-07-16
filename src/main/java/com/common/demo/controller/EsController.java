package com.common.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.core.util.R;
import com.common.es.client.EsQueryClient;
import com.common.es.vo.PageRows;
import com.common.es.vo.SearchReq;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * EsController
 *
 * @author Wenzhou
 * @since 2023/7/15 10:26
 */
@RestController
@RequestMapping("/es")
@RequiredArgsConstructor
public class EsController {
    private final EsQueryClient esQueryClient;

    @PostMapping("/{index}/list/_search")
    public R<PageRows<JSONObject>> indexListSearch(@PathVariable("index") String index) {
        SearchReq req = new SearchReq("*:*", 0, 10);
        return R.ok(esQueryClient.search(index, req));
    }
}
