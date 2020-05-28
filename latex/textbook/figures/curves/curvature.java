                  /*  File:  curvature.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curvature extends Template {

     static {templateClass = new curvature() ; }

     public void setup() {
          filePrefix = "curvature" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;   
          ysize = 2 ;   
          xmin = -2  ;
          xmax = 3 ;
          ymin = -2 ;
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
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(x + Nx/ka , y +Ny/ka , 1/ka, aspect/ka, CLOSED) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double th = Math.atan(Ny/Nx) + Math.PI ;
          double dth = 0.3 ;

          double x1 = Math.cos(th+dth)/ka ; double y1 = Math.sin(th+dth)/ka ; 
          fLine(xc, yc, xc+x1, yc+y1) ;

          double x2 = Math.cos(th-dth)/ka ; double y2 = Math.sin(th-dth)/ka ; 
          fLine(xc, yc, xc+x2, yc+y2) ;

          double x3 = 0.35*Math.cos(th)/ka ; double y3 = 0.35*Math.sin(th)/ka ; 
          fTeXlabel(xc+x3,yc+y3, "cc", "$\\dee{\\theta$}") ;
          fEllipticalArc(xc, yc, 0.23/ka, 0.23/ka, 
                       (th-dth)*180/Math.PI,(th+dth)*180/Math.PI, OPEN) ;

//          double x4 = 0.25*Math.cos(th-3*dth)/ka ; double y4 = 0.25*Math.sin(th-3*dth)/ka; 
//          fTeXlabel(xc+x4,yc+y4, "cc", "$\\theta$") ;
//          fLine(xc, yc, xc+0.3/ka, yc) ;
//          fEllipticalArc(xc, yc, 0.15/ka, 0.15/ka, 0, (th-dth)*180/Math.PI, OPEN) ;

          double x5 = 0.5*Math.cos(th+1.6*dth)/ka; 
          double y5 = 0.5*Math.sin(th+1.6*dth)/ka; 
          fTeXlabel(xc+x5,yc+y5, "cc", "$\\rho$") ;

          double x6 = 1.2*Math.cos(th)/ka; 
          double y6 = 1.2*Math.sin(th)/ka; 
          fTeXlabel(xc+x6,yc+y6, "cc", "$ds$") ;
          fEllipticalArc(xc, yc, 1.07/ka, 1.07/ka,
                       (th-dth)*180/Math.PI,(th+dth)*180/Math.PI, OPEN) ;

          fEnv("psFillColor", Red) ;
          double r = 0.1 ;
//          fDisk(x , y  , r, r*aspect, FILLED) ;
          fDisk(xc , yc , r, r*aspect, FILLED) ;


     }
}
