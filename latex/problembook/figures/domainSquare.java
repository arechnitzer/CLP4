                  /*  File:  domainSquare.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainSquare extends Template {

     static {templateClass = new domainSquare() ; }

     public void setup() {
          filePrefix = "domainSquare" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*0.7 ;    
          ysize = 1.5*0.7 ;  
          xmin = -0.1 ;
          xmax =  1.5 ;
          ymin = -0.1 ;
          ymax =  1.4 ;
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
          fEnv("psFillGray", 0.8) ;
          {double[] xlist = {0, 1, 1, 0} ;
           double[] ylist = {0, 0, 1, 1} ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          {double[] xlist = {0, 1, 1, 0} ;
           double[] ylist = {0, 0, 1, 1} ;
           fPolygon(xlist,ylist,4,CLOSED) ;
          }

          double r = 0.03 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(0,0, r,r, FILLED) ;
          fDisk(1,0, r,r, FILLED) ;
          fTeXlabel(1, -0.1, "tc", "$(1,0)$") ;
          fDisk(1,1, r,r, FILLED) ;
          fTeXlabel(1, 1.05, "bc", "$(1,1)$") ;
          fDisk(0,1, r,r, FILLED) ;
          fTeXlabel(-0.05, 1, "cr", "$(0,1)$") ;
          fTeXlabel(0.5, 0.5, "cc", "$R$") ;
//          fEnv("psFillGray", 0.3) ;
//          {double[] xlist = {25, 30, 130, 125} ;
//           double[] ylist = {25,  30, 30, 25} ;
//           fPolygon(xlist,ylist,4,FILLED) ;
//          }
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fArrow(0.1,0, 0.55,0) ;
          fArrow(1,0.1, 1,0.55) ;
          fArrow(0.9,1, 0.45,1) ;
          fArrow(0,0.9, 0,0.45) ;
//          fTeXlabel(0.5, -0.07, "tc", "$\\partial R$") ;
          fTeXlabel(0.5, -0.07, "tc", "$C_1$") ;
          fTeXlabel(1.07, 0.5, "lc", "$C_2$") ;
          fTeXlabel(0.5, 1.07, "bc", "$C_3$") ;
          fTeXlabel(-0.07, 0.5, "rc", "$C_4$") ;

          
     }
}
