package com.example.apiwork.APIResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonResponse {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("massage")
    @Expose
    private String massage;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
