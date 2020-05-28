                  /*  File:  astroid0a.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroid0a extends Template {

     static {templateClass = new astroid0a() ; }

     public void setup() {
          filePrefix = "astroid0a" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
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
          double th = 0 ;
          double phi = -3*th ;
          double a = 80 ;
          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, a, a, CLOSED) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(3*a*Math.cos(th)/4, 3*a*Math.sin(th)/4, a/4, a/4, CLOSED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, a*Math.cos(th), a*Math.sin(th)) ;
          double cx = 3*a*Math.cos(th)/4 ;
          double cy = 3*a*Math.sin(th)/4 ;
          double px = cx+a*Math.cos(phi)/4 ;
          double py = cy+a*Math.sin(phi)/4 ;
          fLine(cx, cy, px, py) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(px, py, 4, 4, FILLED) ;
          
          fTeXlabel(px+2, py-2, "tl", "$P$") ;

     }
}
