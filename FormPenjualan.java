package project_akhir;

import javax.swing.*;

public class FormPenjualan extends JFrame {

    JComboBox<String> cbMerk, cbStorage;
    JTextField txtJumlah;
    JLabel lblHarga, lblStok, lblTotal;

    Smartphone hp;

    public FormPenjualan() {
        setTitle("Penjualan Smartphone");
        setSize(420, 350);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Merk");
        l1.setBounds(30, 30, 100, 25);
        add(l1);

        cbMerk = new JComboBox<>(new String[]{"Xiaomi","Samsung","iPhone","Oppo","Vivo"});
        cbMerk.setBounds(150,30,200,25);
        add(cbMerk);

        JLabel l2 = new JLabel("Penyimpanan");
        l2.setBounds(30,70,100,25);
        add(l2);

        cbStorage = new JComboBox<>(new String[]{"64","128","256"});
        cbStorage.setBounds(150,70,200,25);
        add(cbStorage);

        JLabel l3 = new JLabel("Jumlah");
        l3.setBounds(30,110,100,25);
        add(l3);

        txtJumlah = new JTextField();
        txtJumlah.setBounds(150,110,200,25);
        add(txtJumlah);

        JButton btn = new JButton("Hitung Total");
        btn.setBounds(150,150,200,30);
        add(btn);

        lblHarga = new JLabel("Harga Satuan: -");
        lblHarga.setBounds(30,200,300,25);
        add(lblHarga);

        lblStok = new JLabel("Stok Tersisa: 50");
        lblStok.setBounds(30,230,300,25);
        add(lblStok);

        lblTotal = new JLabel("Total: Rp 0");
        lblTotal.setBounds(30,260,300,25);
        add(lblTotal);

        // 🔥 EVENT AUTO UPDATE HARGA
        cbMerk.addActionListener(e -> updateHarga());
        cbStorage.addActionListener(e -> updateHarga());

        btn.addActionListener(e -> proses());

        // tampilkan harga awal
        updateHarga();
    }

    // ✅ METHOD BARU: UPDATE HARGA LANGSUNG
    void updateHarga() {
        int storage = Integer.parseInt(cbStorage.getSelectedItem().toString());
        String merk = cbMerk.getSelectedItem().toString();

        switch (merk) {
            case "Xiaomi": hp = new Xiaomi(storage); break;
            case "Samsung": hp = new Samsung(storage); break;
            case "iPhone": hp = new Iphone(storage); break;
            case "Oppo": hp = new Oppo(storage); break;
            default: hp = new Vivo(storage);
        }

        lblHarga.setText("Harga Satuan: Rp " + hp.getHarga());
        lblStok.setText("Stok Tersisa: " + hp.getStok());
    }

    void proses() {
        int jumlah = Integer.parseInt(txtJumlah.getText());

        if (!hp.cekStok(jumlah)) {
            JOptionPane.showMessageDialog(this, "Stok tidak cukup!");
            return;
        }

        int total = hp.hitungTotal(jumlah);
        hp.kurangiStok(jumlah);

        lblTotal.setText("Total: Rp " + total);
        lblStok.setText("Stok Tersisa: " + hp.getStok());

        JOptionPane.showMessageDialog(this, "Pembelian berhasil!");
    }
}
