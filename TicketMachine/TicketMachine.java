
/**
 * Write a description of class TicketMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketMachine
{
    // Harga Tiket
    private int price;
    // Jumlah Uang Yang Dimasukkan Pelanggan
    private int balance;
    // Total Uang Di Mesin
    private int total;
    
    /**
     * Bikin Mesin Cetak Tiket Dengan Harga Yang Ditentukan
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }
    
    /**
     * Return Harga Tiket
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Return Jumlah Uang Untuk Tiket Selanjutnya
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**
     * Cek Jumlah Uang Yang Diinput Costumer Dalam Sen.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Tolong Masukkan Jumlah Lebih Besar Dibanding: "
             + amount);
        }
    }
    
    /**
     * Jika Uang Yang Dimasukkan Udah Cukup -> Print Tiket
     * Lalu kurangi balance dengan harga tiket
     * Kalo kurang -> Print Error
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Print Tiket
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            
            //Update Mesin
            total += price;
            balance -= price;
        } else {
            System.out.println("Uangmu Harus Minimal: " + (price - balance) + " cents.");
        }
    }
    
    /**
     * Balikan Uang Kembalian
     */
    public int refundBalance()
    {
        int amount;
        amount = balance;
        balance = 0;
        return amount;
    }
}