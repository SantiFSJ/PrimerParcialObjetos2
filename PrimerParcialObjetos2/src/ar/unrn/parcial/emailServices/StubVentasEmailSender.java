package ar.unrn.parcial.emailServices;

import java.time.LocalDateTime;

import javax.mail.MessagingException;

import ar.unrn.parcial.modelo.MandadorVentas;

public class StubVentasEmailSender implements MandadorVentas {

	String mensajeEnviado;

	@Override
	public void mandarEmail(String email, LocalDateTime fechaVenta, int cantidadRemeras, Double montoTotal)
			throws MessagingException {
		this.mensajeEnviado = "Fecha de Venta: " + fechaVenta.getDayOfMonth() + "/" + fechaVenta.getMonthValue() + "/"
				+ fechaVenta.getYear() + " Cantidad de Remeras: " + cantidadRemeras + " Monto Total: " + montoTotal;
	}

	public String mensajeEnviado() {
		return mensajeEnviado;
	}
}
