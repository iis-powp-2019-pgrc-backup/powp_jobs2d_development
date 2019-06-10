package edu.kis.powp.jobs2d.command.letters;

public interface AbstractFactory<T> {

    T create(String type);

}
