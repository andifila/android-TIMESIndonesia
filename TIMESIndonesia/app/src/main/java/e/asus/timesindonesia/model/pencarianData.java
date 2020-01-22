package e.asus.timesindonesia.model;

import java.util.ArrayList;

public class pencarianData {
    public static String[][] data = new String[][]{
            {"Peristiwa", "KPK RI Periksa Miryam S Haryani Sebagai Saksi Tersangka Tannos", "Rabu, 31 Juli 2019", "https://tinyurl.com/yxekaps4"},
            {"Peristiwa", "KPK RI Periksa Miryam S Haryani Sebagai Saksi Tersangka Tannos", "Rabu, 31 Juli 2019", "https://tinyurl.com/yxekaps4"},
            {"Peristiwa", "KPK RI Periksa Miryam S Haryani Sebagai Saksi Tersangka Tannos", "Rabu, 31 Juli 2019", "https://tinyurl.com/yxekaps4"},
            {"Peristiwa", "KPK RI Periksa Miryam S Haryani Sebagai Saksi Tersangka Tannos", "Rabu, 31 Juli 2019", "https://tinyurl.com/yxekaps4"},
            {"Peristiwa", "KPK RI Periksa Miryam S Haryani Sebagai Saksi Tersangka Tannos", "Rabu, 31 Juli 2019", "https://tinyurl.com/yxekaps4"},
    };

    public static ArrayList<pencarian> getListData() {
        ArrayList<pencarian> list = new ArrayList<>();
        for (String[] aData : data) {
            pencarian news = new pencarian();
            news.setKategori(aData[0]);
            news.setJudul(aData[1]);
            news.setTgl(aData[2]);
            news.setPhoto(aData[3]);
            list.add(news);
        }
        return list;
    }
}
