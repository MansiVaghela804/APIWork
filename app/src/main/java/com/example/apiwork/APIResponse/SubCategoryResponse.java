package com.example.apiwork.APIResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubCategoryResponse extends CommonResponse {
    @SerializedName("sub_model_list")
    @Expose

    private List<SubModelList> subModelList = null;

    public List<SubModelList> getSubModelList() {
        return subModelList;
    }

    public void setSubModelList(List<SubModelList> subModelList) {
        this.subModelList = subModelList;
    }
    public class SubModelList {

        @SerializedName("sub_id")
        @Expose
        private String subId;
        @SerializedName("sub_image")
        @Expose
        private String subImage;
        @SerializedName("sub_name")
        @Expose
        private String subName;

        public String getSubId() {
            return subId;
        }

        public void setSubId(String subId) {
            this.subId = subId;
        }

        public String getSubImage() {
            return subImage;
        }

        public void setSubImage(String subImage) {
            this.subImage = subImage;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

    }
}
