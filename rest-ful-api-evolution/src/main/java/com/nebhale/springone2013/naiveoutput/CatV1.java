
package com.nebhale.springone2013.naiveoutput;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class CatV1 {

    private final Integer id = 1;

    private final String name = "Loki";

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
