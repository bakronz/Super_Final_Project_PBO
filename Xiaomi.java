package project_akhir;

public class Xiaomi extends Smartphone {

    public Xiaomi(int storage) {
        super("Xiaomi", storage);
    }

    @Override
    protected int setHarga() {
        if (storage == 64) return 2500000;
        if (storage == 128) return 2800000;
        return 3200000;
    }
}
