                  /*  File:  RLC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class RLC extends Template {

     static {templateClass = new RLC() ; }

     public void setup() {
          filePrefix = "RLC" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1.25 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin =  0 ;
          xmax = 300 ;
          ymin = -93.75 ;
          ymax = 93.75 ;
          topmargin = 0.15 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fLine(40, -60, 280, -60) ;

          // Draw  the voltage source
          fDisk( 40, 0, 20, 20, CLOSED) ;
          fLine( 40, 20, 40, 60) ;
          fLine( 40, -20, 40, -60) ;
          fTeXlabel(15, 20, "cc", "$+$") ;
          fTeXlabel(15, -20, "cc", "$-$") ;
          fTeXlabel(10, 0, "cr", "$x(t)$") ;



          // the resistor
          fResistor(60, 60, 100, 60, 8, 8) ;
          fLine( 40, 60, 60, 60) ;
          fLine(100, 60, 140, 60) ;
          fTeXlabel(80, 73, "bc", "$R$") ;


          // the inductance
          fCoil(140, 60, 180, 60, 8 , 5) ;
          fLine(180, 60, 280, 60) ;
          fTeXlabel(160, 73, "bc", "$L$") ;

          // and the capacitor 
          fDisk(280, 60, 3, 3, FILLED) ;
          fDisk(280,-60, 3, 3, FILLED) ;
          fLine(200,60, 200, 3) ;
          fLine(200, -3, 200,-60) ;
          fEnv("lineWidth", 1.2) ;
          fLine(180, 3, 220, 3) ;
          fLine(180, -3, 220, -3) ;
          fTeXlabel(220, -7, "tc", "$C$") ;
          
          // the current
          fEnv("lineWidth", 0.5) ;
          fDisk(120, 0, 40, 40, CLOSED) ;
          fArrowhead(120, 40, 0) ;
          fTeXlabel(120, 0, "cc", "$i(t)$") ; 
          

          fArrow(280, -50, 280,50) ;
          fArrow(280,  50, 280,-50) ;
          fTeXlabel(293, 60, "cc", "$+$") ;
          fTeXlabel(293, -60, "cc", "$-$") ;
          fTeXlabel(288, 0, "lc", "$y(t)$") ;







          
     }
}
