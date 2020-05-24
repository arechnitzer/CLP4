                  /*  File:  waterField2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class waterField2 extends Template {

     static {templateClass = new waterField2() ; }

     public void setup() {
          filePrefix = "waterField2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
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
          double r = 0.2 ; 
          double R = 4.0 ; 
          double dR = 0.4 ; 
          double len = 1.0 ;
          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
//          fEnv("psGray", 0.6) ;
          fEnv("psFillGray", 0.8) ;
//          fEnv("arrowHeadGray", 0.6) ;
          fDisk(0,0, R, R, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, R-dR, R-dR, FILLED) ;
          fArrow(0,R-dR-len, 0, R-dR) ;
          fArrow(0,R+len, 0, R) ;
          fTeXlabel(0.3, R+0.3, "bl", "$v(r)\\,dt$ thick") ;
          


          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          fEnv("lineWidth", 1.5) ;
          fDisk(0, 0, r, r, FILLED) ;
          fDisk(0, 0, R, R, CLOSED) ;

          
     }
}
