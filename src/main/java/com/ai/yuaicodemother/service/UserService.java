package com.ai.yuaicodemother.service;

import com.ai.yuaicodemother.model.dto.user.UserQueryRequest;
import com.ai.yuaicodemother.model.vo.LoginUserVO;
import com.ai.yuaicodemother.model.vo.UserVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.ai.yuaicodemother.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 加密
     *
     * @param userPassword 用户密码
     * @return 加密后的用户密码
     */
    String getEncryptPassword(String userPassword);

    /**
     * 用户登录
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @return 脱敏后用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取脱敏的用户已登录信息
     *
     * @return 登录信息
     */
    LoginUserVO getLoginUserVo(User user);

    /**
     * 获取脱敏后用户信息
     *
     * @param user 完整的用户信息
     * @return
     */
    UserVO getUserVo(User user);

    /**
     * 获取脱敏后用户信息列表
     *
     * @param userList 用户列表
     * @return
     */
    List<UserVO> getUserVoList(List<User> userList);

    /**
     * 用户注销
     *
     * @param request
     * @return 退出登录是否成功
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 根据查询条件构造数据查询参数
     *
     * @param userQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(UserQueryRequest  userQueryRequest);
}
