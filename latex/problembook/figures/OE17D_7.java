                  /*  File:  OE17D_7.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE17D_7 extends Template {

     static {templateClass = new OE17D_7() ; }

     public void setup() {
          filePrefix = "OE17D_7" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*0.8 ;      // in inches
          ysize = 2.6*0.8 ;   // in inches. 
          xmin = -0.1 ;
          xmax =  1.4 ;
          ymin = -1.2 ;
          ymax =  1.4 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, 1, 1, -90, 90,  FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fEllipticalArc(0,0, 1, 1, -90, 90,  OPEN) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0,-1, 0,1) ;

          fEnv("headLength", 6.0*1.7) ;
          fEnv("headHalfWidth", 2.0*1.7) ;

          double th = 45 ;
          double x = Math.cos(th*Math.PI/180.0) ;
          double y = Math.sin(th*Math.PI/180.0) ;
          fArrowhead(x,y, th+90) ;
          fEnv("psFillColor", Blue) ;
          fArrowhead(0,0.2, -90) ;
          fTeXlabel(0.4, 0.3, "cc", "$R$") ;
          fTeXlabel(x*1.05, y*1.05, "bl", "$C$") ;
          fTeXlabel(-0.07, 0.2, "cr", "$L$") ;
          fTeXlabel(-0.05, 1,  "cr", "$(0,1)$") ;
          fTeXlabel( -0.05, -1, "cr", "$(0,-1)$") ;
          fTeXlabel( x*1.05, -y*1.05+0.05, "tl", "$x^2+y^2=1$") ;



     }
}
