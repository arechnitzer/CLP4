                  /*  File:  OE12J_8b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE12J_8b extends Template {

     static {templateClass = new OE12J_8b() ; }

     public void setup() {
          filePrefix = "OE12J_8b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.0*0.3 ;   
          ysize = 7.0*0.3 ;   
          xmin = -1.5 ;
          xmax = 5.5 ;
          ymin = -3.5  ;
          ymax = 3.5 ;
          topmargin = 0.1 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {

          fEnv("psFillGray", 0.9) ;
          fDisk(2,0, 1, 1, FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(2,0, 0.1, 0.1, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.15, "tr", "$y$") ;
          fTeXlabel(-0.05, ymax, "tr", "$z$") ;
          fTeXlabel(2, -0.6, "cc", "$V_2$") ;
          fTeXlabel(3,  1, "cc", "$S_2$") ;
//          fTeXlabel(2.1,  0.1, "bl", "$(0,2,0)$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fDisk(2,0, 1, 1, CLOSED) ;          
     }
}
