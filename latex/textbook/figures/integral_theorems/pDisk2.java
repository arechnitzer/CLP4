                  /*  File: pDisk2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pDisk2 extends Template {

     static {templateClass = new pDisk2() ; }

     public void setup() {
          filePrefix="pDisk2";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*0.3 ;   // in inches
          ysize = 2*0.3 ;   // in inches
          xmin = -1 ;
          xmax =  1 ;
          ymin = -1 ;
          ymax = 1 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.7) ;
          double R = 1 ; double r = 0.06 ;
          fDisk(0,0,R,FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0,r,FILLED) ;
          fTeXlabel(-0.75,-0.75,"tr","$\\cD$") ;
     }
}
