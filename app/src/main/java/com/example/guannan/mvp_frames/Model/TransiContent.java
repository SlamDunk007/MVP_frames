package com.example.guannan.mvp_frames.Model;

/**
 * @author guannan
 * @date 2017/12/13 14:23
 */

public class TransiContent {

    private int status;

    private ContentDetail content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ContentDetail getContent() {
        return content;
    }

    public void setContent(ContentDetail content) {
        this.content = content;
    }

    public class ContentDetail {
        private String ph_am;

        public String getPh_am() {
            return ph_am;
        }

        public void setPh_am(String ph_am) {
            this.ph_am = ph_am;
        }
    }
}
