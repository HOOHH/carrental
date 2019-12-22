package com.car.rental.car.rental.apiresponse;

public class ApiResponse<T> {

    private  T data;

    private String requestId;
    private int errorCode;

    public ApiResponse(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public T getData() {
        return data;
    }

}
