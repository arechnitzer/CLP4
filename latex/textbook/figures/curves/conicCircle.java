                  /*  File:  conicCircle.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conicCircle extends Template {

     static {templateClass = new conicCircle() ; }

     public void setup() {
          filePrefix = "conicCircle" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*0.5 ;      // in inches
          ysize = 2.4*0.5 ;   // in inches
          xmin = -10 ;
          xmax = 12 ;
          ymin = -10 ;
          ymax = 12 ;
          topmargin = -0.1 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fTeXlabel(xmax, -0.5, "tr", "$x$") ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.3, ymax, "tr", "$y$") ;
          
          double ell = 8 ;
          double eps = 0.0 ;
          double th = 1.0 ; double thDeg = th*180/Math.PI ;
          double r = ell ;
              double x = r*Math.cos(th) ;
              double y = r*Math.sin(th) ;
          fLine(0,0, x, y) ;
          fTeXlabel(0.45*x-0.5, 0.45*y+0.7, "bl", "$\\ell$") ;


          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new conicRad(0,ell), -Math.PI,Math.PI,OPEN)  ;
          
     }
}

class conicRad implements S2V {

     double eps = 1.0 ;
     double ell = 8.0 ;

   public conicRad(double eps, double ell) {
        this.eps = eps ;
        this.ell = ell ;
   }


   public double[] map(double t) {          
        double[] out = {0,0} ;
        double r = ell ;
        out[0] = r*Math.cos(t) ;
        out[1] = r*Math.sin(t) ;
        return out ;
   }
}

