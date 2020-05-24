                  /*  File:  square5.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square5 extends Template {

     static {templateClass = new square5() ; }

     public void setup() {
          filePrefix = "square5" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*4.9/4.4 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -2.2 ;
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

          
          double cht = (Math.exp(t)+Math.exp(-t))/2.0 ;
          double sht = (Math.exp(t)-Math.exp(-t))/2.0 ;
          double x3 = cht*x1+sht*y1 ;
          double y3 = sht*x1+cht*y1 ;
          double x4 = cht*x2+sht*y2 ;
          double y4 = sht*x2+cht*y2 ;

          fEnv("psFillGray", 0.8) ;
          { double[] xlist = {0, x3, x3+x4, x4} ;
            double[] ylist = {0, y3, y3+y4, y4} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }


          
          double ct = Math.cos(t) ;
          double st = Math.sin(t) ;
          double x5 = ct*x3+st*y3 ;
          double y5 = -st*x3+ct*y3 ;
          double x6 = ct*x4+st*y4 ;
          double y6 = -st*x4+ct*y4 ;

          fEnv("psFillGray", 0.6) ;
          { double[] xlist = {0, x5, x5+x6, x6} ;
            double[] ylist = {0, y5, y5+y6, y6} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

          double r = Math.sqrt(x3*x3+y3*y3) ;

          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, r, r, BOUNDARY ) ;

          
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          x = 0 ; y = r ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = r ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = 0 ; y = -r ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;
          x = -r ; y = 0 ;
          fArrow(x, y, x+vx(x,y), y+vy(x,y)) ;

          
          fTeXlabel((xmin+xmax)/2, 1.1*ymin, "ct", "$e^{0.4S}\\ha{k}$ and $e^{0.4A}e^{0.4S}\\ha{k}$") ;

          
     }

     public double vx(double x, double y) {
          return y/2 ;
     }

     public double vy(double x, double y) {
          return -x/2 ;
     }

}
