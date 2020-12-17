package ru.mirea.t27_28;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OperatingInterface {
    String name();
}
