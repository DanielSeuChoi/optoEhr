package health.data.optoehr.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import health.data.optoehr.models.Prescription;

@Component
public class PrescriptionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Prescription.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Prescription prescription = (Prescription) object;

    }
}
