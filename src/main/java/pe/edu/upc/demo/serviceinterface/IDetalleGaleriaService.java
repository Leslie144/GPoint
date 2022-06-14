package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.DetalleGaleria;


public interface IDetalleGaleriaService {
	
	public void insert(DetalleGaleria dg);

	public List<DetalleGaleria> list();

	
}
