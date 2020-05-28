                  /*  File:  pendulum4.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class pendulum4 extends Template {

     static {templateClass = new pendulum4() ; }
     private static final long serialVersionUID = 1234512345123451234L; 

     public void setup() {
          filePrefix = "pendulum4" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.4 ;   // in inches
          ysize = 2.1*1.4 ;   // in inches
          xmin = -50 ;
          xmax = 50 ;
          ymin = -100 ;
          ymax = 50 ;
          topmargin = -0.45 ;   // in inches
          bottommargin = -0.4 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.2) ;
          fLine(0, 0, 25, -50) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, 0, -50) ;
          fLine(0, -50, 25, -50) ;
          fEllipticalArc(0, 0, 15, 15, -90, -63.4, OPEN) ;
          fTeXlabel(5, -17, "tc", "$\\theta$") ;
          fTeXlabel(16, -25, "lc", "$\\ell$") ;
          fTeXlabel(-2, -25, "rc", "$\\ell\\cos\\theta$") ;
          fTeXlabel(25/2.0-3, -52, "tc", "$\\ell\\sin\\theta$") ;

          fEnv("lineWidth", 2.0) ;
          fLine(-10, 0, 10, 0) ;

          
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ; 
          fDisk(25, -50, 5, 5, FILLED) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("lineWidth", 0.5) ;
          fArrow(0, 0, 0, 20) ;
          fTeXlabel(22,0, "lc", "$\\hi$") ;
          fArrow(0, 0, 20, 0) ;
          fTeXlabel(-2,20, "rc", "$\\hj$") ;

          
     }
}
