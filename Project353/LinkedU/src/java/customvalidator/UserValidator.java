/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customvalidator;

import dao.UserDAO;
import dao.UserDAOImpl;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author john
 */
@FacesValidator("userValidator")
public class UserValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        UserDAO check = new UserDAOImpl();
                String userID = value.toString();
                boolean exists = check.exists(userID);
        
	  // Let required="true" do its job.
	  if (userID == null || userID.isEmpty()) {
			return;
	  }

	  if (exists) {
		throw new ValidatorException(new FacesMessage(
			"User ID already exists. Please choose another."));
	  }
    }
    
}
