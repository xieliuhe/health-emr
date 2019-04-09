package cn.bywin.by.dao;



import cn.bywin.by.model.HistoryInfo;
import cn.bywin.common.dao.BaseMapper;

import java.util.List;
import java.util.Map;

public interface HistoryInfoMapper extends BaseMapper<HistoryInfo>{
    List<Map<String, Object>> selectList1(Map<String, Object> m);
}
