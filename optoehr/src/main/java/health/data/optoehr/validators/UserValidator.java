package health.data.optoehr.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import health.data.optoehr.models.User;

@Component
public class UserValidator implements Validator {

    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        if (!user.getPwConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("pwConfirmation", "Match");
        }
    }
}
