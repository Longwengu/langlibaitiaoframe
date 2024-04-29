package com.apeframe.user.controller;


import com.apeframe.common.web.bean.Result;
import com.apeframe.user.entity.dto.UserDTO;
import com.apeframe.user.entity.po.UserPo;
import com.apeframe.user.entity.req.UserPageReq;
import com.apeframe.user.entity.req.UserReq;
import com.apeframe.user.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RedisTemplate redisTemplate;

    public UserController(UserService userService, RedisTemplate redisTemplate) {
        this.userService = userService;
        this.redisTemplate = redisTemplate;
    }



    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello world";
    }

    @RequestMapping(value = "/testRedis", method = RequestMethod.GET)
    public String testRedis(){
        redisTemplate.opsForValue().set("name", "gwl");
        return "hello world";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result<Integer> addUser(@RequestBody UserReq userReq){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userReq, userDTO);
        int rows = userService.addUser(userDTO);
        return Result.ok(rows);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Result<Integer> delete(@PathVariable Integer id){
        int rows = userService.deleteUser(id);
        return Result.ok(rows);
    }


    @RequestMapping(value = "/findByPage", method = RequestMethod.GET)
    public Result<IPage<UserPo>> findByPage(UserPageReq userPageReq){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userPageReq, userDTO);
        IPage<UserPo> userByPage = userService.findUserByPage(userDTO);
        return Result.ok(userByPage);
    }
}
