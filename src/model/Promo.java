package model;

import Controlador.MasterController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Promo
{
    List<Rental> rentalList;

    public Promo()
    {
        rentalList = new ArrayList<Rental>();
    }

    public Promo(Date timestamp, List<Rental> rentalList)
    {
        this.rentalList = rentalList;
        
    }
    //<editor-fold desc="GYS:">

    public List<Rental> getRentalList()
    {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList)
    {
        this.rentalList = rentalList;
    }
     //</editor-fold>

    @Override
    public String toString()
    {
        return "Promo{" + "rentalList=" + rentalList + '}';
    }

     
    
    //<editor-fold desc="DINAMIC METHODS:">
    public boolean addRental(Rental rentalRecibed)
    {
        boolean added = false;
        
        if(rentalList == null)
        {
            rentalList = new ArrayList<Rental>();
        }
        
        int rentalCount = rentalList.size() + 1;
        if( rentalCount < MasterController.rentalMax )
        {
            rentalList.add(rentalRecibed);
            added = true;
        }
        
        return added;
    }
    public boolean rmRental(Rental rentalToQuit)
    {
        boolean removed = false;
        
        if(rentalList != null)
        {
            int rentalCount = rentalList.size() + 1;
            if( rentalCount > MasterController.rentalMin )
            {
                rentalList.remove(rentalToQuit);
                removed = true;
            }
        }
        
        return removed;
    }
    
    public double getPrice()
    {
        double totalPrice = 0;
        
        if(rentalList != null)
        {
            System.out.println("rentalList.size = " + rentalList.size());
            for(Rental r : rentalList)
            {
                System.out.println("r:" + r.getPrice());
            }
            
            for(Rental rentalAux : rentalList)
            {
                totalPrice += rentalAux.getPrice();
            }
            
            double discount = (totalPrice * MasterController.discountPercentage ) / 100;
            System.out.println("price= " + totalPrice);
            System.out.println("dicount = "+  discount);
            
            int rentalSize = (rentalList.size() + 1);
            if( rentalSize >= MasterController.rentalMin  && rentalSize <= MasterController.rentalMax )
            {
                totalPrice = totalPrice - discount;
            }
        }
        
        return totalPrice;
    }
    //</editor-fold>
    
    
}
