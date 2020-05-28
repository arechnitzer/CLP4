                  /*  File:  conic.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conic extends Template {

     static {templateClass = new conic() ; }

     public void setup() {
          filePrefix = "conic" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*0.8 ;      // in inches
          ysize = 2.4*0.8 ;   // in inches
          xmin = -5 ;
          xmax = 10 ;
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
          
          double ell = 8 ;
          double eps = 0.4 ;
          double r1 = 0.5 ; 
          double r2 = 2.0 ; 
          double th = 1.0 ; double thDeg = th*180/Math.PI ;
          double r = ell/(1+eps*Math.cos(th)) ;
              double x = r*Math.cos(th) ;
              double y = r*Math.sin(th) ;
          fLine(0,0, x, y) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(x+r1,y, ell-r1, y) ;
          fArrow(ell-r1,y, x+r1, y) ;
          fArrow(0,-1.7*y, ell, -1.7*y) ;
          fArrow(ell,-1.7*y, 0, -1.7*y) ;
          fEllipticalArc(0,0, r2, r2, 0, thDeg, OPEN) ;
          fTeXlabel(1.1*r2, 0.8, "bl", "$\\theta$") ;
          fTeXlabel(0.45*x-0.5, 0.45*y+0.7, "bl", "$r$") ;
          fTeXlabel(-0.5, -0.5, "tr", "$F$") ;
          fTeXlabel(x, y+0.5, "bl", "$P$") ;
          fTeXlabel(ell+0.4, ymax, "tl", "$L$") ;
          fTeXlabel(ell/2, -1.7*y-0.5, "tc", "$p$") ;


          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fLine(ell, ymin, ell, ymax) ;
          fDisk(0, 0, r1, r1, FILLED) ; 
          fDisk(ell, y, r1, r1, FILLED) ; 
          fTeXlabel(ell+0.5, y+0.5, "bl", "$Q$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fCurve(new conicRad(eps,ell), -2,2,OPEN)  ;
          fDisk(x, y, r1, r1, FILLED) ;           
          
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
        double r = ell/(1+eps*Math.cos(t)) ;
        out[0] = r*Math.cos(t) ;
        out[1] = r*Math.sin(t) ;
        return out ;
   }
}

