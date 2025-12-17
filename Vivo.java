package project_akhir;

public class Vivo extends Smartphone {

    public Vivo(int storage) {
        super("Vivo", storage);
    }

    @Override
    protected int setHarga() {
        if (storage == 64) return 2600000;
        if (storage == 128) return 3000000;
        return 3500000;
    }
}
