                  /*  File:  square.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class square extends Template {

     static {templateClass = new square() ; }

     public void setup() {
          filePrefix = "square" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.8 ;      // in inches
          ysize = 0.8 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.1 ;
          ymin = -0.1 ;
          ymax = 1.1 ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          { double[] xlist = {0, 0, 1, 1} ;
            double[] ylist = {0, 1, 1, 0} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }
          fArrow(0.5, 0, 0.6, 0) ;
          fArrow(1, 0.5, 1, 0.6) ;
          fArrow(0.5, 1, 0.4, 1) ;
          fArrow(0, 0.5, 0, 0.4) ;
          fTeXlabel(0,0,"tr","$(0,0)$") ;
          fTeXlabel(1,0,"tl","$(1,0)$") ;
          fTeXlabel(0,1,"br","$(0,1)$") ;
          fTeXlabel(1,1,"bl","$(1,1)$") ;
          fTeXlabel(1.1, 0.5, "lc", "$\\Atop{\\dee{x} =0}{x=1}$") ;
          fTeXlabel(-0.1, 0.5, "rc", "$\\Atop{\\dee{x} =0}{x=0}$") ;
          fTeXlabel(0.5, -0.1, "tc", "$\\Atop{\\dee{y} =0}{y=0}$") ;
          fTeXlabel(0.5, 1.1, "bc", "$\\Atop{\\dee{y} =0}{y=1}$") ;
     }
}
