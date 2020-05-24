                  /*  File:  OE10D_10b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_10b extends Template {

     static {templateClass = new OE10D_10b() ; }

     public void setup() {
          filePrefix = "OE10D_10b" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -2 ;
          xmax = 2 ;
          ymin = -0.1 ;
          ymax = 2.3 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double a = 1 ;
          double h = 1 ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.07, ymax, "tr", "$y$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve(new bell(a, h) , xmin,xmax,OPEN)  ;
          fTeXlabel(0.7, 0.63, "bl", "$\\textcolor{blue}{D}$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new bellCurve(a, h) , xmin,xmax,OPEN)  ;
          fTeXlabel(0.2,1.8, "bl", "$\\textcolor{red}{C}$") ;
     }
}

class bell implements S2V {
     double a = 1.0 ;
     double h = 1.0 ;

   public bell(double a, double h) {
        this.a  = a ;
        this.h  = h ;
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          out[0] = t ;
          out[1] = h*Math.exp(-a*t*t) ;
          return out ;
   }
}


class bellCurve implements S2V {
     double a = 1.0 ;
     double h = 1.0 ;
     double fp = 1.0 ;
     double fpp = 1.0 ;
     double den ;

   public bellCurve(double a, double h) {
        this.a  = a ;
        this.h  = h ;
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          out[0] = t ;
          fp = -2*a*h*t*Math.exp(-a*t*t) ;
          den = (1+fp*fp)*Math.sqrt(1+fp*fp) ;
          fpp = Math.abs(4*a*a*h*h*t*t-2*a*h) * Math.exp(-a*t*t) ;
          out[1] = fpp / den ;
          return out ;
   }
}

