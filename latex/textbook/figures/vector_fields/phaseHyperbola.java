                  /*  File:  phaseHyperbola.java    */


import figPac.* ;
import fnPac.* ;
//import java.applet.* ;
//import java.awt.* ;


public class phaseHyperbola extends Template {

     static {templateClass = new phaseHyperbola() ; }

     public void setup() {
          filePrefix = "phaseHyperbola" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;



          fEnv("psGray", 0.6) ;
          fEnv("psFillGray", 0.6) ;
          fEnv("arrowHeadGray", 0.6) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.2, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          double r = 0.15 ; 
          fDisk(0, 0, r, r, FILLED) ;
          
          double[] xlist = {-3,  0, 3} ;
          double[] ylist = {-3,  0, 3} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          double len = 1.4 ; double dx, dy ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               if (ylist[i] !=0) {
                    dy = len*ylist[i]/Math.abs(ylist[i]) ;
                    fArrow(xlist[j], ylist[i], xlist[j], ylist[i]-dy) ;
               }
          }}
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               if (xlist[j] != 0) {
                    dx = len*xlist[j]/Math.abs(xlist[j])  ; 
                    fArrow(xlist[j], ylist[i], xlist[j]+dx, ylist[i]) ;
               } 
               
          }}


          
     }
}


