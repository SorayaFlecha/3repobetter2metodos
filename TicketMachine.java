/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    private int descuento;
    
    private boolean makinaDescuento;
    

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, int porcenDiscount, boolean makiBilleDescu)
    {
        price = cost;
        descuento = (price - (price * porcenDiscount) / 100);
        makinaDescuento = makiBilleDescu;
        balance = 0;
        total = 0;
    }
  
    
    /**
     * Metodo que imprime un billete con un 10% de descuento.
     */
    public void getPrinTiketDiscount()
    {
        if (makinaDescuento == true)
        {
        if(balance >= price - descuento)
        
        {
            int newPrice = price - descuento;
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + newPrice + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total =  (price - descuento) + total;
            // Reduce the balance by the prince.
            balance = balance - (price - descuento);
        }
        else 
        {
            int amounLeftToplay = (price - descuento) - balance;
            System.out.println("You must insert at least: " +
                               (amounLeftToplay) + " more cents.");
                    
        }
    }
    else
    {
      System.out.println("Esta maquina no puede imprimir tikets con descuento");  
    }
    }
    
    
    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else 
        {
            int amounLeftToplay = price - balance;
            System.out.println("You must insert at least: " +
                               (amounLeftToplay) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
   
    
    /**
     *Metodo que nos dice el dinero que nos falta 
     * para imprimir un tiket con descuento.
     */
    public int getDineroFaltante()
    {
        int amountLeftToPlay;
        amountLeftToPlay = price - balance;
        return amountLeftToPlay;
    }
    
    /**
     * Metodo que nos da las monedas que habia
     * en la maquina y nos pone el valor a 0.
     */
    public int empyMachine()
    {
        int machineTotalMoney;
        machineTotalMoney = total;
        total = 0;
        return machineTotalMoney;
    }
    
    
}
