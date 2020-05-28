                  /*  File: pDisk4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pDisk4 extends Template {

     static {templateClass = new pDisk4() ; }

     public void setup() {
          filePrefix="pDisk4";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*0.75 ;   // in inches
          ysize = 2*0.75 ;   // in inches
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double R = 1 ; double RR = 0.8 ; double RRR = 0.4 ; double r = 0.04 ;
          double th = 45 ; double thRad = th*Math.PI/180.0 ; 
          double x = 0.5*(RR+RRR)*Math.cos(thRad) ;
          double y = 0.5*(RR+RRR)*Math.sin(thRad) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.9) ;
          fDisk(0,0,R,FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0,r,FILLED) ;
          fTeXlabel(-0.7,-0.7,"tr","$\\cD$") ;
//          fTeXlabel(0.7*RR, -0.7*RR,"br","$\\scriptstyle\\cC$") ;
          fTeXlabel(0.7*RR, -0.7*RR,"br","$\\cC$") ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;

          fEllipticalArc(0, 0, RR, RR, -180+th, 180-th, OPEN) ;
          fEllipticalArc(0, 0, RRR, RRR, -180+th, 180-th, OPEN) ;
          fEllipticalArc(-x, y, 0.5*(RR-RRR), 0.5*(RR-RRR), 180-th, 360-th, OPEN) ;
          fEllipticalArc(-x, -y, 0.5*(RR-RRR), 0.5*(RR-RRR), th, 180+th, OPEN) ;
          fArrowhead(RR,0,90) ;
          fArrowhead(RRR,0,-90) ;
     }
}
