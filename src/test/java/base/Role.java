package base;

public enum Role {
        ADMIN("admin"),
        MENTOR("mentor"),
        STUDENT("student"),
        SECRETARY("secretary");

        private final String roleName;
        Role(String name){this.roleName = name;}
        public String getRoleName() {return roleName;}
}

