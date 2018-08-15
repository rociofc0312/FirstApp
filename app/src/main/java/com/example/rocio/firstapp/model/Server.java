package com.example.rocio.firstapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Server implements Parcelable{
    private String profile_image;
    private String name;
    private String age;
    private String qualification;
    private String status;

    public Server(String profile_image, String name, String age, String qualification, String status) {
        this.profile_image = profile_image;
        this.name = name;
        this.age = age;
        this.qualification = qualification;
        this.status = status;
    }


    protected Server(Parcel in) {
        profile_image = in.readString();
        name = in.readString();
        age = in.readString();
        qualification = in.readString();
        status = in.readString();
    }

    public static final Creator<Server> CREATOR = new Creator<Server>() {
        @Override
        public Server createFromParcel(Parcel in) {
            return new Server(in);
        }

        @Override
        public Server[] newArray(int size) {
            return new Server[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(profile_image);
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(qualification);
        parcel.writeString(status);
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getQualification() {
        return qualification;
    }

    public String getStatus() {
        return status;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
