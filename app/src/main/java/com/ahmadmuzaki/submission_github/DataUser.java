package com.ahmadmuzaki.submission_github;

import android.os.Parcel;
import android.os.Parcelable;

public class DataUser implements Parcelable {
    private String name, username, follower, following;
    private Integer avatar;

    public DataUser() {

    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(follower);
        dest.writeString(following);
        if (avatar == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(avatar);
        }
    }

    protected DataUser(Parcel in) {
        name = in.readString();
        username = in.readString();
        follower = in.readString();
        following = in.readString();
        if (in.readByte() == 0) {
            avatar = null;
        } else {
            avatar = in.readInt();
        }
    }

    public static final Creator<DataUser> CREATOR = new Creator<DataUser>() {
        @Override
        public DataUser createFromParcel(Parcel in) {
            return new DataUser(in);
        }

        @Override
        public DataUser[] newArray(int size) {
            return new DataUser[size];
        }
    };
}
