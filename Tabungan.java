import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Tabungan {
    private String noRek;
    private double saldo;
    private ArrayList<Transaksi> listTransaksi;
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
    String formattedDate = currentDate.format(formatter);
    public Tabungan(String noRek) {
        this.noRek = noRek;
        this.saldo = 0;
        listTransaksi = new ArrayList<>();
    }

    public String getNoRek() { return noRek; }
    public double getSaldo() { return saldo; }

    public void setor(double jumlah) {
        saldo += jumlah;
        listTransaksi.add(new TransaksiSetor(formattedDate, jumlah));
    }

    public void tarik(double jumlah) {
        if (saldo >= jumlah){
            saldo -= jumlah;
            listTransaksi.add(new TransaksiTarik(formattedDate, jumlah));
        } else { System.out.println("Saldo tidak mencukupi"); }
    }

    public void mutasiRekening() {
        System.out.println("Mutasi Rekening " + noRek + ":");
        for (Transaksi transaksi : listTransaksi){ System.out.println(transaksi); }
    }
}