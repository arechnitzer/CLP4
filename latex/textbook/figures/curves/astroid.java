                  /*  File:  astroid.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroid extends Template {

     static {templateClass = new astroid() ; }

     public void setup() {
          filePrefix = "astroid" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;      // in inches
          ysize = 3.0 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double th = Math.PI/7 ;
          double phi = -3*th ;
          double a = 80 ;
          double r = 3 ;
          double R = 30 ;
          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, a, a, CLOSED) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(3*a*Math.cos(th)/4, 3*a*Math.sin(th)/4, a/4, a/4, CLOSED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, a*Math.cos(th), a*Math.sin(th)) ;
          fLine(0, 0, a/3, 0) ;
          fEllipticalArc(0, 0, a/5, a/5, 0, th*180/Math.PI, OPEN) ;
          double cx = 3*a*Math.cos(th)/4 ;
          double cy = 3*a*Math.sin(th)/4 ;
          double px = cx+a*Math.cos(phi)/4 ;
          double py = cy+a*Math.sin(phi)/4 ;
          fLine(cx, cy, px, py) ;
          fLine(cx, cy, cx+a/5, cy) ;
          fArrow(0, 0, R, 0) ;
          fTeXlabel(R+2, 0, "cl", "$\\hi$") ;
          fArrow(0, 0, 0, R) ;
          fTeXlabel(-2, R, "cr", "$\\hj$") ;
          fEllipticalArc(cx, cy, a/12, a/12, phi*180/Math.PI, 0, OPEN) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(px, py, r, r, FILLED) ;
          r = 2.5 ;
          fDisk(0, 0, r, r, FILLED) ;
          fDisk(cx, cy, r, r, FILLED) ;

          
          fTeXlabel(-2, -2, "tr", "$O$") ;
          fTeXlabel(px+2, py-2, "tl", "$P$") ;
          fTeXlabel(cx-2, cy+2, "br", "$Q$") ;
          fTeXlabel(a/5+5, 1.75, "bl", "$\\theta$") ;
          fTeXlabel(cx+a/12-1.5, cy-3, "tl", "$\\phi$") ;

     }
}
