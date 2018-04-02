package view.java;

import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sample1
{
    public Sample1()
    {
        super();
    }


    static
    {
        a=20;
     //   System.err.println(a);
    }
    static int a=10;

    // Obtain a suitable logger.
    private static Logger logger = Logger.getLogger( "view.java" );

    public static void main( String argv[] )
    {
        System.err.println("insdie e ekjlk");
        // Log a FINE tracing message
        logger.fine( "doing stuff" );
        try
        {
            Handler fh = new FileHandler( "/home/prateeks/Log" );
            Logger.getLogger( "" ).addHandler( fh );

        }
        catch( IOException e )
        {
        }

        try
        {
            //
        }
        catch( Exception ex )
        {
            // Log the exception
            logger.log( Level.WARNING, "trouble sneezing", ex );
        }
        logger.fine( "done" );
    }


}
