                  /*  File: shell.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class shell extends Template {

     static {templateClass = new shell() ; }

     public void setup() {
          filePrefix = "shell" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches. 
          xmin = -35 ;
          xmax = 35 ;
          ymin = -35 ;
          ymax = 35 ;
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
          fEnv("lineWidth", 0.5) ;
          double R = 20 ;
          double b = 30 ;
          double dR = 3 ;
          double r = 1.2 ;
          
          double th = 45 ; double thRad = th*Math.PI/180.0 ;
          double dth = 5 ; double dthRad = dth*Math.PI/180.0 ;
          double x = R*Math.cos(thRad) ; double y = R*Math.sin(thRad) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

          fEnv("lineWidth", 0.5) ;
//          fEnv("psFillGray", 0.8) ;
          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          fDisk(0, 0, R, R, CLOSED) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", dR) ;
          fEllipticalArc(0,0, R,R, th-dth, th+dth, OPEN) ;
          fTeXlabel(x+1.5, y+2, "lc", "$\\dee{S}$" ) ;
          fDisk(0,0, r,r, FILLED) ;
          fDisk(0,b, r,r, FILLED) ;
          fTeXlabel(-2, b, "rc", "$(0,0,b)$" ) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          fArrow(0,0, x, y) ;
          fTeXlabel(0.5*x+1, 0.5*y-1, "tl", "$\\vr$" ) ;
          fArrow(0,0, 0, b) ;
          fArrow(0,b, x, y) ;
          fTeXlabel(0.5*x, 0.5*(b+y), "bl", "$\\vr-(0,0,b)$" ) ;
          
     }
}
