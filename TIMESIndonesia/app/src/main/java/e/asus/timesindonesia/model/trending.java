package e.asus.timesindonesia.model;

import android.os.Parcel;
import android.os.Parcelable;

public class trending implements Parcelable {
    String judul;
    String tgl;
    String kategori;
    String gmbr;
    String nomer;
    String isi;

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public trending(){}

    protected trending(Parcel in) {
        judul = in.readString();
        tgl = in.readString();
        kategori = in.readString();
        gmbr = in.readString();
        nomer = in.readString();
        isi = in.readString();
    }

    public static final Creator<trending> CREATOR = new Creator<trending>() {
        @Override
        public trending createFromParcel(Parcel in) {
            return new trending(in);
        }

        @Override
        public trending[] newArray(int size) {
            return new trending[size];
        }
    };

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGmbr() {
        return gmbr;
    }

    public void setGmbr(String gmbr) {
        this.gmbr = gmbr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(tgl);
        parcel.writeString(kategori);
        parcel.writeString(gmbr);
        parcel.writeString(nomer);
        parcel.writeString(isi);
    }
}
