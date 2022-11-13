package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Urun {
    static List<String> id = new ArrayList<>();
    static List<String> isim = new ArrayList<>();
    static List<String> uretici = new ArrayList<>();
    static List<Integer> miktar = new ArrayList<>();
    static List<String> birim = new ArrayList<>();
    static List<String> raf = new ArrayList<>();
    public static void secenekler(){
        Scanner input = new Scanner(System.in);

        int secim= 0;
        System.out.println("Lutfen yapmak istediginiz islemi seciniz");

        while (secim!=6){
            System.out.println("Urun olusturmalk icin===>1\nUrun eklemek icin===> 2\nUrun cikarmak icin===>3\nRaf degistirmek/rafa eklemek icin===>4\nUrun listesi yazdirmak icin===>5\nCikmak icin===>6");

            secim=input.nextInt();
           switch (secim){
               case 1:
                   urunOlustur();
                   break;
               case 2:
                   urunEklemek();
                   break;
               case 3:
                   urunCikarma();
                   break;
               case 4:
                   rafaKoy();
                   break;
               case 5:
                   urunListesiYazdir();
                   break;
               case 6:
                   System.out.println("Hoscakalin");
                   break;
           }
        }
    }

    public static void urunOlustur() {
        Scanner input = new Scanner(System.in);





            System.out.println("id giriniz");
            String urunId = input.next();
            id.add(urunId);
            String s1 = input.nextLine();


            System.out.println("isim giriniz");
            String urunIsim = input.nextLine();
            isim.add(urunIsim);

            System.out.println("uretici giriniz");
            String urunUretici = input.nextLine();
            uretici.add(urunUretici);

            System.out.println("miktar giriniz");
            int urunMiktar = input.nextInt();
            miktar.add(urunMiktar);
            String s2 = input.nextLine();

            System.out.println("birim giriniz");
            String urunBirim = input.nextLine();
            birim.add(urunBirim);

            System.out.println("raf giriniz");
            String urunRaf = input.nextLine();
            raf.add(urunRaf);



    }

    public static void urunListesiYazdir() {
        for (int i = 0; i < id.size(); i++) {
            System.out.println("urn listesi: " + id.get(i) + " " + isim.get(i) + " " + uretici.get(i) + " " + miktar.get(i) + " " + birim.get(i) + " " + raf.get(i));
        }
    }

    public static int eklenenUrunIndexBul() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ekleme yapmak istediginiz urun id giriniz");
        String girilenId = input.next();
        int urunIndex = 0;
        for (String w : id) {
            if (w.equals(girilenId)) {
                urunIndex = id.indexOf(w);
            }
        }
        return urunIndex;
    }

    public static int eklenecekUrunMiktari() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ekleme yapmak istediginiz urun miktarini giriniz");
        int ekleneceUrunMiktari = input.nextInt();
        return ekleneceUrunMiktari;
    }

    public static List<Integer> urunEkle(int index, int eklenecekMiktar) {
        int son = 0;
        son = miktar.get(index) + eklenecekMiktar;
        miktar.set(index, son);
        return miktar;
    }

    public static List urunEklemek() {

        return urunEkle(eklenenUrunIndexBul(), eklenecekUrunMiktari());
    }

    public static int cikacakUrunIndexBul() {
        Scanner input = new Scanner(System.in);
        System.out.println("Cikarmak istediginiz urun id giriniz");
        String girilenId = input.next();
        int urunIndex = 0;
        for (String w : id) {
            if (w.equals(girilenId)) {
                urunIndex = id.indexOf(w);
            }
        }
        return urunIndex;
    }

    public static int cikacakUrunMiktari() {
        Scanner input = new Scanner(System.in);
        System.out.println("Cikacak istediginiz urun miktarini giriniz");
        int cikacakUrunMiktari = input.nextInt();
        return cikacakUrunMiktari;
    }

    public static List<Integer> urunCikar(int index, int cikacakMiktar) {
        int son = 0;
        son = miktar.get(index) - cikacakMiktar;
        miktar.set(index, son);
        return miktar;
    }

    public static List urunCikarma() {

        return urunCikar(cikacakUrunIndexBul(), cikacakUrunMiktari());
    }


    public static int rafaKonacakIndexBul() {
        Scanner input = new Scanner(System.in);
        System.out.println("Rafa koymak istediginiz urun id giriniz");
        String girilenId = input.next();
        int urunIndex = 0;
        for (String w : id) {
            if (w.equals(girilenId)) {
                urunIndex = id.indexOf(w);
            }
        }
        return urunIndex;
    }

    public static String hangiRafaKonacak() {
        Scanner input = new Scanner(System.in);
        System.out.println("Urunun hangi rafa koncagini giriniz");
        String konacakRaf = input.next();
        return konacakRaf;
    }

    public static List<String> rafaKoyma(int index, String konacakRaf) {
        raf.set(index,konacakRaf);
        return raf;
    }

    public static List rafaKoy() {

        return rafaKoyma(rafaKonacakIndexBul(), hangiRafaKonacak());
    }


}
