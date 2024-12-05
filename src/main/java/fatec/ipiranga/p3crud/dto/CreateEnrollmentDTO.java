package fatec.ipiranga.p3crud.dto;

public record CreateEnrollmentDTO(
        String name,
        String code,
        String email,
        String password,
        String document,
        String enrollmentGroup,
        String observation
) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String document() {
        return document;
    }

    @Override
    public String enrollmentGroup() {
        return enrollmentGroup;
    }

    @Override
    public String observation() {
        return observation;
    }
}
