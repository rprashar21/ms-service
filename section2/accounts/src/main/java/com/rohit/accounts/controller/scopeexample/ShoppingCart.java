package com.rohit.accounts.controller.scopeexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    //Session scope is a simple and safe way to keep user data isolated in stateful web applications—each user gets their own,
    // private bean instance!
//
//    Session-scoped beans only exist during an actual HTTP request (when there’s a valid HTTP session).
//    Singleton beans (like your controller) are created at application startup, outside any HTTP request.
//    When Spring tries to inject the @SessionScope bean into your controller at startup,
//    the session scope is not active (there is no session yet!).

    //The injected object is now a proxy (not the actual session bean).
    //
    //When you call a method on it, the proxy will grab the correct ShoppingCart for the current session.
    //
    //No more ScopeNotActiveException!

    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
