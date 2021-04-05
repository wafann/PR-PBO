# PR_PBO
PR PBO- Inheritance
Nama :  Wafa Nurjannah (1906321)
        Nabila Luthfiyah (1904436)
Kelas : Pendidikan Ilmu Komputer A UPI 2019

Perubahan yang dibuat : 

1. Kelas Item yang sudah ada dibuat menjadi parent, akan tetapi namanya diubah menjadi Objek. kodingan di dalamnya tinggal di sesuaikan saja.
2. Kelas Objek ini memiliki 3 Child yaitu, Npc(nanti di dalemnya ada item kunci), ItemGaBisaDiambil(pintu), ItemBisaDiambil(roti,cincin)              --> Inheritancenya
        - Kelas child npc
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
            }}
            
           - Kelas child ItemGaBisaDiambil
            public class ItemGaBisaDiambil extends Objek{
            public ItemGaBisaDiambil(String nama){
                ArrayList<String> arrAksi = new ArrayList<>();
                arrAksi.add("Deskripsikan pintu");
                arrAksi.add("Coba buka pintu");

                super.setArrAksi(arrAksi);
                super.setNama(nama);
            }}
            
            - Kelas child ItemBisaDiambil
            public class ItemBisaDiambil extends Objek{
            public ItemBisaDiambil(String nama){
                super.setNama(nama);
            }}
        
        
4. Jangan lupa untuk memberikan override di aksi-aksi di dalam kelas child agar saat program berjalan tidak ke parent-nya 
5. Polymorphismnya ada pada saat perulangan output Objek-objek di kelas ruangan. jadi seluruh kelas yang memiliki parent yang sama tidak perlu print secara terpisah, bisa dilakukan print langsung karena sudah ditampung di arrayList di kelas Objek
        public void pilihanAksi() {

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        //aksi2 item
        System.out.println("Item di ruangan");
        for (Objek objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }
        
         System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10
        
        Objek objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }
7. Apabila item kunci sudah diambil player lalu dibuang, maka npc tidak memiliki kunci itu lagi. kunci tetap berada di ruangan tapi tidak disimpan oleh npc








