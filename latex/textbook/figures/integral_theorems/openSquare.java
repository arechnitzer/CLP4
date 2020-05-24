                  /*  File: openSquare.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class openSquare extends Template {

     static {templateClass = new openSquare() ; }

     public void setup() {
          filePrefix="openSquare";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*0.8 ;   // in inches
          ysize = 1.2*0.8 ;   // in inches
          xmin = -.15 ;
          xmax = 1.45 ;
          ymin = -0.15 ;
          ymax = 1.05 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.0 ;   // in inches
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
          {double[] xlist = {0, 0, 1, 1} ;
           double[] ylist = {0, 1, 1, 0} ;
           fPolygon(xlist,ylist, 4, FILLED) ;}
           double x = 0.8 ; double y = 0.8 ; double R = 0.15 ; double r = 0.02 ;
           fEnv("psFillGray", 0.4) ;
           fDisk(x,y,R,FILLED) ;
           fEnv("psFillGray", 0.0) ;
           fDisk(x,y,r,FILLED) ;
           fTeXlabel(0.4,0.4,"cc","$\\cO$") ;
     }
}
