package view.java.jol;

import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class ChildLogClass extends JavaLog
{
    public ChildLogClass()
    {
        super();
    }

    private static Logger _alogger = Logger.getLogger( ChildLogClass.class.getName() );

    public static void main( String[] args )
    {
        ChildLogClass log = new ChildLogClass();
        //        log.createAndAddFileHandler();
        //        log.setLogLevel();
        //        log.logWarning();
        //        log.logFinner();
        log.printDefaultLoggingInfo();
        //        log.printLoggingInfo();
        //                log.printHandlersInfo();
        //        log.getGlobalHandler();

    }

    private void logWarning()
    {
        _alogger.warning( "logging warning message" );
    }

    private void logFinner()
    {
        _alogger.finer( "logging warning message" );
    }

    /**
     * This method will print default logging info
     */
    private void printDefaultLoggingInfo()
    {
        _alogger.warning( "printing logger object name " + _alogger.getName() );
        _alogger.warning( "printing parent logger object name " + _alogger.getParent() );
        _alogger.warning( "printing number of default handlers " + _alogger.getHandlers().length );
        _alogger.warning( "printing global class " + _alogger.getGlobal() );
        _alogger.warning( "printing filter class " + _alogger.getFilter() );
        _alogger.warning( "printing level class " + _alogger.getLevel() );
    }

    private void removeGlobalLog()
    {

    }

    private void printHandlersInfo()
    {
        Handler[] handler = _alogger.getHandlers();
        System.err.println( handler.length );
        Stream.of( handler ).forEach( ( Handler hr ) -> { _alogger.warning( "encoding is " //
                + hr.getEncoding() + " error mesage " + //
                hr.getErrorManager() + " filter is " + hr.getFilter() + " formatter is  " + hr.getFormatter() //
            ); } );

    }

    private void getGlobalHandler()
    {
        LogManager.getLogManager().reset();
        System.err.println( Logger.GLOBAL_LOGGER_NAME );
        Logger globalLogger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
        System.err.println( globalLogger.getHandlers().length );
        System.err.println( Logger.getGlobal() );
        Stream.of( globalLogger.getHandlers() ).forEach( ( Handler hr ) -> { _alogger.warning( "encoding is " //
                + hr.getEncoding() + " error mesage " + //
                hr.getErrorManager() + " filter is " + hr.getFilter() + " formatter is  " + hr.getFormatter() //
            ); } );
    }

    private void createAndAddFileHandler()
    {
        try
        {
            Handler fh = new FileHandler( "test.txt" );
            _alogger.addHandler( fh );
        }
        catch( IOException e )
        {
            e.printStackTrace();
            _alogger.warning( e.toString() );
        }
    }

    private void setLogLevel()
    {
        _alogger.setLevel( Level.FINER );
    }
}
