import java.util.ArrayList;

public class Objek{
    private String deskripsi;
    private String nama;
    private ArrayList<String> arrAksi = new ArrayList<>(); //pilihan aksi untuk item
    private Ruangan objRuangan;  //ruangan tempat item, jika null artinya item dipegang npc atau plyaer
    private GameInfo objGameInfo;

    //constructor
//    public Item(String nama) {
//        this.nama = nama;
//        // -- dipindahkan karena dinamik tergantung diambil atau dibuang
//        //  arrAksi.add("Deskripsi Item");
//        //  arrAksi.add("Ambil item");
//    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void printObjek() {
        //print deskripsi item
        System.out.println(deskripsi);
    }

    public ArrayList<String> getAksi() {
        return arrAksi;
    }

    public void prosesAksi(int pil) {
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public Ruangan getObjRuangan() {
        return objRuangan;
    }
    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }
    public ArrayList<String> getArrAksi() {
        return arrAksi;
    }

    public void setArrAksi(ArrayList<String> arrAksi) {
        this.arrAksi = arrAksi;
    }
}
