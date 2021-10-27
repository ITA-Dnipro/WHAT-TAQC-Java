package api.services;

import api.base.BaseRequests;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BaseService {

    protected BaseRequests requests;
    protected ObjectMapper mapper;

    public BaseService(BaseRequests requests) {
        this.requests = requests;
        mapper = new ObjectMapper();
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }
}
