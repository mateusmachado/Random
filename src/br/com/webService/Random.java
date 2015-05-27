package br.com.webService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class Random {

	@Resource
	WebServiceContext wsc;

	public double next(double max) {
		MessageContext mc = wsc.getMessageContext();
		// get detail from request headers
		Map headers = (Map) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
		List usernameList = (List) headers.get("Username");
		List passwordList = (List) headers.get("Password");

		String username = usernameList != null ? usernameList.get(0).toString()
				: null;
		String password = usernameList != null ? passwordList.get(0).toString()
				: null;

		System.out.println(username);
		System.out.println(password);

		if ("k19".equalsIgnoreCase(username)
				&& "k23".equalsIgnoreCase(password)) {
			return Math.random() * max;
		} else {
			throw new RuntimeException("Usuário ou Senha incorreto!");
		}
	}
}
