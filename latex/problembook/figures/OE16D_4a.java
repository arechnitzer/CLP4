                  /*  File:  OE16D_4a.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16D_4a extends Template {

     static {templateClass = new OE16D_4a() ; }

     public void setup() {
          filePrefix = "OE16D_4a" ;
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
          fTeXlabel(xmax, -0.15, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(2, -0.6, "cc", "$R_2$") ;
          fTeXlabel(3,  1, "cc", "$C_2$") ;
          fTeXlabel(2.1,  0.1, "bc", "${\\scriptstyle (2,0)}$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;
          fDisk(2,0, 1, 1, CLOSED) ; 
//          fEnv("arrowHeadColor", Red) ;  
          fEnv("headHalfWidth", 2.0*1.5) ;  
          fEnv("headLength", 6.0*1.5) ;
          fArrowhead(2,1, 180) ;       
     }
}
