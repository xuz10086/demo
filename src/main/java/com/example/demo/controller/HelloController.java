package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.utils.JSONObject;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
// Controller说明，一般用tags属性介绍Controller
@Api(value = "这是一个标题", tags = "这是一个测试Controller")
public class HelloController {

    // 方法说明，value为方法标题，notes为描述信息
    @ApiOperation(value = "这是一个测试方法", notes = "没有任何参数", httpMethod = "POST")
    // 方法参数集合，ApiImplicitParam每个参数的设置：value为参数介绍；paramType="form"在POST请求中使用，省略掉会400；dataType设置参数类型(默认String)；required设置是否必传
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", paramType="form", dataType = "long"),
                        @ApiImplicitParam(name = "username", value = "用户名为必传参数", paramType="form", required = true),
                        @ApiImplicitParam(name = "password", value = "密码为必传参数", paramType="form", defaultValue = "123")})
    // 设置方法响应状态码说明
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping("/helloController")
    public String helloController(long id,String username,String password) {
        return "用户ID：" + id + "username：" + username + "password" +password;
    }

    @ApiOperation(value = "查询用户接口", notes = "用户查询： \n 参数需要使用json封装", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping("/queryUser")
    // @ApiParam感觉和ApiImplicitParams差不多，但属性没它全，用于对象说明，前段传过来一个json封装的对象时，必须用@RequestBody来接受
    public JSONObject queryUser(@ApiParam(name = "User", value = "描述信息，这是一个json", required = true) @RequestBody User user) {
        return JSONObject.build(200, "OK", user);
    }
}
