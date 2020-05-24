                  /*  File:  OE00AQ3.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE00AQ3 extends Template {

     static {templateClass = new OE00AQ3() ; }

     public void setup() {
          filePrefix = "OE00AQ3" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;   
          ysize = 0.75 ;   
          xmin = -0.1 ;
          xmax = 1.2 ;
          ymin = -0.1 ;
          ymax = 1.2;
          topmargin = 0.1 ;
          bottommargin = 0.1 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fCurve("y = 1-x*x", 0, xmin, xmax, OPEN) ;
          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("y = 1-x*x", 0, 0, 1, OPEN) ;
          fLine(0,0,0,1) ;
          fLine(0,0,1,0) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(0,1, 0, 0.5) ;
          fArrow(0,0, 0.5,0) ;

          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fTeXlabel(0.3, 0.95, "bl", "$y=1-x^2$") ;
          fTeXlabel(-0.02, 0.55, "rc", "$\\cC_1$") ;
          fTeXlabel(0.5, -0.05, "tc", "$\\cC_2$") ;
          fTeXlabel(0.45, 0.75, "tc", "$\\cC_3$") ;


     }
}
