package view.java.jol;

import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaLog
{
    public JavaLog()
    {
        super();
    }

    private static Logger _alogger = Logger.getLogger( JavaLog.class.getName() );

    public static void main( String[] args )
    {
        JavaLog log= new JavaLog();
        log.onLoginDo();

    }

    public void onLoginDo()
    {
        Filter filter = _alogger.getFilter();
        Logger global = _alogger.getGlobal();
        Handler[] handler = _alogger.getHandlers();
        Level level = _alogger.getLevel();
        String name = _alogger.getName();
        Logger logger = _alogger.getParent();
        System.err.println("parent logger is " +logger.getName());
        System.err.println(logger.getAnonymousLogger());
//        _alogger.info( "filter  "+filter  +"  " +global +"  handler  " + handler  +"  level " +level  +"  name "+name +"  logger  "+logger);
        _alogger.info( warning() );
    }


    private String warning()
    {
        return "This is not going to happen dude!";
    }

}
