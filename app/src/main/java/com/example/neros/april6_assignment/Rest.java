package com.example.neros.april6_assignment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by neros on 4/6/2017.
 */

public class Rest implements Parcelable {
    private String name;
    private String phone;
    private String[] menu;
    private String homepage;
    private int[] regDate;
    private int category;

    public Rest(String name, String phone, String[] menu, String homepage, int[] regDate, int category){
        this.name = name;
        this.phone = phone;
        this.menu = menu;
        this.homepage = homepage;
        this.regDate = regDate;
        this.category = category;
    }

    public Rest(Parcel source){
        this.name = source.readString();
        this.phone = source.readString();
        source.readStringArray(menu);
        this.homepage = source.readString();
        source.readIntArray(regDate);
        this.category = source.readInt();
    }

    // Parcel 에 멤버 변수를 저장한다.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeArray(menu);
        dest.writeString(homepage);
        dest.writeIntArray(regDate);
        dest.writeInt(category);
    }

    public static final Creator<Rest> CREATOR = new Creator<Rest>() {
        @Override
        public Rest createFromParcel(Parcel in) {
            return new Rest(in);
        }

        @Override
        public Rest[] newArray(int size) {
            return new Rest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
