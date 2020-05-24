                  /*  File: closedUnion.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class closedUnion extends Template {

     static {templateClass = new closedUnion() ; }

     public void setup() {
          filePrefix="closedUnion";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.4*0.25 ;   // in inches
          ysize = 2.4*0.25 ;   // in inches
          xmin = -1.2 ;
          xmax =  3.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
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
          fDisk(0,0,R,R, FILLED+CLOSED) ;
          fDisk(2,0,R,R, FILLED+CLOSED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(0,0,r,FILLED) ;
          fDisk(2,0,r,FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fTeXlabel(0,0.2,"bc","$\\scriptstyle(0,0)$") ;
          fTeXlabel(2.0,0.2,"bc","$\\scriptstyle(2,0)$") ;

          fEnv("lineWidth", 1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0,0, 2,0) ;

     }
}
