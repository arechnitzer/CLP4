                  /*  File:  OE12J_7.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE12J_7 extends Template {

     static {templateClass = new OE12J_7() ; }

     public void setup() {
          filePrefix = "OE12J_7" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 1.5 ;   
          xmin = -0.5  ;
          xmax = 3.5 ;
          ymin = -2 ;
          ymax = 5 ;
          topmargin = 0.1 ;
          bottommargin = 0 ;
          leftmargin = 0.2 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {

          fEnv("lineWidth", 0.5) ;
          fCurve("y=x*x-4*x+3", 0, xmin, xmax, OPEN) ;
          fCurve("y=3-x*x+2*x", 0, xmin, xmax, OPEN) ;
          fEnv("psFillGray", 0.9) ;
          fCurve("y=x*x-4*x+3", 0, 0, 3, FILLED) ;
          fCurve("y=3-x*x+2*x",     0, 0, 3, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("y=x*x-4*x+3", 0, 0, 3, OPEN) ;
          fCurve("y=3-x*x+2*x", 0, 0, 3, OPEN) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          double x = 1.95  ; double y = x*x-4*x + 3 ; 
          double xx = 2.05 ; double yy = xx*xx-4*xx + 3 ;
          fArrow(x,y, xx,yy) ;      fTeXlabel(xx-0.2, yy-0.3, "tc", "$C$") ;
          x = 1.05  ; y = 3 - x*x +2*x ; 
          xx = 0.95; yy = 3-  xx*xx +2*xx ;
          fArrow(x,y, xx,yy) ;     fTeXlabel(xx+0.2, yy+0.3, "bc", "$C$") ;


          fTeXlabel(xmax, -0.15, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.05, xmax*xmax -4*xmax +3.05, "cl", "$y=x^2-4x+3$") ;
          fTeXlabel(xmax+0.05, 3.2-xmax*xmax +2*xmax, "cl", "$y=3-x^2+2x$") ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;
          fDisk(3, 0, r, r*aspect, FILLED) ;
          fDisk(0, 3, r, r*aspect, FILLED) ;
          fTeXlabel(-0.1,  3, "cr", "$(0,3)$") ;
          fTeXlabel(2.8, 0.05, "br", "$(3,0)$") ;
          fTeXlabel(1.5,  1.5, "cc", "$R$") ;
          




     }
}
