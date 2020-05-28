                  /*  File:  VFb.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFb extends Template {

     static {templateClass = new VFb() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "VFb" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches
          xmin = -0.5 ;
          xmax = 10 ;
          ymin = -0.1*pi ;
          ymax = 1.6*pi ;

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
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;


//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fEnv("psFillColor", Blue) ;
//          fEnv("lineWidth", 2.0) ;
//          fEnv("headHalfWidth", 2.0*1.4) ;
//          fEnv("headLength", 6.0*1.4) ;

          double len = 0.35 ;
          double r = 0.07 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double pi = Math.PI ;

          double dpi = pi/3.0 ;
          double dX = 0.125 ;

//          fEnv("lineWidth", 1.5) ;
//          {double[] xlist = {0, 6, 6, 0} ;
//           double[] ylist = {0, 0, 0.95*pi, 0.95*pi} ;
//           fPolygon(xlist, ylist, 4, CLOSED) ;} 
//          fTeXlabel(3.5, 0.96*pi, "bc", "$L_1$") ;
//          fTeXlabel(-0.05, 0.4*pi, "cr", "$L_2$") ;
//          fTeXlabel(3.5, -0.05, "tc", "$L_3$") ;
//          fTeXlabel(5.98, 0.36*pi, "cr", "$L_4$") ;
//          fArrowhead(0, 0.55*pi, -90) ;
//          fArrowhead(4.5, 0, 0) ;
//          fArrowhead(6, 0.55*pi, 90) ;
//          fArrowhead(4.5, 0.95*pi, 180) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*0.9) ;
          fEnv("headLength", 6.0*0.9) ;

          double[] xlist = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ;
          double[] ylist = { 0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5 } ;
          int nx = xlist.length ;
          int ny = ylist.length ;

          double dx, dy ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               if ( (xlist[j] !=0) || (ylist[i] != 0) ) {
               if ( (xlist[j] !=0) || (ylist[i] != 3) ) {
                    dx = 0.45*Math.sin(ylist[i]*dpi) ; 
                    dy = 0.2*Math.sqrt(xlist[j]*dX) ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               }} 
               
          }}
          
     }
}
