package com.goldenspace.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse<T> {
    protected boolean success;
    protected List<String> messages;
    protected T data;

    public static <T> ServiceResponse<T> success(T data) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> ServiceResponse<T> error(String error) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(false);
        response.setMessages(List.of(error)); 
        return response;
    }
}
