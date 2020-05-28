                  /*  File:  fluidcube.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fluidcube extends Template {

     static {templateClass = new fluidcube() ; }

     public void setup() {
          filePrefix = "fluidcube" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5*1.0 ;      // in inches
          ysize = 2*1.0 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -250 ;
          xmax = 250 ;
          ymin = -100 ;
          ymax = 100 ;
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
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          double d = 20 ;
          double Y = 80 ; 
          double X = 250 ;
          double a = 30 ;
          { double[] xlist = { -X, -X, X, X} ;
            double[] ylist = {  Y,   -Y, -Y,  Y} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("psFillGray", 0.5) ;
          { double[] xlist = { -d, -d, d, d} ;
            double[] ylist = {  d,   -d, -d,  d} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }
//         fEnv("lineWidth", 1.0) ;
         fEnv("headLength", 6.0*1.2) ;
         fEnv("headHalfWidth", 2.0*1.2) ;
         fArrow(0, d+a, 0, d) ;
         fArrow(0,-d-a, 0, -d) ;
         fArrow(d+a, 0, d, 0) ;
         fArrow(-d-a, 0, -d, 0) ;
         fTeXlabel(0, d+a+2, "bc", 
              "$-P(x,y,z+\\frac{\\dee{z}}{2})\\,\\dee{x}\\dee{y}\\,\\hk$") ;
         fTeXlabel(0, -d-a-1, "tc", 
              "$P(x,y,z-\\frac{\\dee{z}}{2})\\,\\dee{x}\\dee{y}\\,\\hk$") ;
         fTeXlabel(d+a+3, 0, "lc", 
              "$-P(x,y+\\frac{\\dee{y}}{2},z)\\,\\dee{x}\\dee{z}\\,\\hj$") ;
         fTeXlabel(-d-a-2, 0, "rc", 
              "$P(x,y-\\frac{\\dee{y}}{2},z)\\,\\dee{x}\\dee{z}\\,\\hj$") ;
          
     }
}
