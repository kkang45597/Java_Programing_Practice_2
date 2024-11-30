package com.mingi.lookupinjection;

public interface Command {
    void setState(Object state);
    Object execute();
}