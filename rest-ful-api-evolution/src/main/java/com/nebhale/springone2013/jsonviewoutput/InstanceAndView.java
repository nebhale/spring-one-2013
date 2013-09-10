
package com.nebhale.springone2013.jsonviewoutput;

public class InstanceAndView {

    private final Object instance;

    private final Class<?> jsonView;

    public InstanceAndView(Object instance, Class<?> jsonView) {
        this.instance = instance;
        this.jsonView = jsonView;
    }

    public Object getInstance() {
        return instance;
    }

    public Class<?> getJsonView() {
        return jsonView;
    }

}
