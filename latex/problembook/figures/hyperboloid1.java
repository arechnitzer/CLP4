                  /*  File:  hyperboloid1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperboloid1 extends Template {

     static {templateClass = new hyperboloid1() ; }

     public void setup() {
          filePrefix = "hyperboloid1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.0 ;      
          ysize = 2*150/120.0*1.0 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -60 ;
          ymax = 90 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double r = 30 ;
          double h = 40 ;
          double y = h ;
          double x = r*y/h ;
          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/3.0, CLOSED+FILLED) ;
          fCurve("[15*sqrt(0.85 +3.15*t*t/1600 ) , t]", 1, -h, h, OPEN) ;
          fCurve("[-15*sqrt(0.85 +3.15*t*t/1600 ) , t]", 1, -h, h, OPEN) ;
//          fLine(x,-h, -x,h) ;
//          fLine(-x,-h, x,h) ;
          fEllipticalArc(0,-h, x,x/3.0, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fEllipticalArc(0,-h, x,x/3.0, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fEnv("lineWidth", 0.5) ;
//          fArrow(0,h, 0, 1.5*h) ; 
//          fLine(0,h, 0, 1.75*h) ; 
//          fTeXlabel(4, 1.75*h, "tl", "$z$") ;
     }
}
