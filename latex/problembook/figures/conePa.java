                  /*  File:  conePa.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class conePa extends Template {

     static {templateClass = new conePa() ; }

     public void setup() {
          filePrefix = "conePa" ;    // used as the prefix for any ps or lbl files written
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
          double y = h ;
          double x = r*y/h ;

          fEnv("psFillGray", 0.9) ;
          fDisk(0,h,x,x/3.5, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          double yy = 30 ;
          double xx = r*yy/h ;
          double yyy = -xx*0.6;
          double xxx = yy*0.6 ;
          fTeXlabel(-xx-2, yy, "tr", "$S_1$") ;
          fArrow(xx,yy, xx+xxx, yy+yyy) ; 
          fTeXlabel(xx+xxx+3, yy+yyy, "cl", "$\\hn$") ;
 
         canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 1.5) ;
          fDisk(0,h,x,x/3.5, CLOSED) ;
          fLine(0,0, -x,h) ;
          fLine(0,0, x,h) ;

          fArrowhead(0, y+x/3.5, 00) ;
          fTeXlabel(0, y+x/3.5+3, "bc", "$\\partial S_1$") ;

//          fDisk(0,-h,x,x/3.5, CLOSED+FILLED) ;
//          fEllipticalArc(0,-h, x,x/3.5, 180, 360, OPEN) ;
//          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
//          fEllipticalArc(0,-h, x,x/3.5, 0, 180, OPEN) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
//          fEnv("lineWidth", 0.5) ;
//          fArrow(0,h, 0, 1.5*h) ; 
//          fLine(0,h, 0, 1.75*h) ; 
//          fTeXlabel(4, 1.75*h, "tl", "$z$") ;
     }
}
