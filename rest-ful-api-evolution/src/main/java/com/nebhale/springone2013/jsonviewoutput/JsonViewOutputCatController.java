
package com.nebhale.springone2013.jsonviewoutput;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/jsonviewoutput/cats", produces = MediaType.APPLICATION_JSON_VALUE)
class JsonViewOutputCatController {

    @RequestMapping(method = RequestMethod.GET, value = "/{catId}", produces = "application/vnd.nebhale.cat.v1+json")
    @ResponseBody
    Cat readV1(@PathVariable Integer catId) {
        return new Cat();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{catId}", produces = "application/vnd.nebhale.cat.v2+json")
    @ResponseBody
    Cat readV2(@PathVariable Integer catId) {
        return new Cat();
    }

}
