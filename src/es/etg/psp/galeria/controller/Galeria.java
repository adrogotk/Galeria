package es.etg.psp.galeria.controller;
import es.etg.psp.galeria.data.*;

public class Galeria{
	public static final int TOTAL_PLATOS=10;
	private int nPlatosColocados;
	private int nPlatosVendidos;
	public Galeria(){
		this.nPlatosColocados=0;
		this.nPlatosVendidos=0;
	}
	public Galeria(int nPlatosVendidos, int nPlatosColocados){
		this.nPlatosVendidos=nPlatosVendidos;
		this.nPlatosColocados=nPlatosColocados;
	}
	public int getNPlatosVendidos(){
		return this.nPlatosVendidos;
	}
	public void setNPlatosVendidos(int nPlatosVendidos){
		this.nPlatosVendidos=nPlatosVendidos;
	}
	public void ejecutar() throws InterruptedException{
		Thread alfarero=new Thread(new Alfarero(this));
		Thread vendedor=new Thread(new Vendedor(this));
		alfarero.start();
		vendedor.start();
	}
	public synchronized void colocar() throws InterruptedException{
		if (nPlatosColocados == 0){
			this.nPlatosColocados++;
		}
		else{
			wait();
			this.nPlatosColocados++;
		}
		notify();
		
	}
	public synchronized void vender() throws InterruptedException{
		if (nPlatosColocados == 0){
			wait();
			this.nPlatosColocados--;
		}
		else {
			this.nPlatosColocados--;
		}
		this.setNPlatosVendidos(this.nPlatosVendidos+1);
		notify();
	}
}
