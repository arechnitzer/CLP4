                  /*  File:  VFf.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFf extends Template {

     static {templateClass = new VFf() ; }

     public void setup() {
          filePrefix = "VFf" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.2*0.6 ;      // in inches
          ysize = 3.2*0.6 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -150 ;
          xmax = 170 ;
          ymin = -150 ;
          ymax = 170 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;
          int n = 12;
          double th = 0 ;
          double dth = 2*Math.PI/n ;
          double x, y ;
          
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.0) ;
          fEnv("headLength", 6.0*1.0) ;

          for (int i = 0 ; i< n; i++) {
               x = 30*Math.cos(th) ;
               y = 30*Math.sin(th) ;
               fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
               x = 70*Math.cos(th) ;
               y = 70*Math.sin(th) ;
               fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
               th += dth ;
          }

          
     }

     public double vx(double x, double y) {
          return 0.9*x ;
     }

     public double vy(double x, double y) {
          return 0.9*y ;
     }

}
