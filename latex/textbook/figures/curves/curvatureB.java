                  /*  File:  curvatureB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curvatureB extends Template {

     static {templateClass = new curvatureB() ; }

     public void setup() {
          filePrefix = "curvatureB" ;
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
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(xc , yc , 1/ka, aspect/ka, CLOSED) ;
          fEnv("psFillColor", Red) ;
          double r = 0.1 ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double th = Math.atan(Ny/Nx) + Math.PI;
          double dth = 0.3 ;

          double x2 = Math.cos(th)/ka ; double y2 = Math.sin(th)/ka ; 
          double x22 = 1.4*Math.cos(th)/ka ; double y22 = 1.4*Math.sin(th)/ka ; 
          fLine(xc, yc, xc+x22, yc+y22) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrow(x, y, x-1.5*Tx, y-1.5*Ty) ;
          fTeXlabel(x-1.5*Tx+0.1, y-1.5*Ty+0.2, "br", "$\\hat\\vT$") ;

          double x3 = 0.25*Math.cos(th/2)/ka ; double y3 = 0.25*Math.sin(th/2)/ka; 
          double x4 = 0.28*Math.cos(th-3*dth)/ka ; double y4 = 0.28*Math.sin(th-3*dth)/ka; 
          double x5 = 0.20*Math.cos(th+Math.PI/4)/ka ; 
                 double y5 = 0.20*Math.sin(th+Math.PI/4)/ka; 
          fTeXlabel(xc+x3,yc+y3, "cc", "$\\theta$") ;
          fEllipticalArc(xc, yc, 0.15/ka, 0.15/ka, 0, th*180/Math.PI, OPEN) ;
          fTeXlabel(x+x4,y+y4, "cc", "$\\theta$") ;
          fTeXlabel(x+x5,y+y5, "cc", "$\\phi$") ;
          fEllipticalArc(x, y, 0.18/ka, 0.18/ka, 0, th*180/Math.PI, OPEN) ;
          fEllipticalArc(x, y, 0.13/ka, 0.13/ka, 0, th*180/Math.PI+90, OPEN) ;

          double dx = 0.08*Tx/ka  ; double dy = 0.08*Ty/ka ;
          fLine(x+dy, y-dx, x+dy-dx, y-dx-dy) ;
          fLine(x-dx, y-dy, x+dy-dx, y-dx-dy) ;

          fEnv("psFillColor", Black) ;
          fArrow(x, y, x+0.4/ka, y) ;
          fTeXlabel(x+0.4/ka+0.1, y, "cl", "$\\hi$") ;
          fArrow(xc, yc, xc+0.3/ka, yc) ;
          fTeXlabel(xc+0.3/ka, yc-0.1, "tc", "$\\hi$") ;

          fEnv("psFillColor", Blue) ;
          fDisk(x , y  , r, r*aspect, FILLED) ;

          fEnv("psFillColor", Red) ;
          fDisk(xc , yc , r, r*aspect, FILLED) ;








//          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(0)$") ;
//          x = 3 ;  y = 2/(2+x) ;
//          fDisk(x, y, r, r*aspect, FILLED) ;
//          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(1)$") ;
//          x = 5 ;  y = 2/(2+x) ;
//          fDisk(x, y, r, r*aspect, FILLED) ;
//          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(2)$") ;
//
//          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}
