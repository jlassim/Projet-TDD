package org.example;

public interface GererDB {
    void connect();
    void verify();
    void create();
    void drop();
    void save(Data d);
}
