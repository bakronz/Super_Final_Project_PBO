package project_akhir;

public class Iphone extends Smartphone {

    public Iphone(int storage) {
        super("iPhone", storage);
    }

    @Override
    protected int setHarga() {
        if (storage == 64) return 9000000;
        if (storage == 128) return 12000000;
        return 15000000;
    }
}
