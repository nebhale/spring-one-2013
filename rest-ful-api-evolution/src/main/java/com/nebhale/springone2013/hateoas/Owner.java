
package com.nebhale.springone2013.hateoas;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class Owner {

    private final Integer id = 0;

    private final String name = "Ben Hale";

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
