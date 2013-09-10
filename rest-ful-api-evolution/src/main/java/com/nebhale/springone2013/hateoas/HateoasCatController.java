
package com.nebhale.springone2013.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hateoas/cats", produces = MediaType.APPLICATION_JSON_VALUE)
class HateoasCatController {

    private final CatResourceAssembler resourceAssembler = new CatResourceAssembler();

    @RequestMapping(method = RequestMethod.GET, value = "/{catId}")
    @ResponseBody
    Resource<Cat> read(@PathVariable Integer catId) {
        // TODO: Return resource
        return null;
    }

}
