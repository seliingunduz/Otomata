package otomataodev;
  
import java.util.*;
public class DilCNfa_SelinGunduz22010310037 {
 public static void main(String[] args) {
	 
     Scanner scanner = new Scanner(System.in);

     NFA nfa = new NFA();
     
     nfa.Kabul(8);
     
     nfa.Gecis(0, 'a', 0);
     nfa.Gecis(0, 'b', 0);
     nfa.Gecis(0, 'a', 1);
     nfa.Gecis(0, 'b', 2);
     
     nfa.Gecis(1, 'a', 1);
     nfa.Gecis(1, 'b', 1);
     nfa.Gecis(1, 'a', 4);
     nfa.Gecis(1, 'b', 6);
     
     nfa.Gecis(2, 'a', 2);
     nfa.Gecis(2, 'b', 2);
     nfa.Gecis(2, 'a', 6);
     nfa.Gecis(2, 'b', 5);
     
     nfa.Gecis(4, 'a', 4);
     nfa.Gecis(4, 'b', 4);
     nfa.Gecis(4, 'b', 7);
     
     nfa.Gecis(5, 'a', 5);
     nfa.Gecis(5, 'b', 5);
     nfa.Gecis(5, 'a', 10);
     
     nfa.Gecis(6, 'a', 6);
     nfa.Gecis(6, 'b', 6);
     nfa.Gecis(6, 'a', 7);
     nfa.Gecis(6, 'b', 10);
     
     nfa.Gecis(7, 'a', 7);
     nfa.Gecis(7, 'b', 7);
     nfa.Gecis(7, 'b', 8);
     
     nfa.Gecis(8, 'a', 8);
     nfa.Gecis(8, 'b', 8);
     
     nfa.Gecis(10, 'a', 10);
     nfa.Gecis(10, 'b', 10);
     nfa.Gecis(10, 'a', 8);

     nfa.yazdir();
     System.out.println();
     
     
     String Dizge;
     while (true) {
         System.out.print("NFA için kontrol edilecek{a,b} alfabede tanımlı dizge: ");
         Dizge = scanner.nextLine();

        
         if (Dizge.matches("[ab]*")) {
             break; 
         } else {
             System.out.println("Hata: Sadece 'a' ve 'b' karakterlerini içeren bir dizge giriniz.");
         }
     }
       
     System.out.println();
     nfa.Kontrol(Dizge); 
     System.out.println();

     DFA dfa = new DFA();

     Set<Integer> baslangicDurum0 = new HashSet<>();
     baslangicDurum0.add(0);

     Set<Integer> hedefDurum1 = new HashSet<>();
     hedefDurum1.add(1);

     Set<Integer> hedefDurum2 = new HashSet<>();
     hedefDurum2.add(2);

     Set<Integer> hedefDurum3 = new HashSet<>();
     hedefDurum3.add(3);

     Set<Integer> hedefDurum4 = new HashSet<>();
     hedefDurum4.add(4);
     
     Set<Integer> hedefDurum5 = new HashSet<>();
     hedefDurum5.add(5);

     Set<Integer> hedefDurum6 = new HashSet<>();
     hedefDurum6.add(6);
     
     Set<Integer> hedefDurum7 = new HashSet<>();
     hedefDurum7.add(7);

     Set<Integer> hedefDurum8 = new HashSet<>();
     hedefDurum8.add(8);

     
     dfa.Gecis(baslangicDurum0, 'a', hedefDurum2);
     dfa.Gecis(baslangicDurum0, 'b', hedefDurum1);
     
     dfa.Gecis(hedefDurum1, 'a', hedefDurum4);
     dfa.Gecis(hedefDurum1, 'b', hedefDurum3);
     
     dfa.Gecis(hedefDurum2, 'a', hedefDurum5);
     dfa.Gecis(hedefDurum2, 'b', hedefDurum4);
     
     dfa.Gecis(hedefDurum3, 'a', hedefDurum6);
     dfa.Gecis(hedefDurum3, 'b', hedefDurum3);
     
     dfa.Gecis(hedefDurum4, 'a', hedefDurum7);
     dfa.Gecis(hedefDurum4, 'b', hedefDurum6);
     
     dfa.Gecis(hedefDurum5, 'a', hedefDurum5);
     dfa.Gecis(hedefDurum5, 'b', hedefDurum7);
     
     dfa.Gecis(hedefDurum6, 'a', hedefDurum8);
     dfa.Gecis(hedefDurum6, 'b', hedefDurum6);
     
     dfa.Gecis(hedefDurum7, 'a', hedefDurum7);
     dfa.Gecis(hedefDurum7, 'b', hedefDurum8);
     
     dfa.Gecis(hedefDurum8, 'a', hedefDurum8);
     dfa.Gecis(hedefDurum8, 'b', hedefDurum8);

     
     Set<Integer> kabulDurumu= new HashSet<>();
     kabulDurumu.add(8);
     dfa.Kabul(kabulDurumu);
     dfa.yazdir();
     System.out.println();
     System.out.println("Aynı dizgeyi DFA'da kontrol edelim:");
     System.out.println();
     dfa.Kontrol(Dizge);

 }
}
