                  /*  File:  OE16A_1.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16A_1 extends Template {

     static {templateClass = new OE16A_1() ; }

     public void setup() {
          filePrefix = "OE16A_1" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 1.5 ;   
          xmin = -3  ;
          xmax = 1 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 0.5) ;
          fCurve("y=x*x+4*x+4", 0, xmin, xmax, OPEN) ;
          fCurve("y=4-x*x", 0, xmin, xmax, OPEN) ;
          fEnv("psFillGray", 0.9) ;
          fCurve("y=x*x+4*x+4", 0, -2, 0, FILLED) ;
          fCurve("y=4-x*x",     0, -2, 0, FILLED) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("y=x*x+4*x+4", 0, -2, 0, OPEN) ;
          fCurve("y=4-x*x",     0, -2, 0, OPEN) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          double x = -0.9  ; double y = x*x+4*x+ 4 ; 
          double xx = -0.8 ; double yy = xx*xx+4*xx+ 4 ;
          fArrow(x,y, xx,yy) ; 
          x = -1.0  ; y = 4 - x*x ; 
          xx = -1.1 ; yy = 4-  xx*xx ;
          fArrow(x,y, xx,yy) ; 


          fTeXlabel(xmax, -0.15, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(0.3, ymax, "cl", "$y=x^2+4x+4$") ;
          fTeXlabel(xmax+0.1, 4-xmax*xmax, "cl", "$y=4-x^2$") ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;
          fDisk(0, 4, r, r*aspect, FILLED) ;
          fDisk(-2, 0, r, r*aspect, FILLED) ;
//          fTeXlabel(0,  4, "tl", "$(0,4)$") ;
          fTeXlabel(-2,  -0.2, "tl", "$(-2,0)$") ;
          fTeXlabel(-1,  2, "cc", "$R$") ;
          fTeXlabel(-0.9,  1, "tl", "$C$") ;
          fTeXlabel(-1.1,  3, "br", "$C$") ;




     }
}
