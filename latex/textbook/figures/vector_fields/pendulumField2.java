                  /*  File:  pendulumField2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pendulumField2 extends Template {

     static {templateClass = new pendulumField2() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "pendulumField2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
//          xsize = 9*0.6 ;      // in inches
//          ysize = 5*0.6 ;   // in inches. 
//          xmin = -4.5 ;
//          xmax = 7.5 ;
//          ymin = -2.5 ;
//          ymax = 2.5 ;
          xsize = 3.8*1.4 ;      // in inches
          ysize = 1.5*1.4 ;   // in inches
          xmin = -1.4*pi ;
          xmax = 2.4*pi ;
          ymin = -0.7*pi ;
          ymax = 0.8*pi ;

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
          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fTeXlabel((xmax+xmin)/2, ymin-0.3, "tc", "direction field for $x'=y,\\  y'=-2\\sin x$") ;

          double len = 0.35 ;
          double r = 0.07 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double pi = Math.PI ;

//          double dpi = pi/3.0 ;
//          double[] xlist = {-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7} ;

          double dpi = pi/4.0 ;
          double[] xlist = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ;

          double[] ylist = { -2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2 } ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy, slope, sign ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               if (ylist[i] == 0) {
                    sign = +1 ;
                    if ( Math.sin(xlist[j]*dpi) > 0) sign = -1 ; 
                    dx = 0 ; 
                    dy = 0.5*sign*len ;
               } else {
                    sign = +1 ;
                    if (ylist[i] < 0) sign = -1 ; 
                    slope = -2*Math.sin(xlist[j]*dpi)/(ylist[i]) ;
                    dx = sign*0.5*len/Math.sqrt(1+slope*slope) ;
                    dy = dx*slope ;
               }
               if ( (Math.sin(xlist[j]*dpi) > 0.1) ||(Math.sin(xlist[j]*dpi) < -0.1) || (ylist[i] != 0) ) {
                    fArrow(xlist[j]*dpi-dx, ylist[i]-dy, xlist[j]*dpi+dx, ylist[i]+dy) ;
               } else {
                    fDisk(xlist[j]*dpi, ylist[i], r, r*aspect, FILLED) ;
               }
          }}
          
     }
}
