                  /*  File:  circleCentre.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class circleCentre extends Template {

     static {templateClass = new circleCentre() ; }

     public void setup() {
          filePrefix = "circleCentre" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*0.85 ;   
          ysize = 2*0.85 ;   
          xmin = -2  ;
          xmax = 2 ;
          ymin = -2 ;
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
          double xc = 0 ; double yc = 0 ; double rho=1.5 ;
          double th = 45*Math.PI/180 ;
          double alDeg =  0 ; double al = alDeg*Math.PI/180 ;
          double x = xc + rho*Math.cos(th) ;
          double y = yc + rho*Math.sin(th) ;
          double Nx = (xc-x)/rho ; double Ny = (yc-y)/rho ;
          double Tx =  Ny ; double Ty = -Nx ;
          double xArr = xc + rho*Math.cos(al) ;
          double yArr = yc + rho*Math.sin(al) ;
          fEllipticalArc(xc, yc, rho, rho, 0, 360, OPEN) ;

          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrowhead(xArr, yArr, alDeg+90) ;

          fArrow(x, y, x+Tx, y+Ty) ;
          fTeXlabel(x+Tx-0.01, y+Ty, "br", "$\\hat\\vT$") ;
          fArrow(x, y, x+Nx, y+Ny) ;
          fTeXlabel(x+Nx-0.05, y+Ny, "br", "$\\hat\\vN$") ;



          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;

          double r = 0.09 ;
          fEnv("psFillColor", Blue) ;
          fDisk(x , y  , r, r, FILLED) ;
          fEnv("psFillColor", Red) ;
          fDisk(xc , yc , r, r, FILLED) ;

     }
}
