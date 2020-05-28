                  /*  File:  greens1.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class greens1 extends Template {

     static {templateClass = new greens1() ; }

     public void setup() {
          filePrefix = "greens1" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*1.3 ;   
          ysize = 1.8*1.3 ;   
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
          fEnv("psFillGray", 0.8) ;
          fDisk(0.5, 0.5, 0.4, 0.2, CLOSED+FILLED) ;
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Black) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(0.5, 0.3, 0) ;
          fTeXlabel(0.52,0.26, "tl", "$C$") ;

          fTeXlabel(0.5,0.5, "cc", "$R$") ;

          fEnv("lineWidth", 0.5) ;

          fLine(xmin, 0.1, xmax, 0.1) ;
          fLine(0.0, 0.0, 0.0, 0.8) ;
          fTeXlabel(xmax, 0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, 0.8, "tr", "$y$") ;


     }
}
