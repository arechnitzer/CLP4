                  /*  File:  cuspA.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cuspA extends Template {

     static {templateClass = new cuspA() ; }

     public void setup() {
          filePrefix = "cuspA" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;      // in inches
          ysize = 0.5 ;   // in inches. 
          xmin = -1 ;
          xmax = 1 ;
          ymin = -0.1 ;
          ymax = 1 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(-1.1, 1, "cr", "$\\vr_1(t)$") ;

          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve("[t*t*t*t*t , t*t]", 1, -1, 1,  OPEN) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

          double t = -0.85 ; double slope = 2/(5*t*t*t) ;
          double thDeg = Math.atan(slope)*180/Math.PI ;
          fArrowhead(t*t*t*t*t, t*t, thDeg) ;

          t = 0.85 ; slope = 2/(5*t*t*t) ;
          thDeg = Math.atan(slope)*180/Math.PI ;
          fArrowhead(t*t*t*t*t, t*t, thDeg) ;


          fTeXlabel(0, -0.1, "tc", "$t=0$") ;

     }
}
