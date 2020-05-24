                  /*  File:  VFg.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFg extends Template {

     static {templateClass = new VFg() ; }

     public void setup() {
          filePrefix = "VFg" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;      // in inches
          ysize = 1.8 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -8 ;
          xmax = 8 ;
          ymin = -4 ;
          ymax = 4 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.2 ;   // in inches
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
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          int n = 5;
          double x, y ;
          
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.0) ;
          fEnv("headLength", 6.0*1.0) ;

          x = -2 ;
          for (int i = 0 ; i< n; i++) {
               fArrow(x, -3, x+vx(x,-3), -3+vy(x,-3)) ;
               fArrow(x, 0, x+vx(x,0), 0+vy(x,0)) ;
               fArrow(x, 3, x+vx(x,3), 3+vy(x,3)) ;
               x += 1 ;
          }

//          fEnv("lineWidth", 0.5) ;
//          fCurve("y=-ln(x)/2+3", 0, 0.1, 8, OPEN) ;
//          fCurve("y=-ln(x)/2+0.5*ln(2)", 0, 0.1, 8, OPEN) ;
//          fCurve("y=-ln(x)/2+0.5*ln(2)-3", 0, 0.1, 8, OPEN) ;
//          fCurve("y=-ln(-x)/2+3", 0, -8, -0.1, OPEN) ;
//          fCurve("y=-ln(-x)/2+0.5*ln(2)", 0, -8, -0.1, OPEN) ;
//          fCurve("y=-ln(-x)/2+0.5*ln(2)-3", 0, -8, -0.1, OPEN) ;

          
     }

     public double vx(double x, double y) {
          return 2*x ;
     }

     public double vy(double x, double y) {
          return -1 ;
     }

}
