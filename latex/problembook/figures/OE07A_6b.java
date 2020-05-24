                  /*  File:  OE07A_6b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE07A_6b extends Template {

     static {templateClass = new OE07A_6b() ; }

     public void setup() {
          filePrefix = "OE07A_6b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*0.6 ;   
          ysize = 3.4*0.5 ;   
          xmin = -0.2  ;
          xmax = 1.3 ;
          ymin = -1.8 ;
          ymax = 1.8 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.9) ;
          fCurve("[cos(t), t]", 1, -Math.PI/2.0, Math.PI/2.0, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.04, ymax, "tr", "$y$") ;
          fTeXlabel(0.92, 0.5, "bl", "$x=\\cos y$") ;
          fTeXlabel(0.9, -0.5, "tl", "$C$") ;
          fTeXlabel(-0.1, 0.5, "cr", "$L$") ;
          fTeXlabel(0.5,  0.3, "cc", "$R$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;


          fEnv("lineWidth", 1.5) ;
          fCurve("[cos(t), t]", 1, -Math.PI/2.0, Math.PI/2.0, OPEN) ;
          fLine(0,Math.PI/2.0, 0, -Math.PI/2.0 ) ;

          fEnv("headLength", 6.0*1.4) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          double Y = -0.7 ; double X = Math.cos(Y) ; 
          double th = Math.atan(-1/Math.sin(Y)) * 180/Math.PI ;
          fArrowhead(X, Y, th) ;
          fArrowhead(0, 0.5, -90) ;


//          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
//          double r = 0.07 ;
//          fDisk(0, 0, r, r*aspect, FILLED) ;

     }
}
