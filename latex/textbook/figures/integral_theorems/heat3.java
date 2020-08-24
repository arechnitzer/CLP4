                  /*  File:  heat3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class heat3 extends Template {

     static {templateClass = new heat3() ; }

     public void setup() {
          filePrefix = "heat3" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.4 ;      // in inches
          ysize = 1.25*1.4 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 25 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.3 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fLine(-80, 0, 80, 0) ;
          {double[] xlist = {-80, 80, 80, -80} ;
           double[] ylist = { 0,   0, -50, -50} ;
           fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(-70, 0, -70, -40) ;
          fTeXlabel(-65, -40, "lc", "$z$") ;
          fTeXlabel(75, 5, "br", "air") ;
          fTeXlabel(75, -5, "tr", "earth") ;
          fTeXlabel(85, 0, "lc", 
                 "$z=0$, $T(0,t)=T_0+T_A\\cos(\\sigma t)+T_D\\cos(\\delta t)$") ;
          fTeXlabel(0, -25, "cc", "$T_t=\\alpha T_{zz}$") ;
          
     }
}
