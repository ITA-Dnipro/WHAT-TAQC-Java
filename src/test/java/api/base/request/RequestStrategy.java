package api.base.request;

import io.restassured.specification.RequestSpecification;

public interface RequestStrategy {

    RequestSpecification getRequest();
}
