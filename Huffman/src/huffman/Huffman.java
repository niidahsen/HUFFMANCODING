package huffman;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author niida
 */
/*
               AHSEN NİDA GULNAR
               02185076090

*/

/*
HOCAM BENİM KODUMDA İLK ÖNCE KULLANICIDAN BİR STRİNG ALDI O STRİNGİN İÇİNDE Kİ HARFLERDEN KAÇTANE OLDUĞUNU BULDUM 
PNDAN SONRA HUFFMAN AĞACIMA YOOLLLADIM VE YAZDIRDIM
*/
public class Huffman {

    public static void yazdir(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {

            System.out.println(root.c + "   |  " + s);

            return;
        }
        yazdir(root.left, s + "0");
        yazdir(root.right, s + "1");
    }

    public static void main(String[] args) {
        
        Scanner gir = new Scanner(System.in);
        String String = gir.next();
        String = String.toUpperCase();//Stringi Büyük harflere çevirdik

        char[] dizi = new char[String.length()];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = ' ';
        }
        int es = String.length();
        int[] frenkas = new int[es];
        String gecici = String;
        char harf;
        //HER HARFTEN KAÇTANE OLDUĞUNU BULMA
        for (int j = 0; j < es; j++) {
            harf = gecici.charAt(j);
            int frenkass = 0;
            for (int i = 0; i < es; i++) {
                if (harf == gecici.charAt(i)) {
                    frenkass++;

                }

            }
            if (harf != ' ') {
                dizi[j] = harf;
                frenkas[j] = frenkass;
                gecici = gecici.replace(harf, ' ');//bir harfi bidaha aramamsı için
            }

            harf = ' ';

        }
       //DAHA ÖNCE OLUŞTURDUĞUM FRENKAS DİZİMDEKİ 0 OLMAYAN ELEMAN SAYISINI BULDUM
        int frenkasdizilengt = 0;
        // System.out.println("frenkaslar");
        for (int i = 0; i < frenkas.length; i++) {//frenkasta 0 var
            if (frenkas[i] != 0) {
                frenkasdizilengt++;
            }
        }
        //0 OLMAYAN DİZİMDDE YENİ BİR DİZİ OLUŞTURUP KAÇ DEĞER VAR SA ONA GÖRE YENİ DİZİ OLUŞTURDUM VE BÖYLELİKLE DAHA DÜZGÜN BİR DİZİ OLUŞTURUYORUM İNDİSLERİ BOŞ OLMAYAN
        int[] frenkas2 = new int[frenkasdizilengt];
        int ff = 0;
        for (int i = 0; i < frenkas.length; i++) {//frenkasta 0 var
            if (frenkas[i] != 0) {
                frenkas2[ff] = frenkas[i];
                ff++;
            }
        }
        int chardizilengt = 0;
        // System.out.println("frenkaslar");
        for (int i = 0; i < dizi.length; i++) {//frenkasta 0 var
            if (dizi[i] != ' ') {
                chardizilengt++;
            }
        }
       
        char[] dizi2 = new char[chardizilengt];
        int g = 0;
        for (int i = 0; i < dizi.length; i++) {//frenkasta 0 var
            if (dizi[i] != ' ') {
                dizi2[g] = dizi[i];
                g++;
            }
        }
        
        //QUEUE OLUŞTURUYORUM

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(chardizilengt, new hufman2());

        for (int i = 0; i < dizi2.length; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c =  dizi2[i];
            hn.item = frenkas2[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.item = x.item + y.item;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
        }
        System.out.println(" Char | Huffman Koduuu ");
        System.out.println("--------------------");
        yazdir(root, "");
    }

}
