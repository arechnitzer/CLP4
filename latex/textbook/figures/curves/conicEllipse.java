                  /*  File:  conicEllipse.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conicEllipse extends Template {

     static {templateClass = new conicEllipse() ; }

     public void setup() {
          filePrefix = "conicEllipse" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*0.5 ;      // in inches
          ysize = 2.0*0.5 ;   // in inches
          xmin = -12 ;
          xmax = 12 ;
          ymin = -10 ;
          ymax = 10 ;
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
          
          double rm = 6 ;
          double rM = 8 ;
          double r1 = 0.7 ; 


          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new conicEll(rm,rM), -Math.PI,Math.PI,OPEN)  ;
          fEnv("psFillColor", Red) ;
          fDisk(-rM, 0, r1, r1, FILLED) ; 
          fTeXlabel(-rM-0.2, -0.4, "tr", "$(-r_M,0)$") ;
          fDisk(0, -rm, r1, r1, FILLED) ; 
          fTeXlabel(0.4, -rm-0.4, "tl", "$(0,-r_m)$") ;
          
     }
}

class conicEll implements S2V {

     double rM = 8.0 ;
     double rm = 6.0 ;

   public conicEll(double rm, double rM) {
        this.rm = rm ;
        this.rM = rM ;
   }


   public double[] map(double t) {          
        double[] out = {0,0} ;
        out[0] = rM*Math.cos(t) ;
        out[1] = rm*Math.sin(t) ;
        return out ;
   }
}

