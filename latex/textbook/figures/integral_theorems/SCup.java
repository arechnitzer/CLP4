                  /*  File:  SCup.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class SCup extends Template {

     static {templateClass = new SCup() ; }

     public void setup() {
          filePrefix = "SCup" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -3 ;
          xmax = 3 ;
          ymin = -3 ;
          ymax = 3 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          double R1 = 1 ;
          double R2 = 2 ;
          double R3 = (R2-R1)/2 ;
          double L = 0.5 ;
          double r4 = 0.2 ;

          fEnv("psFillGray", 0.8) ;
          fDisk(-(R1+R2)/2, 0, R3,r4,  FILLED) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(-(R1+R2)/2, 0, R3,r4, 0, 360, OPEN) ;
          
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("headLength", 6.0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(-(R1+R2)/2, 0, -(R1+R2)/2,0.6) ;
          fTeXlabel(-(R1+R2)/2+0.1, 0.6, "cl", "$\\hn$") ;
          
          fTeXlabel(-R2-0.1, 0, "rc", "$S_c$") ;
     }
}
