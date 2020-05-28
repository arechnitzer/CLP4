                  /*  File:  stokesOrientAh.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class stokesOrientAh extends Template {

     static {templateClass = new stokesOrientAh() ; }

     public void setup() {
          filePrefix = "stokesOrientAh" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*0.6 ;      // in inches
          ysize = 2.1*0.6 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -0.7 ;
          ymax = 1.4 ;
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
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
//          String Black = "0 0 0 1 setcmykcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          double R = 1 ;
          double RR = 1.5 ;
          double RRR = RR-R ;
          double th = 60*Math.PI/180 ;
          double r = 0.3 ;

          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0, R,r, 0, 360, FILLED) ;
//          fEllipticalArc(0,0, R,R, 0, 180, OPEN) ;
          fTeXlabel(0,0, "cc", "$S$") ;
          
          fEnv("lineWidth", 0.5) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
//          fArrow(0.5*R, 0.1, 0.5*R, 0.1+RRR) ;
//          fTeXlabel(0.5*R+0.05, 0.1+RRR, "lc", "$\\hn$") ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEllipticalArc(0,0, R,r, 180, 360, OPEN) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEllipticalArc(0,0, R,r, 0, 360, OPEN) ;
          double t = -90.5 ;
          double x1 = R*Math.cos(t*Math.PI/180.0) ;
          double y1 = r*Math.sin(t*Math.PI/180.0) ;
          th = -89.5 ;
          double x2 = R*Math.cos(t*Math.PI/180.0) ;
          double y2 = r*Math.sin(t*Math.PI/180.0) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrow(x1,y1, x2,y2) ;
          fTeXlabel(x1, y1-0.1, "rt", "$\\partial S$") ;
     }
}
