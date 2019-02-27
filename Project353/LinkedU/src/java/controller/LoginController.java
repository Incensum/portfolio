/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginInfoDAO;
import dao.LoginInfoDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javamailapp.JavaMailApp;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import model.Users;
import model.LoginInfo;

/**
 *
 * @author john
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    private int loginAttempt = 0;
    private String maxLogin = null;
private LoginInfo loginInfoModel;
private Users userModel;
private String page;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        loginInfoModel = new LoginInfo();
        userModel = new Users();
    }


    /**
     * @return the userModel
     */
    public Users getUserModel() {
        return userModel;
    }

    /**
     * @param userModel the userModel to set
     */
    public void setUserModel(Users userModel) {
        this.userModel = userModel;
    }

    /**
     * @return the loginInfoModel
     */
    public LoginInfo getLoginInfoModel() {
        return loginInfoModel;
    }

    /**
     * @param loginInfoModel the loginInfoModel to set
     */
    public void setLoginInfoModel(LoginInfo loginInfoModel) {
        this.loginInfoModel = loginInfoModel;
    }
    
    public String createUserLoginInfo(){
        LoginInfoDAO aLogin = new LoginInfoDAOImpl();
        UserDAO aUser = new UserDAOImpl();
            
        int loginRC = aLogin.createLoginInfo(loginInfoModel);
        int userRC = aUser.createUser(userModel, loginInfoModel.getUserId());
        if(userRC == 1 && loginRC ==1){
            JavaMailApp mail = new JavaMailApp();
            mail.sendMail(userModel.getEmail(), userModel.getFirstName(), userModel.getLastName(), userModel.getUserID(), loginInfoModel.getPassword(), userModel.getEmail(), userModel.getSecQuestion(), userModel.getSecAnswer());
        return "echo?redirect=true";
        }
        else{
          return  "error.xhtml";
        }
    } 

    /**
     * @return the page
     */
    public String getPage() {
        //System.out.println(loginInfoModel.getUserId() +", " + loginInfoModel.getPassword());
        if(loginAttempt >= 3){
            maxLogin = "You have exceeded 3 login attempts. Please come back later.";            
            page = "LoginBad.xhtml";
            return page;
        }
        if(LoginInfo.authenticate(loginInfoModel.getUserId(), loginInfoModel.getPassword())){
            page = "LoginGood.xhtml";
        }
        else{
            loginAttempt++;
            page = "LoginBad.xhtml";
        }
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page) {
        this.page = page;
    }
    
    public String isAuth(ComponentSystemEvent event) {
        String navi = null;

        if (loginInfoModel.getUserId() == null) {

            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("login.xhtml?faces-redirect=true");
            
        }

        return navi;
    }

    /**
     * @return the maxLogin
     */
    public String getMaxLogin() {
        return maxLogin;
    }

    /**
     * @param maxLogin the maxLogin to set
     */
    public void setMaxLogin(String maxLogin) {
        this.maxLogin = maxLogin;
    }
}
