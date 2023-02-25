package com.example.miniwebapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("nameDisplay")
    @Expose
    private String nameDisplay;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("updateAt")
    @Expose
    private String updateAt;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("online")
    @Expose
    private Boolean online;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param password
     * @param mail
     * @param nameDisplay
     * @param updateAt
     * @param online
     * @param id
     * @param avatar
     * @param createAt
     * @param userName
     */
    public User(String id, String userName, String nameDisplay, String mail, String password, String createAt, String updateAt, String avatar, Boolean online) {
        super();
        this.id = id;
        this.userName = userName;
        this.nameDisplay = nameDisplay;
        this.mail = mail;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.avatar = avatar;
        this.online = online;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getNameDisplay() {
        return nameDisplay;
    }

    public void setNameDisplay(String nameDisplay) {
        this.nameDisplay = nameDisplay;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("userName");
        sb.append('=');
        sb.append(((this.userName == null)?"<null>":this.userName));
        sb.append(',');
        sb.append("nameDisplay");
        sb.append('=');
        sb.append(((this.nameDisplay == null)?"<null>":this.nameDisplay));
        sb.append(',');
        sb.append("mail");
        sb.append('=');
        sb.append(((this.mail == null)?"<null>":this.mail));
        sb.append(',');
        sb.append("password");
        sb.append('=');
        sb.append(((this.password == null)?"<null>":this.password));
        sb.append(',');
        sb.append("createAt");
        sb.append('=');
        sb.append(((this.createAt == null)?"<null>":this.createAt));
        sb.append(',');
        sb.append("updateAt");
        sb.append('=');
        sb.append(((this.updateAt == null)?"<null>":this.updateAt));
        sb.append(',');
        sb.append("avatar");
        sb.append('=');
        sb.append(((this.avatar == null)?"<null>":this.avatar));
        sb.append(',');
        sb.append("online");
        sb.append('=');
        sb.append(((this.online == null)?"<null>":this.online));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
