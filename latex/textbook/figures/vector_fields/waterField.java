                  /*  File:  waterField.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class waterField extends Template {

     static {templateClass = new waterField() ; }

     public void setup() {
          filePrefix = "waterField" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3 ;      // in inches
          ysize = 3 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
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


          fTeXlabel((xmax+xmin)/2, ymin-0.3, "tc", "vector field $\\vec v=m\\frac{\\hat \\vr}{r}$") ;

          double scale = 2 ;
          
          double[] xlist = {-4, -3, -2, -1, 0, 1, 2, 3, 4} ;
          double[] ylist = {-4, -3, -2, -1, 0, 1, 2, 3, 4} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy, len ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               len = 2*(xlist[j]*xlist[j]+ylist[i]*ylist[i]) ;
//               if ( (xlist[j] !=0) || (ylist[i] != 0) ) {
               if ( len > 2 ) {
                    dx = scale*xlist[j]/len ; 
                    dy = scale*ylist[i]/len ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               } 
               
          }}
          
     }
}
