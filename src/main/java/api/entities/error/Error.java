package api.entities.error;

public class Error {
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public Error setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Error setMessage(String message) {
        this.message = message;
        return this;
    }
}
