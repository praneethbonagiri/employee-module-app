package com.learning.microservices.employee.service.app.response;

public class EmployeeResponse<T> {

    private T employee;
    private String message;
    private Integer responseCode;

    public EmployeeResponse(T obj, String message, Integer responseCode) {
        this.employee = obj;
        this.message = message;
        this.responseCode = responseCode;
    }

    public T getEmployee() {
        return employee;
    }

    public void setEmployee(T employee) {
        this.employee = employee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
