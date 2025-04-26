import java.util.*;

public class CariDuplikatLengkap {

    public static <T> Set<T> cariDuplikat(List<T> list) {
        Set<T> elemen = new HashSet<>();
        Set<T> duplikat = new HashSet<>();

        for (T item : list) {
            if (!elemen.add(item)) {
                duplikat.add(item);
            }
        }
        return duplikat;
    }

    public static List<String> inputData(Scanner scanner) {
        List<String> list = new ArrayList<>();
        System.out.print("Berapa banyak elemen? ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Masukkan elemen satu per satu:");
        for (int i = 0; i < jumlah; i++) {
            System.out.print("Elemen ke-" + (i + 1) + ": ");
            String elemen = scanner.nextLine();
            list.add(elemen);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Pencari Elemen Ganda ===");
        System.out.println("Pilih tipe data:");
        System.out.println("1. Angka (Integer)");
        System.out.println("2. Teks (String)");
        System.out.print("Pilihan Anda (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List listInput = inputData(scanner);

        if (pilihan == 1) {
            List<Integer> listAngka = new ArrayList<>();
            try {
                for (Object obj : listInput) {
                    listAngka.add(Integer.parseInt(obj.toString()));
                }
                Set<Integer> duplikat = cariDuplikat(listAngka);

                System.out.println("\nData yang dimasukkan: " + listAngka);
                System.out.println("Elemen unik: " + new HashSet<>(listAngka));
                if (duplikat.isEmpty()) {
                    System.out.println("Tidak ditemukan elemen ganda.");
                } else {
                    System.out.println("Elemen ganda: " + duplikat);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Pastikan semua input berupa angka.");
            }
        } else if (pilihan == 2) {
            Set<String> duplikat = cariDuplikat(listInput);

            System.out.println("\nData yang dimasukkan: " + listInput);
            System.out.println("Elemen unik: " + new HashSet<>(listInput));
            if (duplikat.isEmpty()) {
                System.out.println("Tidak ditemukan elemen ganda.");
            } else {
                System.out.println("Elemen ganda: " + duplikat);
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}
