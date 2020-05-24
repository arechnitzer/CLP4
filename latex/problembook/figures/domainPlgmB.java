                  /*  File:  domainPlgmB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainPlgmB extends Template {

     static {templateClass = new domainPlgmB() ; }

     public void setup() {
          filePrefix = "domainPlgmB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*190.0/75.0;    
          ysize = 1.0 ;  
          xmin = -10 ;
          xmax = 180 ;
          ymin = -10 ;
          ymax =  65 ;
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
          fEnv("lineWidth", 0.3) ;
          fLine(xmin,0,xmax,0) ;
          fTeXlabel(xmax, -2, "tr", "$x$") ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(-2, ymax, "tr", "$y$") ;
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          {double[] xlist = {50, 150, 150, 50} ;
           double[] ylist = {0,  0, 50, 50} ;
           fPolygon(xlist,ylist,4,CLOSED+FILLED) ;
          }
          double r = 2 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(150,0, r,r, FILLED) ;
          fTeXlabel(50, -2, "tc", "$(1,0)$") ;
          fDisk(50,0, r,r, FILLED) ;
          fTeXlabel(150, -2, "tc", "$(3,0)$") ;
          fDisk(50,50, r,r, FILLED) ;
          fTeXlabel(50, 52, "bc", "$(1,1)$") ;
          fDisk(150,50, r,r, FILLED) ;
          fTeXlabel(150, 52, "bc", "$(3,1)$") ;
          fTeXlabel(100, 25, "cc", "$\\cR$") ;
//          fEnv("psFillGray", 0.3) ;
//          {double[] xlist = {25, 30, 130, 125} ;
//           double[] ylist = {25,  30, 30, 25} ;
//           fPolygon(xlist,ylist,4,FILLED) ;
//          }
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(50,0, 105,0) ;
          fArrow(150,0, 150,30) ;
          fArrow(150,50, 95,50) ;
          fArrow(50,50, 50,20) ;
          fTeXlabel(100, -5, "tc", "$\\cC$") ;

          
     }
}
