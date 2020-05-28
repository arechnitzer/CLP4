                  /*  File:  pendulumField.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pendulumField extends Template {

     static {templateClass = new pendulumField() ; }

     public void setup() {
          filePrefix = "pendulumField" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 9*0.6 ;      // in inches
          ysize = 5*0.6 ;   // in inches. 
          xmin = -4.5 ;
          xmax = 7.5 ;
          ymin = -2.5 ;
          ymax = 2.5 ;
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

          fTeXlabel((xmax+xmin)/2, ymin-0.3, "tc", "direction field for $x'=y,\\  y'=-y-2\\sin x$") ;

          double len = 0.35 ;
          
          double[] xlist = {-4, -3, -2, -1, 0, 1, 2, 3, 4,5,6,7} ;
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
                    if ( Math.sin(xlist[j]) > 0) sign = -1 ; 
                    dx = 0 ; 
                    dy = 0.5*sign*len ;
               } else {
                    sign = +1 ;
                    if (ylist[i] < 0) sign = -1 ; 
                    slope = -(ylist[i]+2*Math.sin(xlist[j]))*(ylist[i]) ;
                    dx = sign*0.5*len/Math.sqrt(1+slope*slope) ;
                    dy = dx*slope ;
               }
               if ( (xlist[j] !=0) || (ylist[i] != 0) ) {
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               }
          }}
          
     }
}
