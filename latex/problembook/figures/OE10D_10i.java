                  /*  File:  OE10D_10i.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE10D_10i extends Template {

     static {templateClass = new OE10D_10i() ; }

     public void setup() {
          filePrefix = "OE10D_10i" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;   
          ysize = 3.0 ;   
          xmin = -6  ;
          xmax = 6 ;
          ymin = -6 ;
          ymax = 6 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double RU = 5  ; double XU = 0; double YU = 0 ;
          double RS = 1.8; double XS = 2.3; double YS = 0 ;
          double RT = 0.8; double XT = 2.3; double YT = 0 ;
          double RR = 1.3  ; double XR = 0; double YR = 2.7 ;
          double RV = 1.5; double XV = -2.5; double YV = 0 ;
          double XP = 2.3; double YP = 0 ;
          double XQ = 0  ; double YQ = 2.7 ;
          double r = 0.1 ;
          double S2 = Math.sqrt(2) ; 
          double eps = 0.05 ;

//          fEnv("lineWidth", 0.5) ;
//          fLine(xmin,0, xmax, 0) ;
//          fLine(-1, ymin,-1, ymax) ;
//          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
//          fTeXlabel(-1.04, ymax, "tr", "$y$") ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(XU, YU, RU, RU*aspect, BOUNDARY) ;
              fTeXlabel( XU+RU/S2+eps , YU+RU/S2+eps, "bl", "$U$") ;
              fArrowhead(XU+RU, YU, -90) ;
          fDisk(XS, YS, RS, RS*aspect, BOUNDARY) ;
              fTeXlabel( XS+RS/S2+eps , YS+RS/S2+eps, "bl", "$S$") ;
              fArrowhead(XS+RS, YS, -90) ;
          fDisk(XT, YT, RT, RT*aspect, BOUNDARY) ;
              fTeXlabel( XT+RT/S2+eps , YT+RT/S2+eps, "bl", "$T$") ;
              fArrowhead(XT+RT, YT, -90) ;
          fDisk(XR, YR, RR, RR*aspect, BOUNDARY) ;
              fTeXlabel( XR+RR/S2+eps , YR+RR/S2+eps, "bl", "$R$") ;
              fArrowhead(XR+RR, YR, 90) ;
          fEllipticalArc(XV, YV, RV, RV, 180, 360, OPEN) ;
              fTeXlabel( XV+RV/S2 , YV-RV/S2-eps, "tl", "$V$") ;
              fArrowhead(XV, YV-RV, 180) ;
          fEnv("psFillColor", Black) ;
          fDisk(XP, YP, r, r*aspect, FILLED) ;
              fTeXlabel( XP+0.07 , YP-0.07, "br", "$P$") ;
          fDisk(XQ, YQ, r, r*aspect, FILLED) ;
              fTeXlabel( XQ , YQ, "bl", "$Q$") ;

//          double r = 0.07 ;
//          fDisk(0, 0, r, r*aspect, FILLED) ;
//          fTeXlabel(0, -0.05, "tc", "$\\big(1\\,,\\,0\\big)$") ;
//
//
//          fEnv("lineWidth", 0.5) ;
//          fEllipticalArc(0, 0, R, R, 90+25, 180, OPEN) ;
//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fLine(0, 0, x, y) ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEnv("psFillColor", Red) ;
//          fDisk(x, y, r, r*aspect, FILLED) ;
//          fTeXlabel(x-0.3, y+0.1, "bl", "$\\big(1-\\cos\\theta\\,,\\,\\sin\\theta\\big)$") ;
//          fTeXlabel(-R-0.05, 0.1, "cb", "$\\theta$") ;
//
//          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}
