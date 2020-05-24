                  /*  File:  square8.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square8 extends Template {

     static {templateClass = new square8() ; }

     public void setup() {
          filePrefix = "square8" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5;   // in inches. 
          xmin = -0.1 ;
          xmax = 2.5 ;
          ymin = -1.3 ;
          ymax = 1.3 ;
          topmargin = 0.1 ;   // in inches
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
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          double x,y ;
          double t = 0.4 ;
          double n = 10 ;
          double dt = t/n ;


// full flow

          double x1 = 1 ;
          double y1 = 1 ;
          double x2 = 1 ;
          double y2 = -1 ;

          double x3 = x1+2*t*y1 ;
          double y3 = y1 ;
          double x4 = x2+2*t*y2 ;
          double y4 = y2 ;

          fEnv("psFillGray", 0.6) ;

          { double[] xlist = {0, x3, x3+x4, x4} ;
            double[] ylist = {0, y3, y3+y4, y4} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }


// Lie product approximation
          
          double cht = (Math.exp(dt)+Math.exp(-dt))/2.0 ;
          double sht = (Math.exp(dt)-Math.exp(-dt))/2.0 ;
          double ct = Math.cos(dt) ;
          double st = Math.sin(dt) ;

          double x5 = x1 ;
          double y5 = y1 ;
          double x6 = x2 ;
          double y6 = y2 ;

          for (int i = 1; i <= n ; i++ ) {
               x3 = cht*x5+sht*y5 ;
               y3 = sht*x5+cht*y5 ;
               x4 = cht*x6+sht*y6 ;
               y4 = sht*x6+cht*y6 ;

               x5 = ct*x3+st*y3 ;
               y5 = -st*x3+ct*y3 ;
               x6 = ct*x4+st*y4 ;
               y6 = -st*x4+ct*y4 ;
          }

          fEnv("lineWidth", 1.5) ;
          { double[] xlist = {0, x5, x5+x6, x6} ;
            double[] ylist = {0, y5, y5+y6, y6} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }

          fTeXlabel((xmin+xmax)/2, ymin, "ct", "$n=10$") ;

     }
}
