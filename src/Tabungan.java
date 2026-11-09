public class Tabungan extends Rekening implements BerBunga {

    // Persentase bunga tabungan
    private double bungaPersen;

    // Constructor tabungan
    public Tabungan(String nomor, String pemilik,
                    int saldo, double bungaPersen) {

        super(nomor, pemilik, saldo);

        this.bungaPersen = bungaPersen;
    }

    // Menghitung biaya admin bulanan
    @Override
    public int biayaAdminBulanan() {

        // Jika saldo minimal Rp1.000.000, admin gratis
        if (saldo >= 1_000_000) {
            return 0;
        }

        // Jika kurang dari Rp1.000.000, admin Rp5.000
        return 5_000;
    }

    // Menghitung dan menambahkan bunga tabungan
    @Override
    public int tambahBunga() {

        // Bunga dihitung dari saldo setelah dipotong admin
        int bunga = (int) (saldo * bungaPersen / 100);

        // Bunga ditambahkan ke saldo
        saldo += bunga;

        // Mengembalikan jumlah bunga yang didapat
        return bunga;
    }
}