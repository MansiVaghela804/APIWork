package com.example.apiwork.APIResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse extends CommonResponse {
    @SerializedName("model_list")
    @Expose
    private List<ModelList> modelList = null;

    public List<ModelList> getModelList() {
        return modelList;
    }

    public void setModelList(List<ModelList> modelList) {
        this.modelList = modelList;
    }

    public class ModelList {
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("category_name")
        @Expose
        private String categoryName;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }
}
