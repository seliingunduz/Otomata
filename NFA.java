package otomataodev;
import java.util.*;


public class NFA {
	
	 Map<Integer, Map<Character, Set<Integer>>> gecis;
     Set<Integer> kabul;

	 public NFA() {
	     gecis = new HashMap<>();
	     kabul = new HashSet<>();
	 }

	 public void Gecis(int baslangic, char ab, int hedef) {
	     gecis.putIfAbsent(baslangic, new HashMap<>());
	     gecis.get(baslangic).putIfAbsent(ab, new HashSet<>());
	     gecis.get(baslangic).get(ab).add(hedef);
	 }

	 public void Kabul(int durum) {
	     kabul.add(durum);
	 }

	 public boolean Kontrol(String dizge) {
	     Set<Integer> aktif = new HashSet<>();
	     aktif.add(0); 

	     System.out.println("Başlangıç: " + aktif);

	     for (char sembol : dizge.toCharArray()) {
	         Set<Integer> yeni = new HashSet<>();
	         for (int durum : aktif) {
	             if (gecis.containsKey(durum) &&
	                 gecis.get(durum).containsKey(sembol)) {
	            	 
	                 yeni.addAll(gecis.get(durum).get(sembol));
	             }
	         }
	         aktif = yeni;
	         System.out.println("Sembol: " + sembol + " ---> Yeni durumlar: " + aktif);
	     }

	     for (int durum : aktif) {
	         if (kabul.contains(durum)) {
	             System.out.println("KABUL EDİLDİ.");
	             return true;
	         }
	     }

	     System.out.println("REDDEDİLDİ");
	     return false;
	 }

	 public void yazdir() {
	     System.out.println("NFA:");
	     for (var yaz : gecis.entrySet()) {
	         int Durum = yaz.getKey();
	         for (var devam : yaz.getValue().entrySet()) {
	             char sembol = devam.getKey();
	             for (int hedef : devam.getValue()) {
	                 System.out.println(Durum + " --" + sembol + "--> " + hedef);
	             }
	         }
	     }
	     System.out.println("Kabul Durumları: " + kabul);
	 }
	}

