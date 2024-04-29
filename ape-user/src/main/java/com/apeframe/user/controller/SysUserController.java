package com.apeframe.user.controller;

import com.apeframe.common.web.bean.Result;
import com.apeframe.user.entity.po.SysUser;
import com.apeframe.user.entity.convert.SysUserConverter;
import com.apeframe.user.entity.req.SysUserReq;
import com.apeframe.user.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2024-04-22 13:55:54
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @param sysUserReq 筛选条件
     * @return 查询结果
     */
    @GetMapping("/queryByPage")
    public Result<IPage<SysUser>> queryByPage(SysUserReq sysUserReq) {
        Long current = sysUserReq.getCurrent();
        Long size = sysUserReq.getSize();
        IPage<SysUser> page = new Page<>(current, size);
        SysUser sysUser = SysUserConverter.INSTANCE.convertReq2SysUser(sysUserReq);
        return Result.ok(this.sysUserService.queryByPage(sysUser, page));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<SysUser> queryById(@PathVariable("id") Integer id) {
        return Result.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<SysUser> add(SysUser sysUser) {
        return Result.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<SysUser> edit(SysUser sysUser) {
        return Result.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Integer id) {
        return Result.ok(this.sysUserService.deleteById(id));
    }

}

