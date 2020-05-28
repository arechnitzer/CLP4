                  /*  File: xAxis.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xAxis extends Template {

     static {templateClass = new xAxis() ; }

     public void setup() {
          filePrefix="xAxis";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5*0.25 ;   // in inches
          ysize = 2*0.25 ;   // in inches
          xmin = 0 ;
          xmax =  5 ;
          ymin = -1 ;
          ymax = 1 ;
          topmargin = 0.0 ;   // in inches
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
          double R = 1 ; double r = 0.1 ;
          fDisk(3,0,R,FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(3,0,r,FILLED) ;
          fLine(0,0, xmax,0) ;
          fTeXlabel(3.5,0.8,"bl","$B_\\veps\\big((x_0,0)\\big)$") ;
     }
}
