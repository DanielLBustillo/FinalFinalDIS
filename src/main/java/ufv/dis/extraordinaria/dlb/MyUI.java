package ufv.dis.extraordinaria.dlb;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
        Tweets t = new Tweets(); 
        
    	TextField nombre = new TextField("nombre");
    	TextField mensaje = new TextField("mensaje");
    	
    	Button button = new Button("Twittear");
    	
    	Grid<Tweet> tweetList = new Grid<>(Tweet.class);
    	tweetList.setItems(t.getTweets());
    	tweetList.setColumnOrder("nombre","mensaje");
    	tweetList.setSelectionMode(Grid.SelectionMode.SINGLE);
    	
    	  button.addClickListener(e -> {
    		
          	Tweet tweet = new Tweet(nombre.getValue(), mensaje.getValue());
          	//tweet.setFecha(tweet.getFechaCorrecta());
          	tweet.setTam(tweet.getMensaje().length());
          	if(tweet.getMensaje().length() > 140) {
          		Notification.show("No se pueden usar más de 140 caracteres."); 
          	}
          	t.addTweet(tweet);
  
  			tweetList.getDataProvider().refreshAll();
  			Notification.show("Actualización correcta");
  			
          });
    	  
    	HorizontalLayout formulario = new HorizontalLayout(nombre, mensaje);
    	VerticalLayout tabla = new VerticalLayout(formulario,button, tweetList);
    	
    	tweetList.setSizeFull();
    	setContent(tabla);		
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
