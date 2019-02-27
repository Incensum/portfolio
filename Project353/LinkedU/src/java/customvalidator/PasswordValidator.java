/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *Using Mkyng.com for examples
 * @author john
 */
@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator{
private Pattern pattern;
private Matcher matcher;
private static final String PASSWORD_PATTERN = 
              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        String password = value.toString();

	  UIInput uiInputConfirmPassword = (UIInput) component.getAttributes()
		.get("confirmPassword");
	  String confirmPassword = uiInputConfirmPassword.getSubmittedValue()
		.toString();

	  // Let required="true" do its job.
	  if (password == null || password.isEmpty() || confirmPassword == null
		|| confirmPassword.isEmpty()) {
			return;
	  }
        if(!validate(password)){
            uiInputConfirmPassword.setValid(false);
		throw new ValidatorException(new FacesMessage(
			"Password must be 6 to 20 character long with at least one digit, one uppercase letter, one lowercase letter, and one special symbol (“@#$%”) "));
        }
	  if (!password.equals(confirmPassword)) {
		uiInputConfirmPassword.setValid(false);
		throw new ValidatorException(new FacesMessage(
			"Password must match confirm password."));
	  }
    }
    
    public boolean validate(final String password){
		  
		  matcher = pattern.matcher(password);
		  return matcher.matches();
	    	    
	  }
    
}
