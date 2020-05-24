                  /*  File:  fline.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fline extends Template {

     static {templateClass = new fline() ; }

     public void setup() {
          filePrefix = "fline" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2 ;
          xmax = 2 ;
          ymin = -10 ;
          ymax = 10 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.0) ;

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          int n = 5;
          double x, y ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=x*x*x", 0, xmin, xmax, OPEN) ;
          fCurve("y=3*x*x*x", 0, xmin, xmax, OPEN) ;
          fCurve("y=12*x*x*x", 0, xmin, xmax, OPEN) ;
          fCurve("y=-3*x*x*x", 0, xmin, xmax, OPEN) ;
          fCurve("y=-12*x*x*x", 0, xmin, xmax, OPEN) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          x = -1.6 ;
          double s = 0.2 ;
          fEnv("lineWidth", 0.5) ;
          for (int i = 0 ; i< n; i++) {
               fArrow(x, -5, x+vx(x,-5)*s, -5+vy(x,-5)*s) ;
               fArrow(x, 0, x+vx(x,0)*s, 0+vy(x,0)*s) ;
               fArrow(x, 5, x+vx(x,5)*s, 5+vy(x,5)*s) ;
               x += 0.8 ;
          }

          
     }

     public double vx(double x, double y) {
          return x ;
     }

     public double vy(double x, double y) {
          return 3*y ;
     }

}
