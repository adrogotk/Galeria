package es.etg.psp.galeria.controller;
import es.etg.psp.galeria.data.*;
import es.etg.psp.galeria.views.Impresora;
import es.etg.psp.galeria.views.ImpresoraFactory;
import es.etg.psp.galeria.views.TipoImpresion;

public class Galeria{
	public static final int TOTAL_PLATOS=10;
	private int nPlatosColocados;
	private int nPlatosVendidos;
	private Thread alfarero;
	private Thread vendedor;
	public Galeria(){
		this.nPlatosColocados=0;
		this.nPlatosVendidos=0;
		this.alfarero=new Thread(new Alfarero(this));
		this.vendedor=new Thread(new Vendedor(this));
	}
	public Galeria(int nPlatosVendidos, int nPlatosColocados){
		this.nPlatosVendidos=nPlatosVendidos;
		this.nPlatosColocados=nPlatosColocados;
		this.alfarero=new Thread(new Alfarero(this));
		this.vendedor=new Thread(new Vendedor(this));
	}
	public int getNPlatosVendidos(){
		return this.nPlatosVendidos;
	}
	public void setNPlatosVendidos(int nPlatosVendidos){
		this.nPlatosVendidos=nPlatosVendidos;
	}
	public void ejecutar() throws InterruptedException{
		this.alfarero.start();
		this.vendedor.start();
	}
	public synchronized void colocar() throws InterruptedException{
		if (this.nPlatosColocados > 0){
			this.wait();
		}
		this.nPlatosColocados++;
		imprimir(String.format(Alfarero.TEXTO_PRODUCCION, this.nPlatosVendidos+1));
		
		
	}
	public synchronized void vender() throws InterruptedException{
		if (nPlatosColocados == 0){
			this.wait();
		}
		this.nPlatosColocados--;
		
		this.setNPlatosVendidos(this.nPlatosVendidos+1);
		imprimir(String.format(Vendedor.TEXTO_VENTA, this.nPlatosVendidos));
	}
	public synchronized void imprimir(String data){
    Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
    impresora.imprimir(data);
    this.notify();
    } 
}
