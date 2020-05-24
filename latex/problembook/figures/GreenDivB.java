                  /*  File:  GreenDivB.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class GreenDivB extends Template {

     static {templateClass = new GreenDivB() ; }

     public void setup() {
          filePrefix = "GreenDivB" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*0.75 ;      // in inches
          ysize = 2.2*0.75 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 120 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0, 0, 80, 60, FILLED) ;
          fDisk(0, 0, 80, 60, CLOSED) ;

          fTeXlabel(0,0,"cc", "$R$") ;
          fTeXlabel(-73,-30,"tr", "$C$") ;
          
          double th = 90 ; double thRad = th*Math.PI/180 ;
          double l = 0.7 ;
          double xc = 80*Math.cos(thRad) ;
          double yc = 60*Math.sin(thRad) ;
          double dx = -l*80*Math.sin(thRad)  ;
          double dy = l*60*Math.cos(thRad) ;
          double nx =  dy ;
          double ny =  -dx ;

          fEnv("lineWidth", 0.8) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(xc, yc, xc+dx, yc+dy) ;
          fTeXlabel(xc+dx,yc+dy+5 ,"bc", "$\\vr'(s)$") ;
          fArrow(xc, yc, xc+nx, yc+ny) ;
          fTeXlabel(xc+nx+5, yc+ny,"lc", "$\\hn(s)$") ;


          th = 315 ; thRad = th*Math.PI/180 ;
          xc = 80*Math.cos(thRad) ;
          yc = 60*Math.sin(thRad) ;
          dx = -l*80*Math.sin(thRad) ;
          dy = l*60*Math.cos(thRad) ;
          nx =  dy ;
          ny =  -dx ;

          fEnv("lineWidth", 0.8) ;
          fArrow(xc, yc, xc+dx, yc+dy) ;
          fTeXlabel(xc+dx+2,yc+dy+7 ,"tl", "$\\vr'(s)$") ;
          fArrow(xc, yc, xc+nx, yc+ny) ;
          fTeXlabel(xc+nx+5, yc+ny,"lc", "$\\hn(s)$") ;

          fEnv("psFillColor", Blue) ;
          fEnv("useColorPs", "true") ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(0, -60, 0) ;



     }
}
