                  /*  File:  VFe.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFe extends Template {

     static {templateClass = new VFe() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "VFe" ;    
          outputPsFile = true ;
          outputLblFile = true ;
//          xsize = 9*0.6 ;      // in inches
//          ysize = 5*0.6 ;   // in inches. 
//          xmin = -4.5 ;
//          xmax = 7.5 ;
//          ymin = -2.5 ;
//          ymax = 2.5 ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches
          xmin = -0.1 ;
          xmax = 1.7 ;
          ymin = -0.1 ;
          ymax = 1.7 ;

          topmargin = 0.1 ;   // in inches
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
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          double len = 0.15 ;
          double r = 0.02 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double pi = Math.PI ;

          double hx = 1/6.0 ;
          double hy = 1/6.0 ;
          double[] xlist = {0, hx, 2*hx, 3*hx, 4*hx, 5*hx, 6*hx, 7*hx, 8*hx, 9*hx} ;

          double[] ylist = {0, hy, 2*hy, 3*hy, 4*hy, 5*hy, 6*hy, 7*hy, 8*hy, 9*hy} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.0) ;
          fEnv("headLength", 6.0*1.0) ;
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
//                    fDisk(xlist[j], ylist[i], r, r*aspect, FILLED) ;
               }
          }}
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fDisk(0.7,0.8, r, r*aspect, FILLED) ;
          fTeXlabel(0.69,0.79, "tl", "$A$") ;


          
     }
}
