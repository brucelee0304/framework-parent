package com.kalix.framework.core.api.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/3.
 */
public class JsonData {
    public static JsonData jsonData = new JsonData();
    private Long totalCount = 0L;
    private List data = new ArrayList<>();

    public static JsonData toJsonData (List newData) {
        if (newData != null) {
            jsonData.setData(newData);
            jsonData.setTotalCount((long) newData.size());
        }
        return jsonData;
    }
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
