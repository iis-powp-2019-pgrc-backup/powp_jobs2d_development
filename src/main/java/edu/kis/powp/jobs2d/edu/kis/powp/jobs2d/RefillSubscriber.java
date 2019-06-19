package edu.kis.powp.jobs2d.edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.logger.UsageLogger;
import edu.kis.powp.observer.Subscriber;

import javax.swing.*;

public class RefillSubscriber implements Subscriber {

    UsageLogger usageLogger;

    public RefillSubscriber( UsageLogger usageLogger ){
        this.usageLogger = usageLogger;
    }

    public void update(){
        if( usageLogger.getTotalUsage() > usageLogger.getInkLimit() ){
            JFrame f;
            f=new JFrame();
            JOptionPane.showMessageDialog(f,"Tusz wyczerpany :( Czy chcesz uzupełnić?");

            usageLogger.setTotalUsage( 0 );
            usageLogger.setEmpty( false );
        }
    }

}
