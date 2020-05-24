                  /*  File:  stokes2.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class stokes2 extends Template {

     static {templateClass = new stokes2() ; }

     public void setup() {
          filePrefix = "stokes2" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*1.6 ;   
          ysize = 1.8*1.6 ;   
          xmin = -0.1 ;
          xmax = 0.9 ;
          ymin = -0.5 ;
          ymax = 1.3;
          topmargin = -0.2 ;
          bottommargin = -0.2 ;
          leftmargin = -0.2 ;
          rightmargin = 0.2 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          fDisk(0.5, 0.5, 0.4, 0.2, CLOSED) ;
          fDisk(0.5, 0.5, 0.4, 0.2, CLOSED) ;
//          fEnv("psFillGray", 0.4) ;
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          fDisk(0.7, 0.5, 0.015*1.2, 0.015*1.2, FILLED) ;
          fEnv("psFillColor", Black) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(0.5, 0.3, 0) ;
          fTeXlabel(0.52,0.26, "tl", "$\\partial R$") ;

          fTeXlabel(0.2,0.5, "cc", "$R$") ;
          fTeXlabel(0.69,0.49,"tr", "$(u,v)$") ;

          fEnv("lineWidth", 0.5) ;

          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, -0.1, 0.0, 0.9) ;
          fTeXlabel(xmax, -0.05, "tr", "$u$") ;
          fTeXlabel(-0.05, 0.9, "tr", "$v$") ;


     }
}
