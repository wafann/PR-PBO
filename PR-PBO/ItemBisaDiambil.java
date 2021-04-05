import java.util.ArrayList;

public class ItemBisaDiambil extends Objek{
    public ItemBisaDiambil(String nama){
        super.setNama(nama);
    }

    @Override
    public void prosesAksi(int pil) {
        //pilihan user untuk aksi yang akan diambil
        //urutan harus sama dengan isi arrAksi
        if (pil==1) {
            System.out.println(super.getDeskripsi());
        } else  if (pil==2) {  //bisa ambil atau buang
            if (super.getObjRuangan()==null) {
                //dipegang player, buang ke ruangan
                dibuang();
            } else {
                //ada di ruangan, diambil player
                diambil();
            }
        }
    }

    private void dibuang() {
        System.out.println("Item dibuang player ke ruangan");
        super.getObjGameInfo().getObjPlayer().hapusItem(this); //hapus dari player
        super.getObjGameInfo().getObjRuangan().addItem(this);  //tambah ke ruangan
        super.setObjRuangan(super.getObjGameInfo().getObjRuangan()); // set ruangan
    }

    //pindahkan item dari ruangan ke player
    private void diambil() {
        System.out.println("Item diambil player");
        super.getObjGameInfo().getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        super.getObjRuangan().hapusItem(this);                    //hapus dari ruangan
        super.setObjRuangan(null);
    }

    @Override
    public ArrayList<String> getAksi() {
        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();
        if (super.getObjRuangan()==null) {
            //ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else {
            //ada di ruangan ada opsi ambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return(arrOut);
    }
}
