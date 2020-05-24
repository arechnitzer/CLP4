                  /*  File:  hyperboloidHole.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperboloidHole extends Template {

     static {templateClass = new hyperboloidHole() ; }

     public void setup() {
          filePrefix = "hyperboloidHole" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.0 ;      
          ysize = 2*150/120.0*1.0 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -60 ;
          ymax = 90 ;
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
          double r = 30 ;
          double h = 40 ;
          double y = h ;
          double a = 8 ;
          double L = 15 ;
          double x = 15*Math.sqrt(0.85) ;


          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;

          {  
             double[] xlist = {r-0.1,   r-0.1, -r+0.3, -r+0.3} ;
             double[] ylist = {h,  -h, -h,  h} ;
             fPolygon(xlist, ylist, 4, FILLED) ; 
          }
          fEnv("psFillGray", 1.0) ;
          fCurve("[15*sqrt(0.85 +3.15*t*t/1600 ) , t]", 1, -h, h, FILLED) ;
          fCurve("[-15*sqrt(0.85 +3.15*t*t/1600 ) , t]", 1, -h, h, FILLED) ;
          fDisk(0,0, a,a, FILLED) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;

          fCurve("[15*sqrt(0.85 +3.15*t*t/1600 ) , t]", 1, -h, h, OPEN) ;
          fCurve("[-15*sqrt(0.85 +3.15*t*t/1600 ) , t]", 1, -h, h, OPEN) ;
          fLine(-r,h, r,h) ;
          fLine(-r,-h, r,-h) ;
          fDisk(0,0, a,a, BOUNDARY) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(0,a, 0, a+L) ; 
          fArrow(x,0, x+L, 0) ; 
          fArrow(0,h, 0, h+L) ; 
          fArrow(0,-h, 0, -h-L) ; 

          fTeXlabel(0, -h/1.5, "cc", "$E_a$") ;
          fTeXlabel(0, -a-1, "tl", "$\\sigma_a$") ;
          fTeXlabel(0.7*x, -h-2, "tc", "$\\sigma$") ;
          fTeXlabel(1.5*x, -0.5*h, "lb", "$\\sigma$") ;
     }
}
