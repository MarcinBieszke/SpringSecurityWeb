package crm.constraint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidImp implements ConstraintValidator<PasswordValid, String>{
	
	private String patternString = "\\d+\\d*[a-z]*[A-Z]";
	private Pattern pattern = Pattern.compile(patternString);

	@Override
	public void initialize(PasswordValid passwordValid) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		Matcher matcher = pattern.matcher(password);
		return matcher.find();
	}

}
