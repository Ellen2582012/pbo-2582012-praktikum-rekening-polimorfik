import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class BankPolimorfik {

    public static void main(String[] args) {

        // Mengatur format angka dengan pemisah ribuan titik
        DecimalFormatSymbols simbol =
                new DecimalFormatSymbols(new Locale("id", "ID"));

        simbol.setGroupingSeparator('.');

        DecimalFormat format =
                new DecimalFormat("#,##0", simbol);

        // Membuat tiga objek rekening
        Tabungan ani = new Tabungan(
                "101", "Ani", 1_000_000, 2.5
        );

        Tabungan citra = new Tabungan(
                "102", "Citra", 300_000, 2.0
        );

        Giro budi = new Giro(
                "201", "Budi", 200_000, 500_000
        );

        // Semua rekening dimasukkan ke satu array Rekening
        Rekening[] semua = {ani, citra, budi};

        // Hanya rekening yang mendapatkan bunga
        // yang dimasukkan ke array BerBunga
        BerBunga[] berbunga = {ani, citra};

        // Keterangan masing-masing rekening
        String[] keterangan = {
                "Tabungan, bunga 2.5% per bulan",
                "Tabungan, bunga 2.0% per bulan",
                "Giro, batas overdraft Rp500.000"
        };

        // Menampilkan rekening awal
        System.out.println("========== REKENING AWAL ==========");

        for (int i = 0; i < semua.length; i++) {

            Rekening r = semua[i];

            System.out.println(
                    r.getNomor() + " | " +
                            r.getPemilik() + " | Rp" +
                            format.format(r.getSaldo())
            );

            System.out.println("    " + keterangan[i]);
        }

        // Memotong biaya admin semua rekening
        System.out.println("\n========== AKHIR BULAN ==========");

        for (Rekening r : semua) {

            // Setiap rekening menggunakan aturan admin miliknya
            int biaya = r.potongBiayaAdmin();

            System.out.println(
                    r.getNomor() +
                            " biaya admin : Rp" +
                            format.format(biaya)
            );
        }

        // Menambahkan bunga hanya untuk rekening berbunga
        for (BerBunga b : berbunga) {

            int bunga = b.tambahBunga();

            System.out.println(
                    b.getNomor() +
                            " bunga       : Rp" +
                            format.format(bunga)
            );
        }

        // Menampilkan rekening setelah diproses
        System.out.println("\n========== REKENING AKHIR ==========");

        int totalDana = 0;

        for (int i = 0; i < semua.length; i++) {

            Rekening r = semua[i];

            System.out.println(
                    r.getNomor() + " | " +
                            r.getPemilik() + " | Rp" +
                            format.format(r.getSaldo())
            );

            System.out.println("    " + keterangan[i]);

            // Menghitung seluruh saldo rekening
            totalDana += r.getSaldo();
        }

        // Menampilkan total dana bank
        System.out.println("-----------------------------------");

        System.out.println(
                "Total dana bank : Rp" +
                        format.format(totalDana)
        );

        /*
         * Pengujian abstract class sesuai ketentuan nomor 8:
         *
         * Rekening r = new Rekening("999", "Eko", 0);
         *
         * Error:
         * Rekening is abstract; cannot be instantiated
         *
         * Baris tersebut sengaja dijadikan komentar
         * karena Rekening merupakan abstract class.
         */
    }
}