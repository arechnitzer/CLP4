                  /*  File:  curve1.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curve1 extends Template {

     static {templateClass = new curve1() ; }

     public void setup() {
          filePrefix = "curve1" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;   
          ysize = 1.0 ;   
          xmin = -1.0 ;
          xmax = 1.0 ;
          ymin = -0.1;
          ymax = 1.1;
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
          fCurve("x*x", 0, -1, 1, OPEN) ;
          fTeXlabel(0.0, -0.25, "cc", "simple curve") ;

     }
}
