package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

import javax.mail.MessagingException;

public interface MandadorVentas {

	public void mandarEmail(String email, LocalDateTime fechaVenta, int cantidadRemeras, Double montoTotal)
			throws MessagingException;

}
