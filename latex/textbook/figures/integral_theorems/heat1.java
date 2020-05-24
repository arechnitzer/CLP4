                  /*  File:  heat1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class heat1 extends Template {

     static {templateClass = new heat1() ; }

     public void setup() {
          filePrefix = "heat1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*1.75 ;      // in inches
          ysize = 1.0*1.75 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
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
          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, 50, 20, CLOSED) ;
          fTeXlabel(55, 0, "lc", "$\\dee{S}$") ;         
          fTeXlabel(55, 50, "lc", "cold") ;         
          fTeXlabel(55, -50, "lc", "hot") ; 
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(0,0,  0, 50) ;       
          fArrow(0,0,  0, -50) ;       
          fTeXlabel(-7, 50, "rc", "$\\hn$") ; 
          fTeXlabel(-5, -50, "rc", "$\\vnabla T$") ; 
          fDisk(0, 0, 3, 3, FILLED) ;
     }
}
