                  /*  File:  OE16A_6h.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16A_6h extends Template {

     static {templateClass = new OE16A_6h() ; }

     public void setup() {
          filePrefix = "OE16A_6h" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 1.5 ;   
          xmin = -2  ;
          xmax = 2 ;
          ymin = -1 ;
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
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fArrow(0,0, 1.3,0) ;
          fArrow(0,0, 0,1.3*3/2) ;
          fTeXlabel(1.3, -0.2, "ct", "$\\vu$") ;
          fTeXlabel(-0.1, 1.3*3/2, "rt", "$\\vv$") ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("y=x*x",     0, -2, 2, OPEN) ;
          fEnv("psFillColor", Red) ;
          double x = 1.0  ; double y = x*x ; 
          double xx = 1.1 ; double yy = xx*xx ;
          fArrow(x,y, xx,yy) ; 


          fTeXlabel(xmax, -0.15, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.1, xmax*xmax, "cl", "$y=x^2$") ;

          fTeXlabel(-1.1,  1.1*1.1+0.1, "bl", "$C$") ;




     }
}
