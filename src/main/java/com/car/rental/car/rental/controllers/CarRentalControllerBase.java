package com.car.rental.car.rental.controllers;

import com.car.rental.car.rental.apiresponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class CarRentalControllerBase {


    @Autowired
    private HttpServletRequest request;

    protected <T> ApiResponse<T> getSuccessResponse(T data){
        ApiResponse<T> apiResponse = new ApiResponse<>(data);
        apiResponse.setErrorCode(200);
        String requestId = request.getHeader("x-request-id");
        if(requestId ==null || requestId.isEmpty()){
            requestId = UUID.randomUUID().toString();
        }
        apiResponse.setRequestId(requestId);
        return  apiResponse;
    }

    protected <T> ApiResponse<T> getErrorResponse(){
        ApiResponse<T> response=  new ApiResponse<>(null);
        response.setErrorCode(500);
        String requestId = request.getHeader("x-request-id");
        if(requestId ==null ||requestId.isEmpty()){
            requestId = UUID.randomUUID().toString();
        }
        response.setRequestId(requestId);
        return  response;
    }
}
