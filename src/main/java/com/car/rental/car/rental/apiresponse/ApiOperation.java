package com.car.rental.car.rental.apiresponse;

public class ApiOperation {

    private String operationName;

    private String message;

    public String getMessage() {
        return message;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
