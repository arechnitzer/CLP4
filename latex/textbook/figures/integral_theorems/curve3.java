                  /*  File:  curve3.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curve3 extends Template {

     static {templateClass = new curve3() ; }

     public void setup() {
          filePrefix = "curve3" ;
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
          fCurve("[sin(3*t),cos(t)]", 1, -4, 4, OPEN) ;
          fTeXlabel(0.0, -1.23, "cc", "not a simple") ;
          fTeXlabel(0.0, -1.48, "cc", "curve") ;

     }
}
