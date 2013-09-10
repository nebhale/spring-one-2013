
package com.nebhale.springone2013.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

final class CatResourceAssembler implements ResourceAssembler<Cat, Resource<Cat>> {

    @Override
    public Resource<Cat> toResource(Cat cat) {
        Owner owner = new Owner();
        Resource<Cat> resource = new Resource<>(cat);
        // TODO: Add self link
        // TODO: Add owner link

        return resource;
    }
}
