
package com.nebhale.springone2013.jsonviewoutput;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;

public final class ViewAwareMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (object instanceof InstanceAndView) {
            writeView((InstanceAndView) object, outputMessage);
        } else {
            super.writeInternal(object, outputMessage);
        }
    }

    protected void writeView(InstanceAndView view, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        ObjectWriter writer = this.getObjectMapper().writerWithView(view.getJsonView());
        JsonGenerator jsonGenerator = writer.getFactory().createGenerator(outputMessage.getBody(), encoding);

        try {
            writer.writeValue(jsonGenerator, view.getInstance());
        } catch (IOException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }

}
