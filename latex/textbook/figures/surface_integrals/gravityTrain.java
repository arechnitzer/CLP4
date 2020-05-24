                  /*  File: gravityTrain.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class gravityTrain extends Template {

     static {templateClass = new gravityTrain() ; }

     public void setup() {
          filePrefix = "gravityTrain" ; 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
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
          double R = 30 ;
          double r = 1.3 ;
          
          double th = 30 ; double thRad = th*Math.PI/180.0 ;
          double dth = 3 ; double dthRad = dth*Math.PI/180.0 ;
          double xt = R*Math.cos(thRad+dthRad) ; double yt = R*Math.sin(thRad+dthRad) ;
          double xb = R*Math.cos(thRad-dthRad) ; double yb = R*Math.sin(thRad-dthRad) ;
          double Z = R*Math.sin(thRad) ; 
          double x = 10 ; double dx = 3 ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 2) ;
          fEllipticalArc(0,0, R,R, -180-th+dth, th-dth, OPEN) ;
          fEllipticalArc(0,0, R,R,  th+dth, 180-th-dth, OPEN) ;
          fEnv("lineWidth", 0.5) ;
          fLine(-xb, yb, xb, yb) ;
          fLine(-xt, yt, xt, yt) ;
          fTeXlabel(xb+1, yb, "bl", "$V$" ) ;
          fTeXlabel(-xb-1, yb, "br", "$M$" ) ;

          fDisk(0,0, r,r, FILLED) ;
          fTeXlabel(2, 0, "lc", "$O$" ) ;



          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          { double[] xlist = {x-dx, x-dx, x+dx, x+dx} ;
            double[] ylist = {yb, yt, yt, yb} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }



          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(x,Z, 0.25*x, 0.25*Z) ;
          fTeXlabel(0.25*x-0.5, 0.25*Z+1, "br", "$\\vG$" ) ;
          fArrow(x,Z, x, Z+10) ;
          fTeXlabel(x-1, Z+10, "tr", "$\\vN$" ) ;
          
     }
}
