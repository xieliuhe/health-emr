package cn.bywin.by.controller;

import cn.bywin.common.model.ParameterMap;
import cn.bywin.common.model.Result;
import cn.bywin.common.utils.RandomUtil;
import cn.bywin.common.utils.Util;
import cn.bywin.by.model.ProfileInfo;
import cn.bywin.by.service.ProfileInfoServ;
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
@RequestMapping("/profileinfo")
public class ProfileInfoController {

	@Autowired
	private ProfileInfoServ serv;

	@PostMapping("/list")
	@RequiresPermissions("profileinfo:list")
	@ApiOperation(value="列表")
	public Result list(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList(params));
	}

	@PostMapping("/detail")
    @RequiresPermissions("profileinfo:detail")
	@ApiOperation(value="详情")
	public Result detail(@RequestBody ProfileInfo entity){
        String id = Util.nvl(entity.getId());
		return ResultUtil.success(serv.selectByPK(id));
	}

    @PostMapping("/add")
    @RequiresPermissions("profileinfo:add")
	@ApiOperation(value="添加")
	public Result add(@RequestBody ProfileInfo entity){
		entity.setId(Long.valueOf(RandomUtil.getPrimaryKey()));
		return ResultUtil.success(serv.insert(entity));
	}

	@PostMapping("/update")
    @RequiresPermissions("profileinfo:update")
	@ApiOperation(value="更新")
	public Result update(@RequestBody ProfileInfo entity){
		return ResultUtil.success(serv.updateSelective(entity));
	}

	@PostMapping("/delete")
    @RequiresPermissions("profileinfo:delete")
	@ApiOperation(value="删除")
	public Result delete(@RequestBody ProfileInfo entity){
		String id = Util.nvl(entity.getId());
		return ResultUtil.success(serv.deleteByPK(id));
	}

}
