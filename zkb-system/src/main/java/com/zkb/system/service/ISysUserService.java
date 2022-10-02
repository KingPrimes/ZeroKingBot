package com.zkb.system.service;



import com.zkb.common.core.domain.entity.SysUser;

import java.util.List;

/**
 * 用户 业务层
 * 
 * @author KingPrimes
 */
public interface ISysUserService
{
    /**
     * 根据条件分页查询用户列表
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);


    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName);


    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);


    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(String ids);

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 注册用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public boolean registerUser(SysUser user);

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);


    /**
     * 修改用户密码信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(SysUser user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param user 用户信息
     * @return 结果
     */
    public String checkLoginNameUnique(SysUser user);

    /**
     * 校验用户是否允许操作
     * 
     * @param user 用户信息
     */
    public void checkUserAllowed(SysUser user);

    /**
     * 校验用户是否有数据权限
     * 
     * @param userId 用户id
     */
    public void checkUserDataScope(Long userId);


    /**
     * 用户状态修改
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int changeStatus(SysUser user);
}
