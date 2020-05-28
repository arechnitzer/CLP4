                  /*  File: pDisk0.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pDisk0 extends Template {

     static {templateClass = new pDisk0() ; }

     public void setup() {
          filePrefix="pDisk0";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*0.4 ;   // in inches
          ysize = 2*0.4 ;   // in inches
          xmin = -1 ;
          xmax =  1 ;
          ymin = -1 ;
          ymax = 1 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          double R = 1 ; double r = 0.06 ;
          fDisk(0,0,R,FILLED) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("psGray", 1.0) ;
          fLine(R,0, 0,0) ;
          fTeXlabel(-0.7,-0.7,"tr","$\\cD_0$") ;
     }
}
