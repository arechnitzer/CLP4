                  /*  File:  OE16D_4c.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16D_4c extends Template {

     static {templateClass = new OE16D_4c() ; }

     public void setup() {
          filePrefix = "OE16D_4c" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.0*0.3 ;   
          ysize = 7.0*0.3 ;   
          xmin = -1.5 ;
          xmax = 5.5 ;
          ymin = -1.5  ;
          ymax = 5.5 ;
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
          double Two = 1.5 ;
          double rho = 0.7 ;
          fEnv("psFillGray", 0.9) ;
          fDisk(Two,Two, 3, 3, FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(Two,Two, 0.1, 0.1, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, rho, rho, FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.15, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(Two+1, -0.6, "cc", "$R_4$") ;
          fTeXlabel(5,  1, "cc", "$C_4$") ;
          fTeXlabel(Two,  Two +0.1, "bc", "$(2,2)$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;
          fDisk(Two,Two, 3, 3, CLOSED) ;
          fDisk(0,0, rho, rho, CLOSED) ;   
 
//          fEnv("arrowHeadColor", Red) ;  
          fEnv("headHalfWidth", 2.0*1.5) ;  
          fEnv("headLength", 6.0*1.5) ;
          fArrowhead(Two,Two+3, 180) ;  
          fArrowhead(0,rho, 0) ;  
          fTeXlabel(0.3, rho-0.2, "bl", "$-C_\\rho$") ;
     
     
     }
}
