                  /*  File:  OE09A_4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE09A_4 extends Template {

     static {templateClass = new OE09A_4() ; }

     public void setup() {
          filePrefix = "OE09A_4" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5*0.3 ;      // in inches
          ysize = 7*0.3 ;   // in inches. 
          xmin = -1.0 ;
          xmax = 4.0 ;
          ymin = -2.0 ;
          ymax = 5.0 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double a = 1 ;
          double h = 1 ;

          fEnv("psFillGray", 0.9) ;
          fCurve("[t, t*t-4*t+3]", 1, 0, 3, FILLED) ;
          fCurve("[t, 3-t*t+2*t]", 1, 0, 3, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.12, "tr", "$x$") ;
          fTeXlabel(-0.07, ymax, "tr", "$y$") ;


          
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("[t, t*t-4*t+3]", 1, 0, 3, OPEN) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fCurve("[t, t*t-4*t+3]", 1, xmin, 0, OPEN) ;
          fCurve("[t, t*t-4*t+3]", 1, 3, xmax, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fTeXlabel(2, -1.1, "tc", "${\\scriptstyle\\textcolor{blue}{y=x^2-4x+3}}$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, 3-t*t+2*t]", 1, 0, 3, OPEN) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fCurve("[t, 3-t*t+2*t]", 1, xmin, 0, OPEN) ;
          fCurve("[t, 3-t*t+2*t]", 1, 3, xmax, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(1.3,4.1, "bc", "${\\scriptstyle\\textcolor{red}{y=3-x^2+2x}}$") ;

          double r = 0.1 ;
          fDisk(3,0, r,r, FILLED) ;
          fTeXlabel(2.85,0.1, "br", "$(3,0)$") ;
          fDisk(0,3, r,r, FILLED) ;
          fTeXlabel(-0.15,3.0, "cr", "$(0,3)$") ;

          fTeXlabel(1.5,1.5, "cc", "$R$") ;

          
     }
}



