                  /*  File:  OE05D_6.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE05D_6 extends Template {

     static {templateClass = new OE05D_6() ; }

     public void setup() {
          filePrefix = "OE05D_6" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*0.4 ;   
          ysize = 2.7*0.4 ;   
          xmin = -0.1  ;
          xmax = 2.6 ;
          ymin = -0.1 ;
          ymax = 2.6 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fEnv("lineWidth", 0.5) ;
          double r = 0.08 ;
          double X = 0.7 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine( 0,0, 0,2) ;      
          fLine( 0,0, 2,0) ;  
          fLine( 0,2, 2,0) ;     
          fTeXlabel(1, 1, "bl", "$x+y=2$") ;



          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(2,0, r,r*aspect, FILLED) ;
          fTeXlabel(2,  0.05, "bl", "$(2,0)$") ;
          fDisk(0,2, r,r*aspect, FILLED) ;
          fTeXlabel(0.05,  2.05, "bl", "$(0,2)$") ;
          fTeXlabel(0.6,  0.6, "cc", "$T$") ;

//          fEnv("lineWidth", 3.0) ;
//          fLine(X,0, X,2-X) ;


          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;





     }
}
