package es.etg.psp.galeria.data;
import es.etg.psp.galeria.controller.*;

public class Alfarero extends Trabajador implements Runnable{
	
	public static final String TEXTO_PRODUCCION="Se ha producido el %sº plato de ceramica";
	private Galeria galeria;
	public Alfarero(Galeria galeria){
        this.galeria=galeria;
    }
    public void run(){
		try {
	    for (int i=1; i<=Galeria.TOTAL_PLATOS; i++){
			this.galeria.colocar();
	    }
        } catch (InterruptedException e) {
             super.imprimir(e.getMessage());
        }
	}
}
