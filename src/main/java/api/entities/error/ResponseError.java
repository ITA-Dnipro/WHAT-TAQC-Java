package api.entities.error;

public class ResponseError {
    private Error error;

    public ResponseError() {
    }

    public ResponseError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
