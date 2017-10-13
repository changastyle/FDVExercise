package model;

import Controlador.MasterController;
import java.util.Date;

public class Rental
{
    private Date start;
    private Date finish;

    public Rental(Date start, Date finish)
    {
        this.start = start;
        this.finish = finish;
    }

    public double getPrice()
    {
        long result = 0;
        long week = 7 * 24 * 60 * 60;
        long day = 1 * 24 * 60 * 60;
        long hour = 1 * 60 * 60;
        
        long diference = (finish.getTime() - start.getTime());
        diference = diference / 1000;
        
        if(diference > week )
        {
            long multiplier = diference / week;
            result = (long) MasterController.pricePerWeek * multiplier;
        }
        else if( diference > day )
        {
            long multiplier = diference / day;
            result = (long) (MasterController.pricePerDay * multiplier);
        }
        else if (diference > hour)
        {
            long multiplier = diference / hour;
            result = (long) (MasterController.pricePerDay * multiplier);
        }
        return result;
    }
     
    //<editor-fold desc="GYS:">

    public Date getStart()
    {
        return start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getFinish()
    {
        return finish;
    }

    public void setFinish(Date finish)
    {
        this.finish = finish;
    }
    //</editor-fold>

    @Override
    public String toString()
    {
        return "Rental{" + "start=" + start + ", finish=" + finish + '}';
    }
    
    
}