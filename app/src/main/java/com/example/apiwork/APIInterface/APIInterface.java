package com.example.apiwork.APIInterface;

import com.example.apiwork.APIResponse.CategoryResponse;
import com.example.apiwork.APIResponse.Registration;
import com.example.apiwork.APIResponse.SubCategoryResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<Registration> GET_BRAND_RESPONSE_CALL_LOGIN(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("common_model.php")
    Call<CategoryResponse> GET_BRAND_RESPONSE_CALL_COMMON_CATEGORIES(
            @Field("getUsers") String getUsers);

    @FormUrlEncoded
    @POST("sub_common_model.php")
    Call<SubCategoryResponse> GET_BRAND_RESPONSE_CALL_SUB_COMMON_CATEGORIES(
            @Field("category_id") String category_id,
            @Field("getUsers") String getUsers);
}
