package com.common.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.demo.DemoApplicationTest;
import com.common.es.client.EsQueryClient;
import com.common.es.vo.EsSortField;
import com.common.es.vo.PageRows;
import com.common.es.vo.SearchReq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

/**
 * EsControllerTest
 *
 * @author Wenzhou
 * @since 2023/7/15 14:29
 */
@Slf4j
@Component
public class EsControllerTest extends DemoApplicationTest {
    @Autowired
    private EsQueryClient esQueryClient;

    @Test
    public void testQuery() {
        SearchReq req = new SearchReq("*:*", 0, 10);
        req.setFl(Arrays.asList("title", "price"));
        EsSortField field = new EsSortField();
        field.setFiledId("price");
        field.setOrder("desc");
        req.setSortList(Collections.singletonList(field));
        PageRows<JSONObject> json = esQueryClient.search("jd_goods3", req);
        log.info("{}", JSON.toJSONString(json));
    }
}
