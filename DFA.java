package otomataodev;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA {

    Map<Set<Integer>, Map<Character, Set<Integer>>> Gecis;
    Set<Set<Integer>> Kabul;

    public DFA() {
        Gecis = new HashMap<>();
        Kabul = new HashSet<>();
    }

    public void Kabul(Set<Integer> durum) {
        Kabul.add(durum);
    }

    public void Gecis(Set<Integer> baslangic, char ab, Set<Integer> hedef) {
        Gecis.putIfAbsent(baslangic, new HashMap<>());
        Gecis.get(baslangic).put(ab, hedef);
    }

    public boolean Kontrol(String dizge) {
        Set<Integer> aktif = new HashSet<>();
        aktif.add(0);

        System.out.println("Başlangıç: " + aktif);

        for (char sembol : dizge.toCharArray()) {
            
            if (!Gecis.containsKey(aktif) || !Gecis.get(aktif).containsKey(sembol)) {
                System.out.println("REDDEDİLDİ.");
                return false;
            }
      
            aktif = Gecis.get(aktif).get(sembol);
            System.out.println("Sembol: " + sembol + " --> Yeni durum: " + aktif);
        }

        if (Kabul.contains(aktif)) {
            System.out.println("KABUL EDİLDİ.");
            return true;
        }

        System.out.println("REDDEDİLDİ.");
        return false;
    }


    public void yazdir() {
        System.out.println("DFA:");
        for (var yaz : Gecis.entrySet()) {
            Set<Integer> durum = yaz.getKey();
            for (var gecis : yaz.getValue().entrySet()) {
                char sembol = gecis.getKey();
                Set<Integer> hedef = gecis.getValue();
                System.out.println(durum + " --" + sembol + "--> " + hedef);
            }
        }
        System.out.println("Kabul Durumları: " + Kabul);
    }
}

