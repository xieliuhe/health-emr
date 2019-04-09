package cn.bywin.by.controller;

import cn.bywin.common.model.ParameterMap;
import cn.bywin.common.model.Result;
import cn.bywin.common.utils.RandomUtil;
import cn.bywin.common.utils.Util;
import cn.bywin.by.model.HistoryInfo;
import cn.bywin.by.service.HistoryInfoServ;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.bywin.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/historyinfo")
public class HistoryInfoController {

	@Autowired
	private HistoryInfoServ serv;

	@PostMapping("/list")
	@RequiresPermissions("historyinfo:list")
	@ApiOperation(value="列表")
	public Result list(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList(params));
	}

	@PostMapping("/list2")
	@RequiresPermissions("historyinfo:list")
	@ApiOperation(value="列表")
	public Result list2(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList2(params));
	}

	@PostMapping("/detail")
    @RequiresPermissions("historyinfo:detail")
	@ApiOperation(value="详情")
	public Result detail(@RequestBody HistoryInfo entity){
        String id = Util.nvl(entity.getId());
		return ResultUtil.success(serv.selectByPK(id));
	}

    @PostMapping("/add")
    @RequiresPermissions("historyinfo:add")
	@ApiOperation(value="添加")
	public Result add(@RequestBody HistoryInfo entity){
		entity.setId(Long.valueOf(RandomUtil.getPrimaryKey()));
		return ResultUtil.success(serv.insert(entity));
	}

	@PostMapping("/update")
    @RequiresPermissions("historyinfo:update")
	@ApiOperation(value="更新")
	public Result update(@RequestBody HistoryInfo entity){
		return ResultUtil.success(serv.updateSelective(entity));
	}

	@PostMapping("/delete")
    @RequiresPermissions("historyinfo:delete")
	@ApiOperation(value="删除")
	public Result delete(@RequestBody HistoryInfo entity){
		String id = Util.nvl(entity.getId());
		return ResultUtil.success(serv.deleteByPK(id));
	}

}
