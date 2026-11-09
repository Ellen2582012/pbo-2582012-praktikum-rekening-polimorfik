// Abstract class Rekening
public abstract class Rekening {

    // Atribut untuk menyimpan data rekening
    private String nomor;
    private String pemilik;
    private int saldo;

    // Constructor untuk mengisi data rekening
    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Mengambil nomor rekening
    public String getNomor() {
        return nomor;
    }

    // Mengambil nama pemilik rekening
    public String getPemilik() {
        return pemilik;
    }

    // Mengambil saldo rekening
    public int getSaldo() {
        return saldo;
    }

    // Mengubah saldo, digunakan oleh class turunannya
    protected void setSaldo(int saldoBaru) {
        this.saldo = saldoBaru;
    }

    // Method untuk melakukan penyetoran uang
    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }

        saldo += jumlah;
        return true;
    }

    // Method untuk melakukan penarikan uang
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }

        saldo -= jumlah;
        return true;
    }

    // Method abstract untuk menentukan biaya administrasi
    public abstract int biayaAdminBulanan();

    // Method untuk memotong biaya administrasi
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();

        saldo -= biaya;

        return biaya;
    }

    // Method untuk mengubah format angka menjadi rupiah
    public static String formatRupiah(int nominal) {
        return String.format("%,d", nominal).replace(',', '.');
    }

    // Menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println(
                nomor + " | " + pemilik + " | Rp" + formatRupiah(saldo)
        );
    }
}