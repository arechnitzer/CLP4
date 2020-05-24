                  /*  File:  stokes4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class stokes4 extends Template {

     static {templateClass = new stokes4() ; }

     public void setup() {
          filePrefix = "stokes4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1*1.5 ;   
          ysize = 1.8*1.5 ;   
          xmin = -0.1 ;
          xmax = 0.9 ;
          ymin = -0.5 ;
          ymax = 1.3;
          topmargin = -0.2 ;
          bottommargin = -0.2 ;
          leftmargin = -0.2 ;
          rightmargin = 0.5 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, -0.1, 0.0, 0.9) ;
          fTeXlabel(xmax, -0.05, "tr", "$u$") ;
          fTeXlabel(-0.03, 0.9, "tr", "$v$") ;

          fEnv("lineWidth", 1.0) ;
          fDisk(0.5, 0.5, 0.4, 0.2, CLOSED) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("lineWidth", 0.5) ;
          fArrow(0.5, 0.3, 0.9, 0.3) ;
          double th = 0.5 ; 
          double x = 0.5 -0.4*Math.sin(th) ; double y = 0.5 -0.2*Math. cos(th) ;
          fArrowhead(x, y, -15) ;

          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
//          canvas.append( new fPsWrite("0.7 setgray\n")) ;
//          fEnv("arrowHeadGray", 0.6) ;
          fArrow(0.5, 0.3,  0.5, 0.5) ;
//          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(0.5, 0.3, 0.023, 0.023, FILLED) ;
          fEnv("psFillColor", Black) ;
          fTeXlabel(0.55, 0.27, "tc", "$(u_0, v_0)$") ;
          fTeXlabel(0.93, 0.3, "lc", "$(u'(t_0), 0)$") ;


          fTeXlabel(x,y-0.03, "tr", "$\\partial R$") ;
          fTeXlabel(0.2,0.5, "cc", "$R$") ;

          fEnv("lineWidth", 0.4) ;



     }
}
