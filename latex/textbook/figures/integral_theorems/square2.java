                  /*  File:  square2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square2 extends Template {

     static {templateClass = new square2() ; }

     public void setup() {
          filePrefix = "square2" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -10 ;
          xmax = 10 ;
          ymin = -10 ;
          ymax = 10 ;
          topmargin = 0.1 ;   // in inches
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          double x, y ;

          x = 6.36 ; y = 6.36 ;
          fEnv("lineWidth", 1.5) ;
            
          double th = Math.PI/15 ;
          double ix = 6.36*Math.cos(th) ;
          double iy = 6.36*Math.sin(th) ;
          double jx = -6.36*Math.sin(th) ;
          double jy = 6.36*Math.cos(th) ;

          fEnv("psFillGray", 0.6) ;
          { double[] xlist = {0, ix, ix+jx, jx} ;
            double[] ylist = {0, iy, iy+jy, jy} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

          { double[] xlist = {0, x, x, 0} ;
            double[] ylist = {0, 0, y, y} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }

          fEnv("lineWidth", 0.5) ;
          fCurve("[3.72*cos(t), 3.72*sin(t)]", 1, 0, 2*Math.PI, CLOSED) ;
          fCurve("[6.36*cos(t), 6.36*sin(t)]", 1, 0, 2*Math.PI, CLOSED) ;
          fCurve("[9*cos(t), 9*sin(t)]", 1, 0, 2*Math.PI, CLOSED) ;



          
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          x = 3.72 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 6.36 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 9 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = -3.72 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = -6.36 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = -9 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = 3.72 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = 6.36 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = 9 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = -3.72 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = -6.36 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = -9 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;


          
     }

     public double vx(double x, double y) {
          return -y/2 ;
     }

     public double vy(double x, double y) {
          return x/2 ;
     }

}
