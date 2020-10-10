package com.web.manager.pojo;

public class TUser {
    private Integer nUserId;

    private String vcLoginName;

    private String vcPassword;

    public Integer getnUserId() {
        return nUserId;
    }

    public void setnUserId(Integer nUserId) {
        this.nUserId = nUserId;
    }

    public String getVcLoginName() {
        return vcLoginName;
    }

    public void setVcLoginName(String vcLoginName) {
        this.vcLoginName = vcLoginName == null ? null : vcLoginName.trim();
    }

    public String getVcPassword() {
        return vcPassword;
    }

    public void setVcPassword(String vcPassword) {
        this.vcPassword = vcPassword == null ? null : vcPassword.trim();
    }
}