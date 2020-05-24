                  /*  File:  curvatureDef.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curvatureDef extends Template {

     static {templateClass = new curvatureDef() ; }

     public void setup() {
          filePrefix = "curvatureDef" ;
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

          double x1 = Math.cos(th)/ka ; double y1 = Math.sin(th)/ka ; 
          fLine(xc, yc, xc+x1, yc+y1) ;

          double x5 = 0.5*Math.cos(th+0.2)/ka; 
          double y5 = 0.5*Math.sin(th+0.2)/ka; 
          fTeXlabel(xc+x5,yc+y5, "cc", "$\\rho$") ;


          double r = 0.1 ;
          fDisk(x , y  , r, r*aspect, FILLED) ;
          fTeXlabel(x-0.07,y+0.07, "br", "$P$") ;
          fEnv("psFillColor", Red) ;
          fDisk(xc , yc , r, r*aspect, FILLED) ;
          fTeXlabel(xc+0.2,yc, "cl", "$C$") ;


     }
}
