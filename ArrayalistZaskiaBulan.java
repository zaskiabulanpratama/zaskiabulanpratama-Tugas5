package Pertemuan_5;

import java.util.*;

class Buah {
    String nama;
    int harga;

    Buah(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    int getHarga(int jumlah) {
        return this.harga;
    }
}

class ItemBelanja {
    Buah buah;
    int jumlah;

    ItemBelanja(Buah buah, int jumlah) {
        this.buah = buah;
        this.jumlah = jumlah;
    }

    int getSubtotal() {
        return buah.getHarga(jumlah) * jumlah;
    }

    int getHargaPerItem() {
        return buah.getHarga(jumlah);
    }
}

public class ArrayalistZaskiaBulan {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Buah> daftarBuah = new ArrayList<>();

        daftarBuah.add(new Buah("Apel", 35000));
        daftarBuah.add(new Buah("Jeruk", 50000));
        daftarBuah.add(new Buah("Mangga", 25000));
        daftarBuah.add(new Buah("Duku", 15000));
        daftarBuah.add(new Buah("Semangka", 20000));

        ArrayList<ItemBelanja> keranjang = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Lihat Struk");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                String lanjut;
                do {
                    // Menampilkan daftar buah menggunakan ArrayList
                    System.out.println("Pilih Buah (1-5):");
                    for (int i = 0; i < daftarBuah.size(); i++) {
                        System.out.printf("%-3d %-10s Rp%-10d\n", i + 1, daftarBuah.get(i).nama, daftarBuah.get(i).harga);
                    }

                    System.out.print("Masukkan pilihan buah: ");
                    int pilihanBuah = scanner.nextInt();
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();

                    keranjang.add(new ItemBelanja(daftarBuah.get(pilihanBuah - 1), jumlah));

                    System.out.print("Input lagi? (y/n): ");
                    lanjut = scanner.next();
                } while (lanjut.equalsIgnoreCase("y"));

            } else if (pilihan == 2) {
                if (keranjang.isEmpty()) {
                    System.out.println("Keranjang belanja Anda kosong.");
                } else {
                    System.out.println("Daftar Belanja Anda:");
                    System.out.println("=".repeat(50));
                    System.out.printf("%-3s %-10s %-7s %-10s %-10s\n", "No", "Nama Buah", "Jumlah", "Harga", "Subtotal");

                    int totalHarga = 0;
                    for (int i = 0; i < keranjang.size(); i++) {
                        ItemBelanja item = keranjang.get(i);
                        int hargaPerItem = item.getHargaPerItem();
                        int subtotal = item.getSubtotal();
                        System.out.printf("%-3d %-10s %-7d Rp.%-7d Rp.%-10d\n", (i + 1), item.buah.nama, item.jumlah, hargaPerItem, subtotal);
                        totalHarga += subtotal;
                    }

                    System.out.println("=".repeat(50));
                    System.out.printf("Total harga\t: Rp.%d\n", totalHarga);

                    int diskon = totalHarga * 15 / 100;
                    int totalBayar = totalHarga - diskon;
                    System.out.printf("Diskon (15%%)\t: Rp.%d\n", diskon);
                    System.out.printf("Total bayar\t: Rp.%d\n", totalBayar);
                    System.out.println("-".repeat(50));
                }
            } else if (pilihan != 3) {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);

        System.out.println("Terima kasih sudah berbelanja!");
        scanner.close();
    }
}