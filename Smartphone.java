package project_akhir;

public abstract class Smartphone {
    protected String merk;
    protected int storage;
    protected int harga;
    protected int stok = 50;

    public Smartphone(String merk, int storage) {
        this.merk = merk;
        this.storage = storage;
        this.harga = setHarga();
    }

    protected abstract int setHarga();

    public int hitungTotal(int jumlah) {
        return harga * jumlah;
    }

    public boolean cekStok(int jumlah) {
        return stok >= jumlah;
    }

    public void kurangiStok(int jumlah) {
        stok -= jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }
}
