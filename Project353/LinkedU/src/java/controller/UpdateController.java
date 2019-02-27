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
import java.util.ArrayList;
import java.util.Map;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import model.LoginInfo;
import model.Users;

/**
 *
 * @author john
 */
@Named(value = "updateController")
@SessionScoped
public class UpdateController implements Serializable {

    private LoginInfo loginInfoModel;
    private Users userModel;
    private String updateStatus;

    /**
     * Creates a new instance of UpdateController
     */
    public UpdateController() {
        loginInfoModel = new LoginInfo();
        userModel = new Users();
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
     * @return the updateStatus
     */
    public String getUpdateStatus() {
        return updateStatus;
    }

    /**
     * @param updateStatus the updateStatus to set
     */
    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public void updateUserLoginInfo() {
        int uStatus = 0, iStatus = 0;
        UserDAO aUser = new UserDAOImpl();
        LoginInfoDAO info = new LoginInfoDAOImpl();
        if (loginInfoModel.getPassword().isEmpty() || loginInfoModel.getPassword() == null) {
            uStatus = aUser.updateUser(userModel);
            if (uStatus == 1) {
                updateStatus = "Record updated successfully ...";
            } else {
                updateStatus = "Record update failed!";
            }
        } else {
            uStatus = aUser.updateUser(userModel);
            iStatus = info.updatePassword(loginInfoModel.getUserId(), loginInfoModel.getPassword());
            if (uStatus == 1 && iStatus == 1) {
                updateStatus = "Record updated successfully ...";
            } else {
                updateStatus = "Record update failed!";
            }
        }
    }

    public String retrieveProfile() {
        LoginInfoDAO info = new LoginInfoDAOImpl();
        UserDAO aUser = new UserDAOImpl();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, String> params
                = externalContext.getRequestParameterMap();
        String userID = params.get("userID");
        loginInfoModel = info.findRow(userID);
        userModel = aUser.findRow(userID);
        return "update.xhtml";
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
}
