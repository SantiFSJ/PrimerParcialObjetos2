package testSistemaVentas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;

import ar.unrn.parcial.accesos.StubEnDiscoRegistroDeVenta;
import ar.unrn.parcial.emailServices.StubVentasEmailSender;
import ar.unrn.parcial.modelo.DateManager;
import ar.unrn.parcial.modelo.RemeraEstampada;
import ar.unrn.parcial.modelo.RemeraLisa;
import ar.unrn.parcial.modelo.Ventas;

public class CompraRemerasTest {
	// ArrayList<Remera> remeras = new ArrayList<Remera>();

	RemeraEstampada remEst = new RemeraEstampada(2500.0, "Remera Estampada");
	RemeraLisa remLisa = new RemeraLisa(2000, "Remera Lisa");

	@Test
	public void comprarRemerasLisasHorarioComun() {
		// Set up

		StubEnDiscoRegistroDeVenta registroVenta = new StubEnDiscoRegistroDeVenta();

		Ventas sistemaVentas = new Ventas();

		StubVentasEmailSender ventasEmail = new StubVentasEmailSender();

		DateManager adminFecha = new DateManager(LocalDateTime.of(2022, 5, 7, 15, 0));
		// Ejercitacion

		try {
			sistemaVentas.generarVenta(adminFecha, registroVenta, ventasEmail, 3, remLisa, "testEmail@gmail.com");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificacion

		String resultadoEsperadoRegistro = " Fecha de Venta: 7/5/2022 Cantidad de Remeras: 3 Monto Total: 6000.0";
		String resultadoEsperadoEmail = "Fecha de Venta: 7/5/2022 Cantidad de Remeras: 3 Monto Total: 6000.0";

		assertEquals(resultadoEsperadoRegistro, registroVenta.mensajeArchivado());
		assertEquals(resultadoEsperadoEmail, ventasEmail.mensajeEnviado());
	}

	@Test
	public void comprarRemerasLisasHorarioEspecial() {
		// Set up

		StubEnDiscoRegistroDeVenta registroVenta = new StubEnDiscoRegistroDeVenta();

		Ventas sistemaVentas = new Ventas();

		StubVentasEmailSender ventasEmail = new StubVentasEmailSender();

		DateManager adminFecha = new DateManager(LocalDateTime.of(2022, 5, 7, 9, 0));

		// Ejercitacion

		try {
			sistemaVentas.generarVenta(adminFecha, registroVenta, ventasEmail, 3, remLisa, "testEmail@gmail.com");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificacion

		String resultadoEsperadoRegistro = " Fecha de Venta: 7/5/2022 Cantidad de Remeras: 3 Monto Total: 5700.0";
		String resultadoEsperadoEmail = "Fecha de Venta: 7/5/2022 Cantidad de Remeras: 3 Monto Total: 5700.0";
		assertEquals(resultadoEsperadoRegistro, registroVenta.mensajeArchivado());
		assertEquals(resultadoEsperadoEmail, ventasEmail.mensajeEnviado());
	}

	@Test
	public void comprarRemerasEstampadasDomingo() {
		// Set up

		StubEnDiscoRegistroDeVenta registroVenta = new StubEnDiscoRegistroDeVenta();

		Ventas sistemaVentas = new Ventas();

		StubVentasEmailSender ventasEmail = new StubVentasEmailSender();

		DateManager adminFecha = new DateManager(LocalDateTime.of(2022, 5, 8, 9, 0));

		// Ejercitacion

		try {
			sistemaVentas.generarVenta(adminFecha, registroVenta, ventasEmail, 5, remEst, "testEmail@gmail.com");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificacion

		String resultadoEsperadoRegistro = " Fecha de Venta: 8/5/2022 Cantidad de Remeras: 5 Monto Total: 11250.0";
		String resultadoEsperadoEmail = "Fecha de Venta: 8/5/2022 Cantidad de Remeras: 5 Monto Total: 11250.0";
		assertEquals(resultadoEsperadoRegistro, registroVenta.mensajeArchivado());
		assertEquals(resultadoEsperadoEmail, ventasEmail.mensajeEnviado());
	}

	@Test
	public void comprarRemerasEstampadasSabadoEnCantidad() {
		// Set up

		StubEnDiscoRegistroDeVenta registroVenta = new StubEnDiscoRegistroDeVenta();

		Ventas sistemaVentas = new Ventas();

		StubVentasEmailSender ventasEmail = new StubVentasEmailSender();

		DateManager adminFecha = new DateManager(LocalDateTime.of(2022, 5, 7, 9, 0));

		// Ejercitacion

		try {
			sistemaVentas.generarVenta(adminFecha, registroVenta, ventasEmail, 4, remEst, "testEmail@gmail.com");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificacion

		String resultadoEsperadoRegistro = " Fecha de Venta: 7/5/2022 Cantidad de Remeras: 4 Monto Total: 8800.0";
		String resultadoEsperadoEmail = "Fecha de Venta: 7/5/2022 Cantidad de Remeras: 4 Monto Total: 8800.0";
		assertEquals(resultadoEsperadoRegistro, registroVenta.mensajeArchivado());
		assertEquals(resultadoEsperadoEmail, ventasEmail.mensajeEnviado());
	}

	@Test
	public void comprarRemerasEstampadasSabadoEnPocaCantidad() {
		// Set up

		StubEnDiscoRegistroDeVenta registroVenta = new StubEnDiscoRegistroDeVenta();

		Ventas sistemaVentas = new Ventas();

		StubVentasEmailSender ventasEmail = new StubVentasEmailSender();

		DateManager adminFecha = new DateManager(LocalDateTime.of(2022, 5, 7, 9, 0));

		// Ejercitacion

		try {
			sistemaVentas.generarVenta(adminFecha, registroVenta, ventasEmail, 2, remEst, "testEmail@gmail.com");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificacion

		String resultadoEsperadoRegistro = " Fecha de Venta: 7/5/2022 Cantidad de Remeras: 2 Monto Total: 5000.0";
		String resultadoEsperadoEmail = "Fecha de Venta: 7/5/2022 Cantidad de Remeras: 2 Monto Total: 5000.0";
		assertEquals(resultadoEsperadoRegistro, registroVenta.mensajeArchivado());
		assertEquals(resultadoEsperadoEmail, ventasEmail.mensajeEnviado());
	}

}
