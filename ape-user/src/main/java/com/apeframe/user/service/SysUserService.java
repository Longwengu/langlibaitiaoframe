package com.apeframe.user.service;

import com.apeframe.user.entity.po.SysUser;
import com.apeframe.user.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2024-04-22 13:45:39
 */
@Service("sysUserService")
public class SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    
    public SysUser queryById(Integer id) {
        return this.sysUserMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysUser 筛选条件
     * @param page      分页对象
     * @return 查询结果
     */

    public IPage<SysUser> queryByPage(SysUser sysUser, IPage page) {
        IPage<SysUser> pageResult = this.sysUserMapper.queryAllByPage(sysUser, page);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    
    public SysUser insert(SysUser sysUser) {
        this.sysUserMapper.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    
    public SysUser update(SysUser sysUser) {
        this.sysUserMapper.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    
    public boolean deleteById(Integer id) {
        return this.sysUserMapper.deleteById(id) > 0;
    }
}
