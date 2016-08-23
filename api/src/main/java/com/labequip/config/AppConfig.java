package com.labequip.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 19/08/2016.
 */
@Configuration
public class AppConfig {


    @Value("${api.en.errorMessage}")
    //uses spring expression language
    private String errorMessage;

    @Value("${api.en.successMessage}")
    //uses spring expression language
    private String successMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
