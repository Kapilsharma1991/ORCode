package com.png.serializer;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.png.base.BaseConstants;

@Component
public class JsonDateSerializer extends JsonSerializer<DateTime>{
	/**
	 * Used to serialize Java.util.Date, which is not a common JSON
	 * type, so we have to create a custom serialize method;.
	 *
	 */
	
	private static final DateTimeFormatter dateFormat = org.joda.time.format.DateTimeFormat.forPattern(BaseConstants.DATE_FORMAT);
	@Override
	public void serialize(DateTime date, JsonGenerator gen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		String formattedDate = dateFormat.print(date);
		gen.writeString(formattedDate);
	}
}

