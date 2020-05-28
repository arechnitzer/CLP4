                  /*  File:  conePb.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conePb extends Template {

     static {templateClass = new conePb() ; }

     public void setup() {
          filePrefix = "conePb" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      
          ysize = 2*120/100 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -10 ;
          ymax = 90 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          double r = 30 ;
          double h = 50 ;
          double hh = 20 ;
          double rr = r*hh/h ;
          double y = h ;
          double x = r*y/h ;

          fEnv("psFillGray", 0.9) ;
          fDisk(0,h,x,x/3.5, FILLED) ;
          fDisk(0,hh,rr,rr/3.5, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          double yy = 35 ;
          double xx = r*yy/h ;
          double yyy = -xx*0.6;
          double xxx = yy*0.6 ;
          fTeXlabel(-xx-2, yy, "tr", "$S_2$") ;
          fArrow(xx,yy, xx+xxx, yy+yyy) ; 
          fTeXlabel(xx+xxx+3, yy+yyy, "cl", "$\\hn$") ;
          fLine(-rr,hh, 0,0) ;
          fLine(rr,hh, 0,0) ;


         canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 1.5) ;
          fDisk(0,h,x,x/3.5, CLOSED) ;
          fLine(-rr,hh, -x,h) ;
          fLine(rr,hh, x,h) ;
          fEllipticalArc(0,hh,rr,rr/3.5, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fEllipticalArc(0,hh,rr,rr/3.5, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fArrowhead(0, y+x/3.5, 0) ;
          fTeXlabel(0, y+x/3.5+3, "bc", "$\\partial S_{2a}$") ;
          fArrowhead(0, hh-rr/3.5, 0) ;
          fTeXlabel(0, hh+rr/3.5+2, "bc", "$\\partial S_{2b}$") ;

     }
}
