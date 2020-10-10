package com.web.manager.pojo;

public class TStudent {
    private Integer nStudentId;

    private String vcStudentCode;

    private String vcStudentName;

    private Integer nSex;

    private Integer nGrade;

    private Integer nMajor;

    private String vcDetail;

    public Integer getnStudentId() {
        return nStudentId;
    }

    public void setnStudentId(Integer nStudentId) {
        this.nStudentId = nStudentId;
    }

    public String getVcStudentCode() {
        return vcStudentCode;
    }

    public void setVcStudentCode(String vcStudentCode) {
        this.vcStudentCode = vcStudentCode == null ? null : vcStudentCode.trim();
    }

    public String getVcStudentName() {
        return vcStudentName;
    }

    public void setVcStudentName(String vcStudentName) {
        this.vcStudentName = vcStudentName == null ? null : vcStudentName.trim();
    }

    public Integer getnSex() {
        return nSex;
    }

    public void setnSex(Integer nSex) {
        this.nSex = nSex;
    }

    public Integer getnGrade() {
        return nGrade;
    }

    public void setnGrade(Integer nGrade) {
        this.nGrade = nGrade;
    }

    public Integer getnMajor() {
        return nMajor;
    }

    public void setnMajor(Integer nMajor) {
        this.nMajor = nMajor;
    }

    public String getVcDetail() {
        return vcDetail;
    }

    public void setVcDetail(String vcDetail) {
        this.vcDetail = vcDetail == null ? null : vcDetail.trim();
    }
}