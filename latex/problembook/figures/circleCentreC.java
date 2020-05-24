                  /*  File:  circleCentreC.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class circleCentreC extends Template {

     static {templateClass = new circleCentreC() ; }

     public void setup() {
          filePrefix = "circleCentreC" ;
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

          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fEnv("lineWidth", 2.0) ;
          fCurve("y = atan(x)", 0, xmin, xmax, OPEN) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;

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
          fTeXlabel(x+0.4,y+0.2, "br", "$\\vr(t_0)$") ;

          fEnv("psFillColor", Red) ;
          fDisk(xc , yc , r, r*aspect, FILLED) ;
          fTeXlabel(xc+0.1,yc-0.1, "tl", "$\\vc$") ;

          fEnv("psFillColor", Black) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrow(x,y, x + 1.5*Nx, y + 1.5*Ny) ;
          fTeXlabel(x+1.5*Nx-0.1, y+1.5*Ny+0.1, "tr", "$\\hat\\vN$") ;

          fArrow(x, y, x-1.5*Tx, y-1.5*Ty) ;
          fTeXlabel(x-1.5*Tx+0.1, y-1.5*Ty+0.2, "br", "$\\hat\\vT$") ;



     }
}
