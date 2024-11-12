package es.etg.psp.galeria.data;
import es.etg.psp.galeria.views.*;

public abstract class Trabajador {
   public void imprimir(String data){
      Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
      impresora.imprimir(data);
   }
}
