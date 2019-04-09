package cn.bywin.by.service;


import cn.bywin.by.dataBaseConfig.DataSourceContext;
import cn.bywin.by.dataBaseConfig.DataSourceEnum;
import org.springframework.stereotype.Service;

import cn.bywin.by.model.HistoryInfo;
import cn.bywin.common.service.BaseServ;
import cn.bywin.common.service.IBaseServ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryInfoServ extends BaseServ<HistoryInfo> implements IBaseServ<HistoryInfo>{

    public Map selectList2(Map condition) {
        DataSourceContext.setDataSource(DataSourceEnum.FirstDBName.getDbName());
        Map<String, Object> map =super.selectList(condition);
        List<Map<String, Object>> list =(List<Map<String,Object>>) map.get("rows");
        for (Map<String, Object> mp:list) {
            System.out.println(mp.get("oZoneName"));
        }

        Map<String, Object> mapds2=new HashMap<>();
        mapds2.put("",condition.get("t"));
        DataSourceContext.setDataSource(DataSourceEnum.SecondDBName.getDbName());
        Map<String, Object> map1 =super.selectList(mapds2);
        List<Map<String, Object>> list1 =(List<Map<String,Object>>) map1.get("rows");
        for (Map<String, Object> mp:list1) {
            System.out.println(mp.get("oZoneName"));
        }
        return map;
    }

}