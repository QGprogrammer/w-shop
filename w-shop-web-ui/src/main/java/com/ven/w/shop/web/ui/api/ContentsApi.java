package com.ven.w.shop.web.ui.api;


import com.ven.w.shop.commons.utils.HttpClientUtils;
import com.ven.w.shop.commons.utils.MapperUtils;
import com.ven.w.shop.web.ui.dto.TbContent;

import java.util.List;

public class ContentsApi {

    /**
     * 请求幻灯片
     *
     * @return
     */
    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
