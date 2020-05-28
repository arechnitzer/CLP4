                  /*  File:  conicHyperbola.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conicHyperbola extends Template {

     static {templateClass = new conicHyperbola() ; }

     public void setup() {
          filePrefix = "conicHyperbola" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*0.5 ;      // in inches
          ysize = 2.4*0.5 ;   // in inches
          xmin = -6 ;
          xmax = 18 ;
          ymin = -12 ;
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
          
          double eps = 1.6 ;
          double ell = 5 ;
          double r1 = 0.7 ; 


          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new conicHyp(eps,ell,+1), ymin,ymax, OPEN)  ;
          fCurve(new conicHyp(eps,ell,-1), ymin,ymax, OPEN)  ;
          fEnv("psFillColor", Red) ;
//          fDisk(ell/2, 0, r1, r1, FILLED) ; 
//          fTeXlabel(ell/2+0.2, +0.6, "bl", "$(\\ell/2,0)$") ;
//          fDisk(0, -ell, r1, r1, FILLED) ; 
//          fTeXlabel(0.4, -ell-0.4, "tl", "$(0,-\\ell)$") ;
         
     }
}

class conicHyp implements S2V {

     double ell = 8.0 ;
     double eps = 2.0 ;
     double sgn = +1 ;
     double a = ell/(eps*eps-1);
     double b = ell/Math.sqrt(eps*eps-1);
     double c = eps*ell/(eps*eps-1);

   public conicHyp(double eps, double ell, double sgn) {
        this.eps = eps ;
        this.ell = ell ;
        this.sgn = sgn ;
        a = ell/(eps*eps-1);
        b = ell/Math.sqrt(eps*eps-1);
        c = eps*ell/(eps*eps-1);
   }


   public double[] map(double t) {          
        double[] out = {0,0} ;
        out[0] = c+sgn*a*Math.sqrt(1+t*t/b/b) ;
        out[1] = t ;
        return out ;
   }
}

