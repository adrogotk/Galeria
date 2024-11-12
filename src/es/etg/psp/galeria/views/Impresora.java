package es.etg.psp.galeria.views;


public abstract class Impresora {
   public void imprimir(String data){
      ImpresoraPantalla impresora=new ImpresoraPantalla();
      impresora.imprimir(data);
   }
}
