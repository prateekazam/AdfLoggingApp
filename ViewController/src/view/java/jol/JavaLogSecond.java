package view.java.jol;

import java.util.Enumeration;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JavaLogSecond
{

    //    private static Logger _alogger = Logger.getLogger( JavaLogSecond.class.getName() );

    public JavaLogSecond()
    {
        super();
    }


    public static void main( String[] args )
    {
        JavaLogSecond log = new JavaLogSecond();
        log.printAllLogger();
    }

    // Root logger
    // Global logger
    // Anonymous logger
    // User created logger
    private void printAllLogger()
    {
        LogManager logManager = LogManager.getLogManager();
        Enumeration<String> enumeration = logManager.getLoggerNames();
        while( enumeration.hasMoreElements() )
        {
            final String loggerName = enumeration.nextElement();
            Logger logger = logManager.getLogger( loggerName );

            //            System.err.println( logger + " name >>" + loggerName + "<<" );
            //            System.err.println( "testing >> "+logger.getParent());
            System.err.println( Logger.getGlobal().getLevel() );
            if( logger.getParent() != null )
            {
                //                System.err.println(logger.getParent().getLevel());
            }
            logger.setUseParentHandlers( false );
            //            System.err.println();
            //            System.err.println(logger.getAnonymousLogger().getParent());
            //            _alogger.info( "Logger Names are " + logger.getName() + " log level " + logger.getLevel() );
            //            _alogger.info( "Number 0f handlers are  " + logger.getHandlers().length );
            if( logger.getHandlers().length > 0 )
            {
                Handler handle = logger.getHandlers()[0];
                //handle.setLevel( Level.FINEST );
                //                _alogger.finest( "log level " + handle.getLevel() );
            }
            //            _alogger.info( "Logger Names are " + loggerName );

            //            System.err.println( loggerName + "  logManager  " + logManager.getLogger( loggerName ).getHandlers().length );
        }
    }


}
