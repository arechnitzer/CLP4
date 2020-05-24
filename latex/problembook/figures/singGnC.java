                  /*  File:  singGnC.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class singGnC extends Template {

     static {templateClass = new singGnC() ; }

     public void setup() {
          filePrefix = "singGnC" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;   
          ysize = 1.8 ;   
          xmin = -1.5 ;
          xmax = 1.5;
          ymin = -1.5 ;
          ymax = 1.5;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          double a = 0.3 ;



          fEnv("psFillGray", 0.8) ;
          { double[] xlist = {-1, -1, 1, 1} ;
            double[] ylist = {-1, 1, 1, -1} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, a, a, FILLED) ;
          fEnv("psFillColor", Blue) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          { double[] xlist = {-1, -1, 1, 1} ;
            double[] ylist = {-1, 1, 1, -1} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }
          fDisk(0,0, a, a, CLOSED) ;

          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;

          fArrowhead(1, 0.5,90) ;
          fTeXlabel(1.1, 0.5, "cl", "$C_b$") ;
          double t = Math.PI/4 ;
          double x = a*Math.cos(t) ;
          double y = a*Math.sin(t) ;
          fArrowhead(x,y,t*180/Math.PI-90) ;
          fTeXlabel(0.6*x, 1.2*y, "bl", "$-C_a$") ;
          fTeXlabel(-0.6, 0.6 , "cc", "$R$") ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;




     }
}
