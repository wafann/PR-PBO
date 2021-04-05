import java.util.ArrayList;

public class Npc extends Objek {
    private ItemBisaDiambil objKunci;
    private GameInfo objGameInfo;
    private boolean isKenal=false;

    public Npc(String nama){
        ArrayList<String> arrAksi = new ArrayList<>();

        //init kunci
        objKunci = new ItemBisaDiambil("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");

        super.setArrAksi(arrAksi);
        super.setNama(nama);
    }
    @Override
    public void prosesAksi(int subPil) {
        //1: perkenalan dengan npc
        //2: buka pintu
        if (subPil == 1) {
            System.out.println("Halo saya penjaga pintu ini");
            isKenal = true;
        } else if (subPil == 2) {
            if (isKenal) {
                //berikan kunci pada player
                if (objKunci==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else
                {
                    System.out.println("Kunci diberikan pada player");

                    objGameInfo.getObjPlayer().addItem(objKunci);     //tambahkan  objek ini pada player
                    objKunci = null;
                }

            } else {
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

    @Override
    public ArrayList<String> getArrAksi() {
        return super.getArrAksi();
    }
}
