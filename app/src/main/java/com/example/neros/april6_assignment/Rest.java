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
    //private String[] menu;
    private String menu1;
    private String menu2;
    private String menu3;
    private String homepage;
    //private int[] regDate;
    private int year;
    private int month;
    private int day;
    private int category;

    public Rest(String name, String phone, String menu1, String menu2, String menu3, String homepage, int year, int month, int day, int category){
        this.name = name;
        this.phone = phone;
        //this.menu = menu;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.homepage = homepage;
        //this.regDate = regDate;
        this.year = year;
        this.month = month;
        this.day = day;
        this.category = category;
    }

    public Rest(Parcel source){
        this.name = source.readString();
        this.phone = source.readString();
        //source.readStringArray(this.menu);
        this.menu1 = source.readString();
        this.menu2 = source.readString();
        this.menu3 = source.readString();
        this.homepage = source.readString();
        //source.readIntArray(this.regDate);
        this.year = source.readInt();
        this.month = source.readInt();
        this.day = source.readInt();
        this.category = source.readInt();
    }

    // Parcel 에 멤버 변수를 저장한다.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        //dest.writeArray(menu);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(homepage);
        //dest.writeIntArray(regDate);
        dest.writeInt(year);
        dest.writeInt(month);
        dest.writeInt(day);
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

    public String getName(){ return this.name; }
    public String getPhone(){ return this.phone; }
    public String getMenu1(){ return this.menu1; }
    public String getMenu2(){ return this.menu2; }
    public String getMenu3(){ return this.menu3; }
    public String getHomepage(){ return this.homepage; }
    public int getYear(){ return this.year; }
    public int getMonth(){ return this.month; }
    public int getDay(){ return this.day; }
    public int getCategory(){ return this.category; }
}
