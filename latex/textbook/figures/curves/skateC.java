                  /*  File:  skateC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class skateC extends Template {

     static {templateClass = new skateC() ; }

     public void setup() {
          filePrefix = "skateC" ;    // used as the prefix for any ps, lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0;      // in inches
          ysize = 1.0 ;   // in inches
          xmin = -10 ;
          xmax = 10 ;
          ymin = -10 ;
          ymax = 10 ;
          topmargin = -0.1 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          double A = 9.0 ; 
          double a = 8.0 ;
          double th = 60 ; double thRad = th*Math.PI/180 ;
          double x = -a*Math.sin(thRad) ; double y = a*Math.cos(thRad) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(0,0, A,A, CLOSED) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, a, a, -90, 90+th, OPEN) ;
          fEnv("arrowHeadColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("psFillColor", Blue) ;
          fArrowhead(x,y, 180+th) ;
//          fTeXlabel(0, -A-3.5, "bc", "impressive!") ;
          fTeXlabel(0, -A-3.5, "bc", "thrilled!") ;

          
     }
}
