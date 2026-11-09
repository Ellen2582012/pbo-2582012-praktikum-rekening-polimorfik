public class Giro extends Rekening {

    // Batas saldo negatif yang diperbolehkan
    private int batasOverdraft;

    // Constructor untuk rekening Giro
    public Giro(String nomor, String pemilik,
                int saldo, int batasOverdraft) {

        super(nomor, pemilik, saldo);

        this.batasOverdraft = batasOverdraft;
    }

    // Biaya admin Giro selalu Rp15.000
    @Override
    public int biayaAdminBulanan() {
        return 15_000;
    }

    // Mengubah aturan penarikan uang khusus Giro
    @Override
    public boolean tarik(int jumlah) {

        // Penarikan boleh sampai batas overdraft
        if (jumlah > 0 &&
                saldo - jumlah >= -batasOverdraft) {

            saldo -= jumlah;
            return true;
        }

        // Penarikan ditolak jika melewati batas overdraft
        return false;
    }

    // Mengambil informasi batas overdraft
    public int getBatasOverdraft() {
        return batasOverdraft;
    }
}