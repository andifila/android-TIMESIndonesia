package e.asus.timesindonesia.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Kanal implements Parcelable {
    String gambar;
    String kanal;

    public Kanal() {
    }

    protected Kanal(Parcel in) {
        gambar = in.readString();
        kanal = in.readString();
    }

    public static final Creator<Kanal> CREATOR = new Creator<Kanal>() {
        @Override
        public Kanal createFromParcel(Parcel in) {
            return new Kanal(in);
        }

        @Override
        public Kanal[] newArray(int size) {
            return new Kanal[size];
        }
    };

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKanal() {
        return kanal;
    }

    public void setKanal(String kanal) {
        this.kanal = kanal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gambar);
        parcel.writeString(kanal);
    }
}
