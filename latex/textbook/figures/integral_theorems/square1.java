                  /*  File:  square1.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square1 extends Template {

     static {templateClass = new square1() ; }

     public void setup() {
          filePrefix = "square1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -8 ;
          xmax = 8 ;
          ymin = -8 ;
          ymax = 8 ;
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

          x = 6 ; y = Math.pow(x, 1.5)/2.24 ;
          fEnv("psFillGray", 0.8) ;
          { double[] xlist = {0, x, x, 0} ;
            double[] ylist = {0, 0, y, y} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

          x = 5 ; y = Math.pow(x, 1.5)/2.24 ;
          fEnv("psFillGray", 0.6) ;
          { double[] xlist = {0, x, x, 0} ;
            double[] ylist = {0, 0, y, y} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

//          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fCurve("y=pow(x,3/2)/4.47", 0, 0.1, 8, OPEN) ;
          fCurve("y=pow(x,3/2)/2.24", 0, 0.1, 8, OPEN) ;
          fCurve("y=1.26*pow(x,3/2)", 0, 0.1, 8, OPEN) ;
          fCurve("y=-pow(x,3/2)/4.47", 0, 0.1, 8, OPEN) ;
          fCurve("y=-pow(x,3/2)/2.24", 0, 0.1, 8, OPEN) ;
          fCurve("y=-1.26*pow(x,3/2)", 0, 0.1, 8, OPEN) ;
          fCurve("y=-pow(-x,3/2)/4.47", 0, -8, -0.1, OPEN) ;
          fCurve("y=-pow(-x,3/2)/2.24", 0, -8, -0.1, OPEN) ;
          fCurve("y=-1.26*pow(-x,3/2)", 0, -8, -0.1, OPEN) ;
          fCurve("y=pow(-x,3/2)/4.47", 0, -8, -0.1, OPEN) ;
          fCurve("y=pow(-x,3/2)/2.24", 0, -8, -0.1, OPEN) ;
          fCurve("y=1.26*pow(-x,3/2)", 0, -8, -0.1, OPEN) ;


          
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          x = 5 ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          fArrow(x, -y, x+vx(x,-y), -y+vy(x,-y)) ;
          fArrow(-x, y, -x+vx(-x,y), y+vy(-x,y)) ;
          fArrow(-x, -y, -x+vx(-x,-y), -y+vy(-x,-y)) ;
          x = 5 ; y = Math.pow(x, 1.5)/4.47 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          fArrow(x, -y, x+vx(x,-y), -y+vy(x,-y)) ;
          fArrow(-x, y, -x+vx(-x,y), y+vy(-x,y)) ;
          fArrow(-x, -y, -x+vx(-x,-y), -y+vy(-x,-y)) ;
          x = 5 ; y = Math.pow(x, 1.5)/2.24 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          fArrow(x, -y, x+vx(x,-y), -y+vy(x,-y)) ;
          fArrow(-x, y, -x+vx(-x,y), y+vy(-x,y)) ;
          fArrow(-x, -y, -x+vx(-x,-y), -y+vy(-x,-y)) ;
          y = 5 ; x = Math.pow(y/1.26, 2.0/3.0) ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          fArrow(x, -y, x+vx(x,-y), -y+vy(x,-y)) ;
          fArrow(-x, y, -x+vx(-x,y), y+vy(-x,y)) ;
          fArrow(-x, -y, -x+vx(-x,-y), -y+vy(-x,-y)) ;
          y = 5 ; x = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          fArrow(x, -y, x+vx(x,-y), -y+vy(x,-y)) ;
          fArrow(-x, y, -x+vx(-x,y), y+vy(-x,y)) ;
          fArrow(-x, -y, -x+vx(-x,-y), -y+vy(-x,-y)) ;


          
     }

     public double vx(double x, double y) {
          return 2*x/6.0 ;
     }

     public double vy(double x, double y) {
          return 3*y/6.0 ;
     }

}
