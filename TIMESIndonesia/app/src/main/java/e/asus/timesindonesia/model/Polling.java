package e.asus.timesindonesia.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Polling implements Parcelable {
    String title;
    String date;

    protected Polling(Parcel in) {
        title = in.readString();
        date = in.readString();
    }

    public static final Creator<Polling> CREATOR = new Creator<Polling>() {
        @Override
        public Polling createFromParcel(Parcel in) {
            return new Polling(in);
        }

        @Override
        public Polling[] newArray(int size) {
            return new Polling[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(date);
    }

    public Polling(){}
}
