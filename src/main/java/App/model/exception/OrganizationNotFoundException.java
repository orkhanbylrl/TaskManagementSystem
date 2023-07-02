package App.model.exception;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(String s) {
        super(s);
    }
}
