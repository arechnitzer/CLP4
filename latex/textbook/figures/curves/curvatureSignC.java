                  /*  File:  curvatureSignC.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class curvatureSignC extends Template {

     static {templateClass = new curvatureSignC() ; }

     public void setup() {
          filePrefix = "curvatureSignC" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.2 ;   
          ysize = 2.2 ;   
          xmin = -2  ;
          xmax = 0.2 ;
          ymin = -0.2 ;
          ymax = 2 ;
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

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("lineWidth", 1.0) ;
          double xc = 0 ; double yc = 0 ; double rho=1 ;
          double th = 135*Math.PI/180 ;
          double alDeg =  90+67.5 ; double al = alDeg*Math.PI/180 ;
          double x = xc + rho*Math.cos(th) ;
          double y = yc + rho*Math.sin(th) ;
          double Nx = 0.6*(xc-x)/rho ; double Ny = 0.6*(yc-y)/rho ;
          double Tx =  -Ny ; double Ty = Nx ;
          double xArr = xc + rho*Math.cos(al) ;
          double yArr = yc + rho*Math.sin(al) ;
          fEllipticalArc(xc, yc, rho, rho, 90, 180, OPEN) ;

          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrowhead(xArr, yArr, alDeg-90) ;

          fArrow(x, y, x+Tx, y+Ty) ;
          fTeXlabel(x+Tx+0.01, y+Ty+0.01, "bl", "$\\hat\\vT$") ;
          fArrow(x, y, x-Nx, y-Ny) ;
          fTeXlabel(x-Nx+0.01, y-Ny, "bl", "$\\diff{\\hat\\vT}{\\phi}$") ;


          fEnv("lineWidth", 0.5) ;
          fLine(x, y, x+Tx, y) ;
          fEllipticalArc(x, y, rho/5, rho/5, 0, -90+th*180/Math.PI, OPEN) ;
          double xPhi = x + 0.3*rho*Math.cos( (-Math.PI/2 +th)/2 ) ;
          double yPhi = y + 0.3*rho*Math.sin( (-Math.PI/2 +th)/2 ) ;
          fTeXlabel(xPhi,yPhi, "cc", "$\\phi$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;

          double r = 0.04 ;
          fEnv("psFillColor", Blue) ;
          fDisk(x , y  , r, r, FILLED) ;
          fEnv("psFillColor", Red) ;
          fDisk(xc , yc , r, r, FILLED) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          double xL = -rho/2+0.1 ; double yL = -0.15 ;
//          fTeXlabel(xL, yL, "cc", "$0\\le\\phi\\le\\frac{\\pi}{2},\\ \\diff{\\phi}{s}>0$");
          fTeXlabel(xL, yL, "cc", "$\\cos\\phi> 0,\\ \\diff{\\phi}{s}<0$");

     }
}
