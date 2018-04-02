package view.login.beans;

import java.io.IOException;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.logging.ADFLogger;

import weblogic.security.SimpleCallbackHandler;
import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;


public class LoginBb
{

    private static ADFLogger _adflogger = ADFLogger.createADFLogger( LoginBb.class );
    private static Logger _alogger =  Logger.getLogger("testing" );


    private String _userName;
    private String _password;

    public void setUserName( String userName )
    {
        this._userName = userName;
    }

    public String getUserName()
    {
        return _userName;
    }

    public void setPassword( String password )
    {
        this._password = password;
    }

    public String getPassword()
    {
        return _password;
    }

    public LoginBb()
    {
        super();
    }

    public void onLoginDo( ActionEvent actionEvent )
    {
        _alogger.warning( warning() );
        //doLogin( actionEvent );

    }

    public static void main( String[] args )
    {
         LoginBb bb=new LoginBb();
         bb.onLoginDo( null );
     }

    private String warning()
    {
        System.err.println( "i am going to print dude !" );
//        System.err.println(_adflogger.getLevel());
        return "This is not going to happen dude!";
    }


    public void doLogin( ActionEvent event )
    {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpServletRequest request = ( HttpServletRequest ) ectx.getRequest();
        CallbackHandler handler = new SimpleCallbackHandler( this.getUserName(), this.getPassword().getBytes() );
        Subject sub;
        try
        {
            sub = Authentication.login( handler );
            ServletAuthentication.runAs( sub, request );
            ServletAuthentication.generateNewSessionID( request );
            String successUrl = "/adfAuthentication?success_url=/faces/LoginSuccessfull.jsf";
            HttpServletResponse response = ( HttpServletResponse ) fctx.getExternalContext().getResponse();
            RequestDispatcher dispatcher = request.getRequestDispatcher( successUrl );
            dispatcher.forward( request, response );
            fctx.responseComplete();
        }
        catch( FailedLoginException e )
        {
            FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Incorrect Username or Password", "An incorrect Username or Password" + " was specified" );
            fctx.addMessage( null, msg );
        }
        catch( LoginException e )
        {
            // reportUnexpectedLoginError("LoginException", e);
        }
        catch( IOException | ServletException e )
        {
        }
    }
}

