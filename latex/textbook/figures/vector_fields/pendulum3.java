                  /*  File:  pendulum3.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class pendulum3 extends Template {

     static {templateClass = new pendulum3() ; }
     private static final long serialVersionUID = 1234512345123451234L; 

     public void setup() {
          filePrefix = "pendulum3" ;   
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
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ; 
//          fEnv("psFillGray", 0.7) ; 
          fDisk(25, -50, 5, 5, FILLED) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("psFillGray", 0.0) ; 
          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, 0, -25) ;
          fEllipticalArc(0, 0, 15, 15, -90, -63.4, OPEN) ;
          fTeXlabel(5, -17, "tc", "$\\theta$") ;
          fTeXlabel(16, -25, "lc", "$\\ell$") ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ; 
          fArrow( 25, -50, 25, -68) ; 
          fTeXlabel(25, -70, "tc", "$mg$") ;
          fArrow( 25, -50, 18, -36) ;
          fTeXlabel(22, -36, "lc", "$\\tau$") ;
//          fArrow(25, -50, 39, -43) ;
//          fTeXlabel(41, -42, "bl", "$\\beta$") ;
          
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fLine(-20, 0, 20, 0) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("newpath 42.24  112.0 moveto 98.56  112.0 lineto 98.56 122.0 lineto 42.24 122.0 lineto closepath clip ") ) ;
          for(double xx=-20 ; xx < 40.1 ; xx += 3) {
               fLine(xx,0, xx-50, xx+50) ;
          }
     }
}
