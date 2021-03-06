package main;

import Controlador.MasterController;
import java.util.Date;
import model.Promo;
import model.Rental;

public class Main
{

    public static void main(String[] args)
    {
        Promo promo = new Promo();
        int dayStart = 13;
        
        for(int i = 1;  i < MasterController.rentalMax ; i++)
        {
        
            int dayFinish = dayStart + random(15);
            Date dia1 = new Date(2017 ,(9) , dayStart);
            Date dia2 = new Date(2017 ,(9), dayFinish);
            System.out.println("Rental" + i +" date start = " + dia1);
            System.out.println("Rental" + i +"  date finish = " + dia2);
        
            Rental rental = new Rental(dia1, dia2);
            promo.addRental(rental);
            System.out.println("Rental " + i + " total Price = " + rental.getPrice() + "\n");
            
            
        }
        
        
        System.out.println("PROMO TOTAL PRICE WITH DISCOUNT: " + promo.getPrice());
        
    }
    public static int random(int max)
    {
        return (int) ((Math.random() * max) + 1);
    }
    
}
