
package com.nebhale.springone2013.jsonviewoutput;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseView {

    public Class<?> value();
}