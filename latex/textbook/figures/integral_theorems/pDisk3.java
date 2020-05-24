                  /*  File: pDisk3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pDisk3 extends Template {

     static {templateClass = new pDisk3() ; }

     public void setup() {
          filePrefix="pDisk3";//used as the prefix for the ps and lbl files
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
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.9) ;
          double R = 1 ; double RR = 0.8 ; double RRR = 0.4 ; double r = 0.04 ;
          fDisk(0,0,R,FILLED) ;
          fEnv("psFillGray", 0.7) ;
          fDisk(0,0,RR,FILLED) ;
          fEnv("psFillGray", 0.9) ;
          fDisk(0,0,RRR,FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0,r,FILLED) ;
          fTeXlabel(-0.7,-0.7,"tr","$\\cD$") ;
          fTeXlabel(0,0.5*RR+0.5*RRR,"cc","$S$") ;
          fTeXlabel(0.7*RR, -0.7*RR,"br","$\\scriptstyle\\cC_\\veps$") ;
          fTeXlabel(0.7*RRR,-0.7*RRR,"br","$\\scriptstyle-\\cC_{\\veps'}$") ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;

          fDisk(0,0,RR,CLOSED) ;
          fDisk(0,0,RRR,CLOSED) ;
          fArrowhead(RR,0,90) ;
          fArrowhead(RRR,0,-90) ;
     }
}
