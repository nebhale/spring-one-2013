
package com.nebhale.springone2013.naive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/naive/v1/cats", produces = MediaType.APPLICATION_JSON_VALUE)
class NaiveCatController {

    @RequestMapping(method = RequestMethod.GET, value = "/{catId}")
    @ResponseBody
    Cat read(@PathVariable Integer catId) {
        return new Cat();
    }

}
