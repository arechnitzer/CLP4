                  /*  File:  cuspB.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cuspB extends Template {

     static {templateClass = new cuspB() ; }

     public void setup() {
          filePrefix = "cuspB" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.6 ;      // in inches
          ysize = 0.5 ;   // in inches. 
          xmin = -0.1 ;
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
          fTeXlabel(0.1, 1, "tl", "$\\vr_2(t)$") ;

          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fLine(1,0, 0,0) ;
          fLine(0,0, 0,1) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

          double y = 0.5 ;
          fArrowhead(0, y, -90) ;
          double x = 0.5 ;
          fArrowhead(x, 0, 0) ;

          fTeXlabel(0, -0.1, "tc", "$t=0$") ;

     }
}
