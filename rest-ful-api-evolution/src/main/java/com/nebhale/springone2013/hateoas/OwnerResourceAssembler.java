
package com.nebhale.springone2013.hateoas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

final class OwnerResourceAssembler implements ResourceAssembler<Owner, Resource<Owner>> {

    @Override
    public Resource<Owner> toResource(Owner owner) {
        Cat cat = new Cat();
        Resource<Owner> resource = new Resource<>(owner);
        resource.add(linkTo(methodOn(HateoasOwnerController.class).read(owner.getId())).withSelfRel());
        resource.add(linkTo(methodOn(HateoasCatController.class, owner.getId()).read(cat.getId())).withRel("cat"));

        return resource;
    }

}
