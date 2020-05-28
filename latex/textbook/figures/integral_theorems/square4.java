                  /*  File:  square4.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square4 extends Template {

     static {templateClass = new square4() ; }

     public void setup() {
          filePrefix = "square4" ;    // used as the prefix for any ps or lbl files written
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

          fLine(xmin, xmin, ymax, ymax) ;
          fLine(xmin, -xmin, ymax, -ymax) ;
          
          double ct = (Math.exp(t)+Math.exp(-t))/2.0 ;
          double st = (Math.exp(t)-Math.exp(-t))/2.0 ;
          double x3 = ct*x1+st*y1 ;
          double y3 = st*x1+ct*y1 ;
          double x4 = ct*x2+st*y2 ;
          double y4 = st*x2+ct*y2 ;



          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.8) ;

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
          x = x1 ; y = y1 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = x2 ; y = y2 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = -x1 ; y = -y1 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = -x2 ; y = -y2 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;

          
          fTeXlabel((xmin+xmax)/2, 1.1*ymin, "ct", "$\\ha{k}$ and $e^{0.4S}\\ha{k}$") ;

          
     }

     public double vx(double x, double y) {
          return y/2 ;
     }

     public double vy(double x, double y) {
          return x/2 ;
     }

}
