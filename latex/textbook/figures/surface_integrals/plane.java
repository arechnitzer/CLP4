                  /*  File:  plane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class plane extends Template {

     static {templateClass = new plane() ; }

     public void setup() {
          filePrefix = "plane" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 1.5 ;   // in inches
          xmin = 0 ;
          xmax = 200 ;
          ymin = 0 ;
          ymax = 100 ;
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
          fLine(0, 0,   150, 0) ;
          fLine(0, 0,    50, 50) ;
          fLine(50, 50,   200, 50) ;
          fLine(150, 0,   200, 50) ;

          fLine(40, 29,  49, 31.5) ;
          fLine(49, 31.5,   49, 21.5) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("lineWidth", 1.0) ;
          fArrow(40, 20,  40, 60) ;
          fArrow( 40, 20,   100, 30) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk( 40, 20,   3, 3, FILLED) ;
          fDisk(40+60*1.02, 20+10*1.02, 3, 3, FILLED) ;

          fTeXlabel(50, 17, "tc", "$(x_0,y_0,z_0)$") ;
          fTeXlabel(100, 34, "bc", "$(x,y,z)$") ;
          fTeXlabel(36, 60, "rc", "$\\vn$") ;
 
     }
}
