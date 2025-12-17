package project_akhir;

public class Samsung extends Smartphone {

    public Samsung(int storage) {
        super("Samsung", storage);
    }

    @Override
    protected int setHarga() {
        if (storage == 64) return 3000000;
        if (storage == 128) return 3500000;
        return 4000000;
    }
}
