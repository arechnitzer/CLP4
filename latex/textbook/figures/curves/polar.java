                  /*  File:  polar.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar extends Template {

     static {templateClass = new polar() ; }

     public void setup() {
          filePrefix = "polar" ;    // used as the prefix for any ps, lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*1.3;      // in inches
          ysize = 2.0*1.3 ;   // in inches
          xmin = -15 ;
          xmax = 15 ;
          ymin = -15 ;
          ymax = 15 ;
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
          double a = 7.0 ; 
          double r1 = 2.0 ; double r2 = 0.8 ; double r3 = 0.5 ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(a,a, r1, r1, 0, 45, OPEN) ;
          fLine(a+r2, a+r2, a, a+2*r2) ;
          fLine(a-r2, a+r2, a, a+2*r2) ;
          fLine(a,a, a+6, a) ;
          fTeXlabel(a+2.8,a+0.5, "bc", "$\\theta$") ;
          fEllipticalArc(0,0, r1, r1, 0, 45, OPEN) ;
          fLine(0,0, 6, 0) ;
          fTeXlabel(2.8, 0.5, "bc", "$\\theta$") ;
          fTeXlabel(0.6*a-0.3, 0.6*a+0.3, "cr", "$r$") ;
          fDisk(0,0, r3,r3, FILLED) ;
          fTeXlabel(-0.5,-0.5, "tr", "$(0,0)$") ;
          double L = 5.0*Math.sqrt(2) ;
          fArrow(0,0, L, 0) ;
          fTeXlabel(L+0.5,0.0, "cl", "$\\hi$") ;
          fArrow(0,0, 0, L) ;
          fTeXlabel(-0.5,L, "cr", "$\\hj$") ;



          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0,0, a,a) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 1.5) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          fArrow(a,a, a+5, a+5) ;
          fArrow(a,a, a-5, a+5) ;
          fTeXlabel(a+5+0.4,a+5+0.2, "cl", "$\\hat\\vr$") ;
          fTeXlabel(a-5-0.4,a+5+0.2, "cr", "$\\hat\\vth$") ;
          fEnv("psFillColor", Red) ;
          fDisk(a,a, r3,r3, FILLED) ;


          
     }
}
