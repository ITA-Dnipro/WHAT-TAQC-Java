package page.unassignedUsers;

public enum Role {
    STUDENT("student"),
    MENTOR("mentor"),
    SECRETARY("secretary");

    private final String option;

    private Role(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
