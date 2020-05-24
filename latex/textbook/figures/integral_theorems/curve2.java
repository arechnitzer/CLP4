                  /*  File:  curve2.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curve2 extends Template {

     static {templateClass = new curve2() ; }

     public void setup() {
          filePrefix = "curve2" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;   
          ysize = 1.0 ;   
          xmin = -1.0 ;
          xmax = 1.0 ;
          ymin = -1.0;
          ymax = 1.0;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0.0 ;
          rightmargin = 0.0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fDisk(0.0, 0.0, 0.95, 0.6, CLOSED ) ;
          fTeXlabel(0.0, -1.26, "cc", "simple closed curve") ;

     }
}
