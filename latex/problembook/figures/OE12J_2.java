                  /*  File:  OE12J_2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12J_2 extends Template {

     static {templateClass = new OE12J_2() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "OE12J_2" ;    
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
          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          fEnv("arrowHeadGray", 0.4) ;
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
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(2,1, r, r*aspect, FILLED) ;
          fTeXlabel(2.01,0.99, "tl", "$\\mathbf{Q}$") ;
          fDisk(0.4,0.63, r, r*aspect, FILLED) ;
          fTeXlabel(0.39,0.62, "tr", "$\\mathbf{D}$") ;
          fDisk(0.2,2.13, r, r*aspect, FILLED) ;
          fTeXlabel(0.2,2.1, "tl", "$\\mathbf{G}$") ;
          fDisk(1.2,2.13, r, r*aspect, FILLED) ;
          fTeXlabel(1.2,2.16, "bl", "$\\mathbf{B}$") ;
          fDisk(2.38,1.5, r, r*aspect, FILLED) ;
          fTeXlabel(2.38,1.48, "tl", "$\\mathbf{A}$") ;
          fDisk(2.53,2.47, r, r*aspect, FILLED) ;
          fTeXlabel(2.53,2.45, "tl", "$\\mathbf{N}$") ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fLine(0.2,2.13, 1.2,2.13) ;
          fArrowhead(0.75,2.13, 180) ;
          fTeXlabel(0.74,2.18, "bc", "$\\mathbf{C_2}$") ;

         { double[] bxlist = {2.38, 2.0, 1.72,  1.5, 1.2} ;
           double[] bylist = {1.5, 1.8 , 1.83, 1.85, 2.13} ;
           fBezier bezr = new fBezier(bxlist, bylist, 5, OPEN) ;
//            bezr.configure("vertex0outAngle",-45) ;
//            bezr.configure("vertex1outAngle",90) ;
//            bezr.configure("vertex1inAngle", -90) ;
//            bezr.configure("vertex3inAngle",210) ;
            canvas.append(bezr) ;
            fArrowhead(1.72,1.83, 180) ;
//            fTeXlabel(136,117, "bc", "$\\cC_1$") ;
          }


          
     }
}
