
package com.nebhale.springone2013.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hateoas/owners", produces = MediaType.APPLICATION_JSON_VALUE)
class HateoasOwnerController {

    private final OwnerResourceAssembler resourceAssembler = new OwnerResourceAssembler();

    @RequestMapping(method = RequestMethod.GET, value = "/{ownerId}")
    @ResponseBody
    Resource<Owner> read(@PathVariable Integer ownerId) {
        return this.resourceAssembler.toResource(new Owner());
    }
}
