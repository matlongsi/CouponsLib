package com.coupon.common.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.coupon.common.bean.TimePeriodBean;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class TimePeriodMessage implements MessageBodyWriter<TimePeriodBean> {

	@Override
	public long getSize(TimePeriodBean tp,
			Class<?> type,
			Type genericType,
			Annotation[] annotations,
			MediaType mediaType) {

		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> type,
			Type genericType,
			Annotation[] annotations,
			MediaType mediaType) {

		return (type == TimePeriodBean.class);
	}

	@Override
	public void writeTo(TimePeriodBean tp,
			Class<?> type,
			Type genericType,
			Annotation[] annotations,
			MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException, WebApplicationException {

        StringBuilder sb = new StringBuilder();
        sb.append("<boolean>")
        		.append(tp.toString())
        		.append("</boolean>");
        DataOutputStream dos = new DataOutputStream(entityStream);
        dos.writeUTF(sb.toString());
	}

}