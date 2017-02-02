package com.tdsystemsgroup.blackjack.server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 * a server class to be used until we can implement a real http server
 * to serve these requests
 *
 * Created by duerrt on 6/4/16.
 */
@ApplicationPath("game")
public class BlackJackServer extends Application {
 @Override
    public Set<Class<?>> getClasses() {
       final Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(BlackJackResource.class);
     return classes;
    }
}
