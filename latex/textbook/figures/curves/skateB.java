                  /*  File:  skateB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class skateB extends Template {

     static {templateClass = new skateB() ; }

     public void setup() {
          filePrefix = "skateB" ;    // used as the prefix for any ps, lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0;      // in inches
          ysize = 1.0 ;   // in inches
          xmin = -10 ;
          xmax = 10 ;
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
          fEnv("lineWidth", 1.0) ;
          double A = 9.0 ; 
          double a = 8.3 ;
          double th = 50 ; double thRad = th*Math.PI/180 ;
          double X = a*Math.cos(thRad) ; double Y = a*Math.sin(thRad) ;
              double Yp = -X/Y ;   double Ypp = -(1+Yp*Yp)/Y ;
              double AA = Ypp/2 ;  double BB = Yp-2*AA*X ; double CC = Y-AA*X*X-BB*X ;
          double XF = X-10 ; double YF = AA*XF*XF +BB*XF +CC ; 
          double phi = Math.atan(2*AA*XF+BB)*180/Math.PI ; 
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(0,0, A,A, CLOSED) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, a, a, -90, th, OPEN) ;
          fCurve(new skatePara(AA, BB,  CC),X,X-10,OPEN)  ;
          fEnv("arrowHeadColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("psFillColor", Blue) ;
          fArrowhead(XF,YF, phi+180) ;
          fTeXlabel(0, -A-3.5, "bc", "unhappy") ;

//          double r = 1 ;
//          fEnv("psFillColor", Blue) ;
//          fDisk(X , Y  , r, r, FILLED) ;


          
     }
}


class skatePara implements S2V {

     double AA = 1 ;
     double BB = 1 ;
     double CC = 1 ;

   public skatePara(double AA, double BB, double CC) { 
        this.AA = AA ;
        this.BB = BB ;
        this.CC = CC ;
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          out[0] = t ;
          out[1] = AA*t*t +BB*t +CC ;
          return out ;
   }
}
