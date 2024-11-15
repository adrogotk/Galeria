package es.etg.psp.galeria.views;


public class ImpresoraPantalla extends Impresora{

	public synchronized void imprimir(String data){
		System.out.println(data);
    }

}
