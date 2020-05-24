                  /*  File:  phasePendulum1.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class phasePendulum1 extends Template {

     static {templateClass = new phasePendulum1() ; }
     private static final long serialVersionUID = 1234512345123451234L ; 
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "phasePendulum1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.8*1.4 ;      // in inches
          ysize = 1.4*1.4 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -1.4*pi ;
          xmax = 2.4*pi ;
          ymin = -0.7*pi ;
          ymax = 0.7*pi ;
          topmargin = 0.15 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("headHalfWidth", 2*0.9) ;
          fEnv("headLength",    6*0.9) ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psGray", 0.8) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(-2*pi, ymin, -2*pi, ymax) ;
          fLine(-pi, ymin, -pi, ymax) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(pi, ymin, pi, ymax) ;
          fLine(2*pi, ymin, 2*pi, ymax) ;
          fLine(3*pi, ymin, 3*pi, ymax) ;
          fLine(4*pi, ymin, 4*pi, ymax) ;
          fLine(5*pi, ymin, 5*pi, ymax) ;
          fLine(6*pi, ymin, 6*pi, ymax) ;


          fEnv("lineWidth", 0.5) ;
          fEnv("psGray", 0.0) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;

          double ahl = 0.2 ;
          double aht = 0.5*pi ;
          double r = 0.08 ;
          fArrow(-2*pi-ahl, aht, -2*pi+ahl, aht) ;
          fArrow(-1.5*pi-ahl, aht, -1.5*pi+ahl, aht) ;
          fArrow(-pi-ahl, aht, -pi+ahl, aht) ;
          fArrow(-0.5*pi-ahl, aht, -0.5*pi+ahl, aht) ;
          fArrow(   -ahl, aht,   ahl, aht) ;
          fArrow(0.5*pi-ahl, aht, 0.5*pi+ahl, aht) ;
          fArrow(1.0*pi-ahl, aht, 1.0*pi+ahl, aht) ;
          fArrow(1.5*pi-ahl, aht, 1.5*pi+ahl, aht) ;
          fArrow(2.0*pi-ahl, aht, 2.0*pi+ahl, aht) ;
          fArrow(2.5*pi-ahl, aht, 2.5*pi+ahl, aht) ;
          fArrow(3.0*pi-ahl, aht, 3.0*pi+ahl, aht) ;

          fArrow(-2*pi+ahl, -aht, -2*pi-ahl, -aht) ;
          fArrow(-1.5*pi+ahl, -aht, -1.5*pi-ahl, -aht) ;
          fArrow(-pi+ahl, -aht, -pi-ahl, -aht) ;
          fArrow(-0.5*pi+ahl, -aht, -0.5*pi-ahl, -aht) ;
          fArrow(   ahl, -aht,   -ahl, -aht) ;
          fArrow(0.5*pi+ahl, -aht, 0.5*pi-ahl, -aht) ;
          fArrow(1.0*pi+ahl, -aht, 1.0*pi-ahl, -aht) ;
          fArrow(1.5*pi+ahl, -aht, 1.5*pi-ahl, -aht) ;
          fArrow(2.0*pi+ahl, -aht, 2.0*pi-ahl, -aht) ;
          fArrow(2.5*pi+ahl, -aht, 2.5*pi-ahl, -aht) ;
          fArrow(3.0*pi+ahl, -aht, 3.0*pi-ahl, -aht) ;

          fArrow(-1.5*pi-ahl, aht, -1.5*pi-ahl, aht-2*ahl) ;
          fArrow(-1.5*pi,        ahl, -1.5*pi, -ahl) ;
          fArrow(-1.5*pi+ahl, -aht, -1.5*pi+ahl, -aht-2*ahl) ;

          fArrow(-0.5*pi-ahl, aht, -0.5*pi-ahl, aht+2*ahl) ;
          fArrow(-0.5*pi,        -ahl, -0.5*pi, ahl) ;
          fArrow(-0.5*pi+ahl, -aht, -0.5*pi+ahl, -aht+2*ahl) ;

          fArrow( 0.5*pi-ahl, aht,   0.5*pi-ahl, aht-2*ahl) ;
          fArrow( 0.5*pi,        ahl,   0.5*pi, -ahl) ;
          fArrow( 0.5*pi+ahl, -aht,  0.5*pi+ahl, -aht-2*ahl) ;

          fArrow( 1.5*pi-ahl, aht,   1.5*pi-ahl, aht+2*ahl) ;
          fArrow( 1.5*pi,        -ahl,  1.5*pi, ahl) ;
          fArrow( 1.5*pi+ahl, -aht,  1.5*pi+ahl, -aht+2*ahl) ;

          fArrow( 2.5*pi-ahl, aht,   2.5*pi-ahl, aht-2*ahl) ;
          fArrow( 2.5*pi,        ahl,   2.5*pi, -ahl) ;
          fArrow( 2.5*pi+ahl, -aht,  2.5*pi+ahl, -aht-2*ahl) ;
          
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ; 
          fDisk(-2*pi, 0, r, r, FILLED) ;
          fDisk(-  pi, 0, r, r, FILLED) ;
          fDisk(    0, 0, r, r, FILLED) ;
          fDisk(   pi, 0, r, r, FILLED) ;
          fDisk( 2*pi, 0, r, r, FILLED) ;
          fDisk( 3*pi, 0, r, r, FILLED) ;

          fTeXlabel(xmin-0.05, 0, "cr", "$y=0$") ;
          fTeXlabel(-pi, ymin-0.2, "bc", "$x=-\\pi$") ;
          fTeXlabel(0, ymin-0.2, "bc", "$x=0$") ;
          fTeXlabel(pi, ymin-0.2, "bc", "$x=\\pi$") ;
          fTeXlabel(2*pi, ymin-0.2, "bc", "$x=2\\pi$") ;
//          fTeXlabel(xmin-0.05, 0, "cr", "$\\scriptstyle y=0$") ;
//          fTeXlabel(-pi, ymin-0.2, "bc", "$\\scriptstyle x=-\\pi$") ;
//          fTeXlabel(0, ymin-0.2, "bc", "$\\scriptstyle x=0$") ;
//          fTeXlabel(pi, ymin-0.2, "bc", "$\\scriptstyle x=\\pi$") ;
//          fTeXlabel(2*pi, ymin-0.2, "bc", "$\\scriptstyle x=2\\pi$") ;
          
     }
}
