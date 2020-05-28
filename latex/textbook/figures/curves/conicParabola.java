                  /*  File:  conicParabola.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conicParabola extends Template {

     static {templateClass = new conicParabola() ; }

     public void setup() {
          filePrefix = "conicParabola" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 2.4*0.5 ;   // in inches
          xmin = -12 ;
          xmax = 14 ;
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
          
          double ell = 5 ;
          double r1 = 0.7 ; 


          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new conicPar(ell), ymin,ymax, OPEN)  ;
          fEnv("psFillColor", Red) ;
          fDisk(ell/2, 0, r1, r1, FILLED) ; 
          fTeXlabel(ell/2+0.2, +0.6, "bl", "$(\\ell/2,0)$") ;
          fDisk(0, -ell, r1, r1, FILLED) ; 
          fTeXlabel(0.4, -ell-0.4, "tl", "$(0,-\\ell)$") ;
         
     }
}

class conicPar implements S2V {

     double ell = 8.0 ;

   public conicPar(double ell) {
        this.ell = ell ;
   }


   public double[] map(double t) {          
        double[] out = {0,0} ;
        out[0] = (ell*ell-t*t)/(2*ell) ;
        out[1] = t ;
        return out ;
   }
}

