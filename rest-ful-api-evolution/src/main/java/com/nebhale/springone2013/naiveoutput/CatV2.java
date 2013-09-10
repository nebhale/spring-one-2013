
package com.nebhale.springone2013.naiveoutput;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class CatV2 {

    private final Integer id = 1;

    private final String name = "Loki";

    private final Integer whiskerCount = 61;

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getWhiskerCount() {
        return whiskerCount;
    }

}
