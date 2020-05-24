                  /*  File:  curvatureB2.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curvatureB2 extends Template {

     static {templateClass = new curvatureB2() ; }

     public void setup() {
          filePrefix = "curvatureB2" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;   
          ysize = 2 ;   
          xmin = -3  ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 3 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {

          fEnv("lineWidth", 2.0) ;
          fCurve("y = atan(x)", 0, xmin, xmax, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double x = 0.8 ; double y = Math.atan(x) ;
//   y = atan(x)
//   y' = 1/(1+x^2)
//   y'' = -2*x/(1+x^2)^2
          double yp = 1/(1+x*x) ; double yps = Math.sqrt(1+yp*yp) ;
          double Tx = 1/yps ; double Ty = yp/yps ;
          double Nx = Ty ; double Ny = -Tx ;
          double ypp = -2*x/(1+x*x)/(1+x*x) ; 
          double ka = -ypp/yps/yps/yps ;
          double xc = x + Nx/ka ; double yc = y +Ny/ka ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(xc , yc , 1/ka, aspect/ka, CLOSED) ;
          double r = 0.15 ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;

          fLine(x, y, xc, yc) ;

          fEnv("psFillColor", Blue) ;
          fDisk(x , y  , r, r*aspect, FILLED) ;

          fEnv("psFillColor", Red) ;
          fDisk(xc , yc , r, r*aspect, FILLED) ;



     }
}
