package es.etg.psp.galeria.data;
import es.etg.psp.galeria.controller.Galeria;
import es.etg.psp.galeria.views.*;

public abstract class Trabajador {
   public synchronized void imprimir(String data){
      Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
      impresora.imprimir(data);
      notify();
   }
}
