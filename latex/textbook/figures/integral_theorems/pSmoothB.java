                  /*  File:  pSmoothB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pSmoothB extends Template {

     static {templateClass = new pSmoothB() ; }

     public void setup() {
          filePrefix = "pSmoothB" ;// used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*0.65 ;      
          ysize = 3*126/120*0.65 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -1 ;
          ymax = 125 ;
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
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double r = 30 ;
          double HH = 108 ;
          double H = 65 ;
          double h = 40 ;
          double XX = r*HH/H ;
          double X = r*H/H ;
          double x = r*h/H ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.8) ;
//          fDisk(0,H,X,X/3.0, FILLED) ;
//          fLine(0, 0, -x,h) ;
//          fLine(0, 0, x,h) ;
//          fDisk(0,HH,XX,XX/3.0, CLOSED) ;
//          fLine(X, H, XX,HH) ;
//          fLine(-X, H, -XX,HH) ;


          fEnv("lineWidth", 1.5) ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-X,H, 0,0) ;
          fLine(X, H, 0,0) ;
          fEllipticalArc(0,H, X,X/4.0, 180, 360, OPEN) ;
          fEllipticalArc(0,H, X,X/1.2, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0,H, X,X/4.0, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
//          fTeXlabel(-(x+X)/2-3, (h+H)/2-5, "cr", "$S$") ;

//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("lineWidth", 0.5) ;
//          double y = 0.6*h+0.4*H ;
//          x = r*y/H ;
//          double l = 15 ;
//          double dx = l*H/Math.sqrt(r*r+H*H) ;
//          double dy = -l*r/Math.sqrt(r*r+H*H) ;       
//          fArrow(x,y, x+dx, y+dy) ;
//          fTeXlabel(x+dx+2, y+dy, "cl", "$\\hn$") ; 
     }
}
