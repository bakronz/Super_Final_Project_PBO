
package project_akhir;

public class Oppo extends Smartphone {

    public Oppo(int storage) {
        super("Oppo", storage);
    }

    @Override
    protected int setHarga() {
        if (storage == 64) return 2800000;
        if (storage == 128) return 3300000;
        return 3800000;
    }
}
