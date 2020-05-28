                  /*  File:  dirField.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dirField extends Template {

     static {templateClass = new dirField() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "dirField" ;    
          outputPsFile = true ;
          outputLblFile = true ;
//          xsize = 9*0.6 ;      // in inches
//          ysize = 5*0.6 ;   // in inches. 
//          xmin = -4.5 ;
//          xmax = 7.5 ;
//          ymin = -2.5 ;
//          ymax = 2.5 ;
          xsize = 3.2*1.3 ;      // in inches
          ysize = 3.5*1.3 ;   // in inches
          xmin = -0.1 ;
          xmax = 3.1 ;
          ymin = -0.1 ;
          ymax = 3.4 ;

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
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;


          double len = 0.12 ;
          double r = 0.02 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double pi = Math.PI ;

          double hx = 1/6.0 ;
          double hy = 1/6.0 ;
          double[] xlist = {0, hx, 2*hx, 3*hx, 4*hx, 5*hx, 6*hx, 7*hx, 8*hx, 9*hx, 10*hx, 11*hx, 12*hx, 13*hx, 14*hx, 15*hx, 16*hx, 17*hx} ;

          double[] ylist = {0, hy, 2*hy, 3*hy, 4*hy, 5*hy, 6*hy, 7*hy, 8*hy, 9*hy, 10*hy, 11*hy, 12*hy, 13*hy, 14*hy, 15*hy, 16*hy, 17*hy, 18*hy, 19*hy, 20*hy} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy, xp, yp, slope, sign ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               xp = (ylist[i]-1)*(ylist[i]-3) + 1/(1+Math.exp(-10*(ylist[i]-2))) ;
               yp = (xlist[j]-1)*(xlist[j]-2) + 2/(1+Math.exp(-10*(ylist[i]-2))) ;
               if (xp == 0) {
                    sign = -1 ;
                    if ( yp > 0) sign =  1 ; 
                    dx = 0 ; 
                    dy = 0.5*sign*len ;
               } else {
                    sign = +1 ;
                    if (xp < 0) sign = -1 ; 
                    slope = yp/xp ;
                    dx = sign*0.5*len/Math.sqrt(1+slope*slope) ;
                    dy = dx*slope ;
               }
               if ( (xp > 0.1) ||( xp < -0.1) || (yp < -0.1) || (yp > 0.1) ) {
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               } else {
                    fDisk(xlist[j], ylist[i], r, r*aspect, FILLED) ;
               }
          }}
          
     }
}
