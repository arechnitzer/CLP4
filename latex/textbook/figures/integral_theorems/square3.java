                  /*  File:  square3.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square3 extends Template {

     static {templateClass = new square3() ; }

     public void setup() {
          filePrefix = "square3" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -1.7 ;
          xmax = 2.7 ;
          ymin = -2.2 ;
          ymax = 2.2 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          double x,y ;
          double t = 0.4 ;

          double x1 = 1 ;
          double y1 = 1 ;
          double x2 = 1 ;
          double y2 = -1 ;

          fLine(xmin, y1, xmax, y1) ;
          fLine(xmin, y2, xmax, y2) ;
          
          double x3 = x1+2*t*y1 ;
          double y3 = y1 ;
          double x4 = x2+2*t*y2 ;
          double y4 = y2 ;



          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.6) ;

          { double[] xlist = {0, x3, x3+x4, x4} ;
            double[] ylist = {0, y3, y3+y4, y4} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

          { double[] xlist = {0, x1, x1+x2, x2} ;
            double[] ylist = {0, y1, y1+y2, y2} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }


          
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          x = 0 ; y = y1 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = y2 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          
          fTeXlabel((xmin+xmax)/2, ymin, "ct", "$\\ha{k}$ and $e^{0.4\\cV}\\ha{k}$") ;

          
     }

     public double vx(double x, double y) {
          return 2*y/3 ;
     }

     public double vy(double x, double y) {
          return 0 ;
     }

}
