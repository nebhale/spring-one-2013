
package com.nebhale.springone2013.naiveoutput;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/naiveoutput/cats", produces = MediaType.APPLICATION_JSON_VALUE)
class NaiveOutputCatController {

    @RequestMapping(method = RequestMethod.GET, value = "/{catId}")
    @ResponseBody
    CatV1 readV1(@PathVariable Integer catId) {
        return new CatV1();
    }
}
