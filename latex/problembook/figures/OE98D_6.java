                  /*  File:  OE98D_6.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE98D_6 extends Template {

     static {templateClass = new OE98D_6() ; }

     public void setup() {
          filePrefix = "OE98D_6" ;    // used as the prefix for any ps or lbl files written
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;

          double R = 1 ;
          double RR = 1.5 ;
          double th = 60*Math.PI/180 ;
          double r = 0.3 ;
          double rr = 0.7 ;
          double X = 0.6*R ;  double Y=R*R*R*R-X*X*X*X ;
          double dx = 4*X*X*X ;  double dy = 1 ;
          double LL = Math.sqrt(dx*dx+dy*dy) ;
          dx = 0.5*dx/LL ;  dy = 0.5*dy/LL ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0, R,r, 0, 360, FILLED) ;

//          fEllipticalArc(0,0, R,R, 0, 180, OPEN) ;
          fCurve("[t , 1-t*t*t*t]", 1, -1, 1,  OPEN) ;


          fTeXlabel(R-0.08,0.6, "lc", "$\\cS$") ;
          fTeXlabel(-0.6*R,0, "cc", "$\\cD$") ;
          
          fEnv("lineWidth", 0.5) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(X, Y, X+dx, Y+dy) ;
          fTeXlabel(X+dx+0.05, Y+dy, "lc", "$\\hn$") ;
          fArrow(0.2*R, 0+0.1, 0.2*R, 0.5+0.1) ;
          fTeXlabel(0.2*R+0.08, 0.5+0.1, "lc", "$\\hn$") ;
//          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
//          fLine(0.2*R, 0, 0.2*R, -r) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEllipticalArc(0,0, R,r, 180, 360, OPEN) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0, 0, R,r, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fEllipticalArc(0,0, R,r, 180, 360, OPEN) ;
          double t = -90.5 ;
          double x1 = R*Math.cos(t*Math.PI/180.0) ;
          double y1 = r*Math.sin(t*Math.PI/180.0) ;
          th = -89.5 ;
          double x2 = R*Math.cos(t*Math.PI/180.0) ;
          double y2 = r*Math.sin(t*Math.PI/180.0) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrow(x1,y1, x2,y2) ;
          fTeXlabel(x1, y1-0.1, "rt", "$\\cC$") ;
     }
}
