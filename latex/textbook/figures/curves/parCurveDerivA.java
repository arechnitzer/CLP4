                  /*  File:  parCurveDerivA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class parCurveDerivA extends Template {

     static {templateClass = new parCurveDerivA() ; }

     public void setup() {
          filePrefix = "parCurveDerivA" ;
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
          double x1 = 1 ; double y1 = 2/(2+x1) ;
          fDisk(x1, y1, r, r*aspect, FILLED) ;
          fTeXlabel(x1+0.05, y1+0.03, "bl", "$\\vr(t)$") ;
          double x2 = 4 ;  double y2 = 2/(2+x2) ;
          fDisk(x2, y2, r, r*aspect, FILLED) ;
          fTeXlabel(x2+0.7, y2-0.07, "tr", "$\\vr(t+h)$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("arrowHeadColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.7) ;
          fEnv("headLength", 6.0*1.7) ;
          fArrow(x1,y1, x2,y2) ;
          fTeXlabel( (x1+x2)*0.5-0.3, (y1+y2)*0.5+0.03, "bl", "$\\vr(t+h)-\\vr(t)$") ;




     }
}
