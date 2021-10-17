package page.unassigned;

public enum UnassignedRole {
    STUDENT("student"),
    MENTOR("mentor"),
    SECRETARY("secretary");

    private final String option;

    private UnassignedRole(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
