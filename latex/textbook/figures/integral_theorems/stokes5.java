                  /*  File:  stokes5.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class stokes5 extends Template {

     static {templateClass = new stokes5() ; }

     public void setup() {
          filePrefix = "stokes5" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1*1.2 ;   
          ysize = 1.8*1.2 ;   
          xmin = -0.1 ;
          xmax = 0.9 ;
          ymin = -0.5 ;
          ymax = 1.3;
          topmargin = -0.3 ;
          bottommargin = -0.3 ;
          leftmargin = -0.5 ;
          rightmargin = -0.3 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fParticleLine(0.1,0.8,  0.8,0.8, 0.1, 1.0) ;
          fTeXlabel(0.45, 0.925, "bc", "$\\vr(u,v)$") ;



     }
}
