package view.java.jol;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This is first call to understand java logger.
 * This is very basic and starting point
 */
public class JavaLogFirst
{
    public JavaLogFirst()
    {
        super();
    }

    private static Logger _alogger = Logger.getLogger( JavaLogFirst.class.getName() );


    public static void main( String[] args )
    {
        JavaLogFirst log = new JavaLogFirst();
        log.printDefaultLoggingInfo();
        log.noPrintDefaultLoggingInfo();
    }

    /**
     * This method will print default logging info.
     * Logger name                  --> whatever we passed inside get logger will return this.
     * Parent logger name           --> It is returning instance of java.util.logging.LogManager$RootLogger
     * Default handlers count       --> 0
     * Global logger                --> instance of java.util.logging.Logger
     * Filter Object                --> null
     * Log level                    --> null
     * Since default lagger level is null therefore it is printing only warning , info and severe logs
     * Its printed below messages on console
     * Apr 03, 2018 7:17:53 AM view.java.jol.JavaLogOne printDefaultLoggingInfo
     * WARNING: Printing logger object name view.java.jol.JavaLogOne
     * Apr 03, 2018 7:17:53 AM view.java.jol.JavaLogOne printDefaultLoggingInfo
     * INFO: Printing parent logger object name java.util.logging.LogManager$RootLogger@5c18298f
     * Apr 03, 2018 7:17:53 AM view.java.jol.JavaLogOne printDefaultLoggingInfo
     * SEVERE: Printing level class null
     */
    private void printDefaultLoggingInfo()
    {
        _alogger.warning( "Printing logger object name " + _alogger.getName() );
        _alogger.info( "Printing parent logger object name " + _alogger.getParent() );
        _alogger.severe( "Printing level class " + _alogger.getLevel() );

    }

    /**
     * Since default log level is INFO therefore it will not print below log message
     */
    private void noPrintDefaultLoggingInfo()
    {
        _alogger.fine( "Printing number of default handlers " + _alogger.getHandlers().length );
        _alogger.finer( "Printing global class " + _alogger.getGlobal() );
        _alogger.finest( "Printing filter class " + _alogger.getFilter() );
        _alogger.config( "Printing resource bundle name " + _alogger.getResourceBundleName() );
    }

    private void logWarning()
    {
        _alogger.warning( "logging warning message" );
    }

    private void logFinner()
    {
        _alogger.finer( "logging warning message" );
    }

    private void setLogLevel()
    {
        _alogger.setLevel( Level.ALL );
    }

}
