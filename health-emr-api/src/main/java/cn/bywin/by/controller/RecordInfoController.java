package cn.bywin.by.controller;

import cn.bywin.common.model.ParameterMap;
import cn.bywin.common.model.Result;
import cn.bywin.common.utils.RandomUtil;
import cn.bywin.common.utils.Util;
import cn.bywin.by.model.RecordInfo;
import cn.bywin.by.service.RecordInfoServ;
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
@RequestMapping("/recordinfo")
public class RecordInfoController {

	@Autowired
	private RecordInfoServ serv;

	@PostMapping("/list")
	@RequiresPermissions("recordinfo:list")
	@ApiOperation(value="列表")
	public Result list(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList(params));
	}

	@PostMapping("/detail")
    @RequiresPermissions("recordinfo:detail")
	@ApiOperation(value="详情")
	public Result detail(@RequestBody RecordInfo entity){
        String id = Util.nvl(entity.getId());
		return ResultUtil.success(serv.selectByPK(id));
	}

    @PostMapping("/add")
    @RequiresPermissions("recordinfo:add")
	@ApiOperation(value="添加")
	public Result add(@RequestBody RecordInfo entity){
		entity.setId(Long.valueOf(RandomUtil.getPrimaryKey()));
		return ResultUtil.success(serv.insert(entity));
	}

	@PostMapping("/update")
    @RequiresPermissions("recordinfo:update")
	@ApiOperation(value="更新")
	public Result update(@RequestBody RecordInfo entity){
		return ResultUtil.success(serv.updateSelective(entity));
	}

	@PostMapping("/delete")
    @RequiresPermissions("recordinfo:delete")
	@ApiOperation(value="删除")
	public Result delete(@RequestBody RecordInfo entity){
		String id = Util.nvl(entity.getId());
		return ResultUtil.success(serv.deleteByPK(id));
	}

}
