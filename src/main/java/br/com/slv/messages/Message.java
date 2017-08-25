package br.com.slv.messages;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	public void send(String info) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
