package com.smart.wechat.controller;

import com.jfinal.kit.Ret;
import io.jboot.support.swagger.ParamType;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by yinh on 2019/10/18
 */
@RequestMapping(value = "/",viewPath = "/WEB-INF/views/index/")
@Api(description = "用户相关接口文档", basePath = "/", tags = "index")
public class IndexController extends JbootController {

    public void index() {
        render("login.html");
    }

    @ApiOperation(value = "用户列表", httpMethod = "GET", notes = "user list")
    public void getUses() {
        renderJson(Ret.ok("k1", "v1").set("name", getPara("name")));
    }


    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "add user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = ParamType.FORM, dataType = "string", required = true),
            @ApiImplicitParam(name = "k1", value = "k1", paramType = ParamType.FORM, dataType = "string", required = true),
    })
    public void add(String username) {
        renderJson(Ret.ok("k1", "v1").set("username", username));
    }
}
