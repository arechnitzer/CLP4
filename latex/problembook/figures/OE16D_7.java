                  /*  File:  OE16D_7.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16D_7 extends Template {

     static {templateClass = new OE16D_7() ; }

     public void setup() {
          filePrefix = "OE16D_7" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.6 ;   
          ysize = 3.0*0.6 ;   
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -1.5  ;
          ymax = 1.5 ;
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

          double th = 35 ; double thDeg = th*Math.PI/180 ;
          double r= 0.3 ; double R = 1/Math.sqrt(2) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$y$") ;
          fTeXlabel(-0.03, ymin, "br", "$x$") ;

          fLine(0,0, Math.cos(thDeg), -Math.sin(thDeg)) ;
          fEllipticalArc(0,0, r, r, -th, 0, OPEN) ;
          fTeXlabel(r+0.05,-r+0.06, "bl", "$\\theta$") ;
          fTeXlabel(R+0.02,R+0.02, "bl", "$x^2+y^2=4Z^2$") ;

          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fEnv("lineWidth", 1.5) ;
          fDisk(0,0, 1, 1, CLOSED) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 2.5) ;
          fEllipticalArc(0,0, 1, 1, -45, 0, OPEN) ;
 
//          fEnv("arrowHeadColor", Red) ;  
//          fEnv("headHalfWidth", 2.0*1.5) ;  
//          fEnv("headLength", 6.0*1.5) ;
//          fArrowhead(0,1, 180) ;  
//          fArrowhead(0,rho, 0) ;  
//          fTeXlabel(0.3, rho-0.2, "bl", "$-C_\\rho$") ;
     
     
     }
}
