                  /*  File:  parCurveL.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class parCurveL extends Template {

     static {templateClass = new parCurveL() ; }

     public void setup() {
          filePrefix = "parCurveL" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;   
          ysize = 2 ;   
          xmin = 0  ;
          xmax = 3 ;
          ymin = 0 ;
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

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("y = 2/(1+2*x)", 0, -0.2, xmax, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.1 ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double x = 0.1 ; double y = 2/(1+2*x) ; 
          double dy = 1 ; double dx = 4/((1+2*x)*(1+2*x)) ;
          double ddx = r*dx/Math.sqrt(dx*dx+dy*dy) ;
          double ddy = aspect*r*dy/Math.sqrt(dx*dx+dy*dy) ;
          fLine(x-ddx, y-ddy, x+ddx,y+ddy) ;
//          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(0)$") ;
          double xp = x ;  double yp = y ;
          x = 0.5 ;  y = 2/(1+2*x) ;
          dy = 1 ;  dx = 4/((1+2*x)*(1+2*x)) ;
          ddx = r*dx/Math.sqrt(dx*dx+dy*dy) ;
          ddy = aspect*r*dy/Math.sqrt(dx*dx+dy*dy) ;
          fLine(x-ddx, y-ddy, x+ddx,y+ddy) ;
//          fLine(x,y, xp,yp) ;
          fTeXlabel(x-0.07, y-0.05, "tr", "$\\vr(t_{\\ell-1})$") ;
          xp = x ; yp = y ;
          x = 1.15 ;  y = 2/(1+2*x) ;
          dy = 1 ;  dx = 4/((1+2*x)*(1+2*x)) ;
          ddx = r*dx/Math.sqrt(dx*dx+dy*dy) ;
          ddy = aspect*r*dy/Math.sqrt(dx*dx+dy*dy) ;
          fLine(x-ddx, y-ddy, x+ddx,y+ddy) ;
          fLine(x,y, xp,yp) ;
          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(t_\\ell)$") ;
          x = 2.0 ;  y = 2/(1+2*x) ;
          dy = 1 ;  dx = 4/((1+2*x)*(1+2*x)) ;
          ddx = r*dx/Math.sqrt(dx*dx+dy*dy) ;
          ddy = aspect*r*dy/Math.sqrt(dx*dx+dy*dy) ;
          fLine(x-ddx, y-ddy, x+ddx,y+ddy) ;
          x = 2.8 ;  y = 2/(1+2*x) ;
          dy = 1 ;  dx = 4/((1+2*x)*(1+2*x)) ;
          ddx = r*dx/Math.sqrt(dx*dx+dy*dy) ;
          ddy = aspect*r*dy/Math.sqrt(dx*dx+dy*dy) ;
          fLine(x-ddx, y-ddy, x+ddx,y+ddy) ;

          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}
