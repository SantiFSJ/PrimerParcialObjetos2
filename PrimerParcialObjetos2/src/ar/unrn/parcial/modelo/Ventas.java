package ar.unrn.parcial.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

public class Ventas implements SistemaVentas {

	@Override
	public void generarVenta(SistemaFechas sistFecha, RepositorioVentas repoVentas, MandadorVentas mandadorVentas,
			int cantidad, Remera tipoRemera, String email)
			throws MessagingException, FileNotFoundException, IOException {

		Venta venta = new Venta(cantidad, tipoRemera, new Email(email), sistFecha.obtenerFecha());

		repoVentas.archivar(sistFecha.obtenerFecha(), cantidad, venta.montoTotal());

		mandadorVentas.mandarEmail(email, sistFecha.obtenerFecha(), cantidad, venta.montoTotal());

	}

	public Double consultarMontoVenta(SistemaFechas sistFecha, int cantidad, Remera tipoRemera, String email)
			throws IOException {

		Venta venta = new Venta(cantidad, tipoRemera, new Email(email), sistFecha.obtenerFecha());

		return venta.montoTotal();
	}

}
