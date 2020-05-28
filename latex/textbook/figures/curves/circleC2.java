                  /*  File:  circleC2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class circleC2 extends Template {

     static {templateClass = new circleC2() ; }

     public void setup() {
          filePrefix = "circleC2" ;    // used as the prefix for any ps, lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0;      // in inches
          ysize = 2.0 ;   // in inches
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
          double a = 7.0 ; double phi = Math.PI/4 ; 
          double x = a*Math.sin(phi) ; double y = -a*Math.cos(phi) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(0,0, a,a, CLOSED) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, -a, xmax, -a) ;
          fLine(0,-a,  0,a+1) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          fArrow(x,y, 0, 0) ;
          fLine(x,y, 0,y) ;
          fLine(0,0, 0,y) ;
          fTeXlabel(-0.3,y/2, "cr", "$a-y$") ;
          fTeXlabel(x/2+0.3,y/2, "bl", "$a\\hat\\vN$") ;
          fTeXlabel(0.3,y/2+0.2, "cl", "$\\phi$") ;
          double r =0.3 ;
          fDisk(x,y, r,r, FILLED) ;
          fTeXlabel(x+0.5,y-0.2, "cl", "$(x,y)$") ;

          
     }
}
