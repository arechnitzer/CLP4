                  /*  File:  duckyField.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class duckyField extends Template {

     static {templateClass = new duckyField() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "duckyField" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.3*0.8 ;      // in inches
          ysize = 3.3*0.8 ;   // in inches
          xmin = -0.1 ;
          xmax =  3.2 ;
          ymin = -0.1 ;
          ymax =  3.2 ;

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
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.05, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.05, "bc", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(0,1, -0.07,1) ; fTeXlabel(-0.1,1, "cr", "$1$") ;
          fLine(0,2, -0.07,2) ; fTeXlabel(-0.1,2, "cr", "$2$") ;
          fLine(0,3, -0.07,3) ; fTeXlabel(-0.1,3, "cr", "$3$") ;
          fLine(1,0, 1,-0.07) ; fTeXlabel(1,-0.1, "ct", "$1$") ;
          fLine(2,0, 2,-0.07) ; fTeXlabel(2,-0.1, "ct", "$2$") ;
          fLine(3,0, 3,-0.07) ; fTeXlabel(3,-0.1, "ct", "$3$") ;


          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Pink) ;
          double r = 0.04 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fDisk(0, 2, r, r*aspect, FILLED) ;
//          fLine(0,2, 0,0) ;
          fDisk(1, 0, r, r*aspect, FILLED) ;
//          fLine(1,0, xmax,0) ;
          fDisk(1, 2, r, r*aspect, FILLED) ;
//          fCurve("y=2/x", 0, 1, xmax, OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;



          double len = 0.25 ;
          double pi = Math.PI ;

//          double[] xlist = {0, 0.5, 1.0, 1.5, 2.0, 2.5} ;
//          double[] ylist = {0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0 } ;
          double[] xlist = {0, 0.3, 0.6, 0.9, 1.2, 1.5, 1.8, 2.1, 2.4, 2.7, 3.0} ;
          double[] ylist = {0, 0.3, 0.6, 0.9, 1.2, 1.5, 1.8, 2.1, 2.4, 2.7, 3.0} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("lineWidth", 0.75) ;
          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy, slope, sign ;
          for (int i=0; i<nx ; i++) {
          for (int j=0; j<ny ; j++) {
               len = 0.18*Math.pow(xlist[i]*xlist[i] + ylist[j]*ylist[j], 0.2) ;
               if (xlist[i] == 0) {
                    sign = +1 ;
                    if ( ylist[j] > 0) sign = -1 ; 
                    dx = 0 ; 
                    dy = 0.5*sign*len ;
               } else {
                    sign = +1 ;
                    if (xlist[i] < 0) sign = -1 ; 
                    slope = -ylist[j]/(xlist[i]) ;
                    dx = sign*0.5*len/Math.sqrt(1+slope*slope) ;
                    dy = dx*slope ;
               }
               if ( (xlist[i] > 0.1) ||(xlist[i] < -0.1) || (ylist[j] != 0) ) {
                    fArrow(xlist[i]-dx, ylist[j]-dy, xlist[i]+dx, ylist[j]+dy) ;
               } else {
//                    fDisk(xlist[i], ylist[j], r, r*aspect, FILLED) ;
               }
          }}
          
     }
}
