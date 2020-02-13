package e.asus.timesindonesia.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Berita implements Parcelable {
    String judul;
    String tgl;
    String kategori;
    String gmbr;
    String isi;

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Berita() {
    }

    protected Berita(Parcel in) {
        judul = in.readString();
        tgl = in.readString();
        kategori = in.readString();
        gmbr = in.readString();
        isi = in.readString();
    }

    public static final Creator<Berita> CREATOR = new Creator<Berita>() {
        @Override
        public Berita createFromParcel(Parcel in) {
            return new Berita(in);
        }

        @Override
        public Berita[] newArray(int size) {
            return new Berita[size];
        }
    };

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
        parcel.writeString(isi);
    }
}
