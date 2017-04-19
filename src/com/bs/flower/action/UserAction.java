package com.bs.flower.action;

import com.bs.flower.entity.Users;
import com.bs.flower.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ben on 2017/4/7.
 */
public class UserAction extends ActionSupport {
    //spring管理
    private UserService userService;

    //struts2管理
    private Users users;
    private String err;

    /**
     * 用户注册
     * @return
     */
    public String userRegister(){
        Users u = new Users();
        u.setUserName(users.getUserName());
        u.setPassword(users.getPassword());
        u.setRealName(users.getRealName());
        u.setPwdQuestion(users.getPwdQuestion());
        u.setPwdQuestionAnswer(users.getPwdQuestionAnswer());
        u.setPhoneNo(users.getPhoneNo());
        u.setEmail(users.getEmail());
        u.setAddress(users.getAddress());
        //保存用户
        userService.save(u);
        return "login";
    }

    /**
     * 验证用户名是否存在
     * @return
     */
    public String findByName() throws IOException {
        if(!users.getUserName().equals("") && users.getUserName()!=null){
            Users exisUser = userService.findByUserName(users.getUserName());
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            if (exisUser != null){
                response.getWriter().println("<font style=\"color: red\">用户名已存在</font>");
            } else {
                response.getWriter().println("<font style=\"color: green\">用户名可用</font>");
            }
        }
        return null;
    }

    /**
     * 用户登陆
     * @return
     */
    public String userLogin(){
        Map session = (Map) ActionContext.getContext().getSession();
        Users u = userService.checkUser(users);
        if (u != null){
            session.put("user",u);
            return "login success";
        }else {
            err = "用户名或密码错误";
            return "login";
        }
    }

    /**
     * 用户注销
     * @return
     */
    public String userLogout(){
        Map session = (Map) ActionContext.getContext().getSession();
        session.remove("user");
        return "logout";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
