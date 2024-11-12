package es.etg.psp.galeria.data;
import es.etg.psp.galeria.controller.*;

public class Vendedor extends Trabajador implements Runnable{
	public static final String TEXTO_VENTA="Se ha vendido el %sº plato de ceramica";
	private Galeria galeria;
	public Vendedor(Galeria galeria){
        this.galeria=galeria;
    }
     public void run(){
		try {
          for (int i=1; i<=Galeria.TOTAL_PLATOS; i++){
			this.galeria.vender();
			int nPlatos=this.galeria.getNPlatosVendidos();
			super.imprimir(String.format(TEXTO_VENTA, nPlatos));
		  }
        } catch (InterruptedException e) {
            super.imprimir(e.getMessage());
        }
	}
}

