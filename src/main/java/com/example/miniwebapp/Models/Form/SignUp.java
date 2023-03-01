package com.example.miniwebapp.Models.Form;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogUp {

    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("nameDisplay")
    @Expose
    private String nameDisplay;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("mail")
    @Expose
    private String mail;

    /**
     * No args constructor for use in serialization
     *
     */
    public LogUp() {
    }

    /**
     *
     * @param password
     * @param mail
     * @param nameDisplay
     * @param userName
     */
    public LogUp(String userName, String nameDisplay, String password, String mail) {
        super();
        this.userName = userName;
        this.nameDisplay = nameDisplay;
        this.password = password;
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LogUp withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getNameDisplay() {
        return nameDisplay;
    }

    public void setNameDisplay(String nameDisplay) {
        this.nameDisplay = nameDisplay;
    }

    public LogUp withNameDisplay(String nameDisplay) {
        this.nameDisplay = nameDisplay;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LogUp withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LogUp withMail(String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LogUp.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("userName");
        sb.append('=');
        sb.append(((this.userName == null)?"<null>":this.userName));
        sb.append(',');
        sb.append("nameDisplay");
        sb.append('=');
        sb.append(((this.nameDisplay == null)?"<null>":this.nameDisplay));
        sb.append(',');
        sb.append("password");
        sb.append('=');
        sb.append(((this.password == null)?"<null>":this.password));
        sb.append(',');
        sb.append("mail");
        sb.append('=');
        sb.append(((this.mail == null)?"<null>":this.mail));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}