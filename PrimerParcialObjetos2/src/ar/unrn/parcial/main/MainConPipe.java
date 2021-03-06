package ar.unrn.parcial.main;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.unrn.parcial.accesos.EnDiscoRegistroDeVentaConPipe;
import ar.unrn.parcial.emailServices.VentasEmailSender;
import ar.unrn.parcial.modelo.DateManager;
import ar.unrn.parcial.modelo.Remera;
import ar.unrn.parcial.modelo.RemeraEstampada;
import ar.unrn.parcial.modelo.RemeraLisa;
import ar.unrn.parcial.modelo.Ventas;
import ar.unrn.parcial.ui.RealizarCompra;

public class MainConPipe {
	public static void main(String[] args) {
		ArrayList<Remera> remeras = new ArrayList<Remera>();

		RemeraEstampada remEst = new RemeraEstampada(2500.0, "Remera Estampada");
		RemeraLisa remLisa = new RemeraLisa(2000, "Remera Lisa");

		remeras.add(remLisa);
		remeras.add(remEst);

		EnDiscoRegistroDeVentaConPipe registroVenta = new EnDiscoRegistroDeVentaConPipe();

		Ventas sistVentas = new Ventas();

		VentasEmailSender ventasEmail = new VentasEmailSender();

		DateManager adminFecha = new DateManager(LocalDateTime.now());

		RealizarCompra ui = new RealizarCompra(sistVentas, adminFecha, registroVenta, ventasEmail, remeras);

	}
}
