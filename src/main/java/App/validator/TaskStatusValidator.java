package App.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaskStatusValidator implements ConstraintValidator<TaskStatus, String> {
    @Override
    public boolean isValid(String status, ConstraintValidatorContext context) {
        return (status.equals("PROGRESS") || status.equals("TEST") || status.equals("DONE"));
    }
}
