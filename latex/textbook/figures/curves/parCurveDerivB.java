                  /*  File:  parCurveDerivB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class parCurveDerivB extends Template {

     static {templateClass = new parCurveDerivB() ; }

     public void setup() {
          filePrefix = "parCurveDerivB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;   
          ysize = 1.3 ;   
          xmin = 0  ;
          xmax = 6 ;
          ymin = 0 ;
          ymax = 1.3 ;
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

          fEnv("lineWidth", 1.0) ;
          fCurve("y = 2/(2+x)", 0, -0.2, xmax, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.13 ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          double x1 = 0.5 ; double y1 = 2/(2+x1) ;
          fDisk(x1, y1, r, r*aspect, FILLED) ;
          fTeXlabel(x1, y1-0.03, "tr", "$\\vr(0)$") ;
          double x2 = 2.5 ;  double y2 = 2/(2+x2) ;
          fDisk(x2, y2, r, r*aspect, FILLED) ;
          fTeXlabel(x2, y2-0.07, "tr", "$\\vr(t)$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("arrowHeadColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.7) ;
          fEnv("headLength", 6.0*1.7) ;
          double dx = 2 ;  double dy = -dx*2/((2+x2)*(2+x2)) ;
          fArrow(x2,y2, x2+dx,y2+dy) ;
          fTeXlabel(x2+dx, y2+dy-0.04, "tc", "$\\hat\\vT(t)$") ;
          double x3 = xmax-0.1 ;  double y3 = 2/(2+x3) ;
          dx = 0.1 ;   dy = -dx*2/((2+x3)*(2+x3)) ;
          fEnv("psFillColor", Red) ;
          fArrow(x3,y3, x3+dx,y3+dy) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fCurve("y = 1.1*(1+0.015*x)*2/(2+x)", 0, x1+0.1, x2+0.07, OPEN) ;
          fTeXlabel(0.4*x1+0.6*x2, y2+0.23, "bc", "$s(t)$") ;





     }
}
