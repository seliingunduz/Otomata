# Otomata
# NFA ve DFA ile Dizge Kontrolü

Bu Java programı, belirli bir dil için NFA (Nondeterministic Finite Automaton) ve DFA (Deterministic Finite Automaton) tanımlarını kullanarak kullanıcıdan alınan bir dizgenin geçerliliğini kontrol eder. Ayrıca, girilen dizgenin her bir adımında hangi durumda olduğu da adım adım gösterilir.

## Özellikler

- Kullanıcıdan bir dizge alır ve yalnızca `a` ve `b` harflerini içermesini kontrol eder.
- NFA ve DFA'yı tanımlar ve geçişlerini oluşturur.
- Kullanıcının girdiği dizgenin NFA tarafından kabul edilip edilmediğini kontrol eder.
- Aynı dizgenin DFA tarafından kabul edilip edilmediğini kontrol eder.
- Her bir sembol okunduğunda hangi durumda olduğu adım adım gösterilir.
- `a` ve `b` harfleri dışında bir karakter girilirse, hata mesajı verir ve yeniden giriş ister.

## Gereksinimler

- Java 8 veya daha yeni bir sürüm

## Kullanım

1. **Kaynak Kodu Çalıştırma**
   - Programı bir Java IDE'sinde (IntelliJ IDEA, Eclipse, vb.) açın veya terminalde çalıştırın.
   - `DilCNfa_SelinGunduz22010310037` sınıfını çalıştırın.

2. **Girdi**
   - Program çalıştırıldığında sizden bir dizge girmeniz istenecektir.
   - Girilen dizge yalnızca `a` ve `b` harflerini içermelidir.
   - Geçersiz bir karakter girilirse, hata mesajı alınır ve tekrar giriş yapmanız istenir.

3. **Çıktı**
   - NFA tanımı ve geçişleri yazdırılır.
   - Kullanıcının girdiği dizgenin NFA tarafından kabul edilip edilmediği belirtilir.
   - Aynı dizgenin DFA tarafından kabul edilip edilmediği belirtilir.
   - Dizge üzerindeki her bir sembolün işlendiği durumlar detaylı şekilde gösterilir.
  
# NFA ve DFA ile Dizge Kontrolü - Örnek Girdiler ve Çıktılar

Bu bölümde program için test edilen örnek dizgelerin çıktıları adım adım gösterilmektedir.
## **Girdi 1: `aab`**
### Çıktı: NFA için kontrol edilecek dizge: aab 
-Sembol: a, Şimdiki durumlar: {0}
-Sembol: a, Şimdiki durumlar: {0, 1} 
-Sembol: b, Şimdiki durumlar: {0, 1, 2} 
-NFA sonucu: Kabul edilmedi.

DFA geçiş tablosu: ... 
Aynı dizgeyi DFA'da kontrol edelim:
Sembol: a, Şimdiki durum: {0} 
Sembol: a, Şimdiki durum: {2} 
Sembol: b, Şimdiki durum: {4} DFA sonucu: Kabul edilmedi.

## **Girdi 1: `ababab`**
### Çıktı: NFA için kontrol edilecek dizge: ababab
Sembol: a, Şimdiki durumlar: {0} 
Sembol: b, Şimdiki durumlar: {0, 2} 
Sembol: a, Şimdiki durumlar: {0, 1, 6} 
Sembol: b, Şimdiki durumlar: {0, 2, 6, 10} 
Sembol: a, Şimdiki durumlar: {0, 1, 6, 7, 8} 
Sembol: b, Şimdiki durumlar: {0, 2, 6, 8, 10} NFA sonucu: Kabul edildi.

DFA geçiş tablosu: ... 
Aynı dizgeyi DFA'da kontrol edelim: 
Sembol: a, Şimdiki durum: {0} 
Sembol: b, Şimdiki durum: {1} 
Sembol: a, Şimdiki durum: {4} 
Sembol: b, Şimdiki durum: {6} 
Sembol: a, Şimdiki durum: {7} 
Sembol: b, Şimdiki durum: {8} DFA sonucu: Kabul edildi.

## **Girdi 1: `abc`**
### Çıktı: NFA için kontrol edilecek dizge: abc 
NFA için kontrol edilecek dizge: abc Hata: Sadece 'a' ve 'b' karakterlerini içeren bir dizge giriniz.

## **Özet**
- **`aab`**: Kabul edilmedi (NFA ve DFA).
- **`ababab`**: Kabul edildi (NFA ve DFA).
- **`abc`**: Hata mesajı verildi (geçersiz karakter `c`).
- **`aaaabbbbabab`**: Kabul edildi (NFA ve DFA).
