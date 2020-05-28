                  /*  File:  divGen.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class divGen extends Template {

     static {templateClass = new divGen() ; }

     public void setup() {
          filePrefix = "divGen" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -3 ;
          xmax = 3 ;
          ymin = -3 ;
          ymax = 3 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.2 ;   // in inches
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

          double R1 = 1 ;
          double R2 = 2 ;
          double R3 = (R2-R1)/2 ;
          double L = 0.5 ;
          double r4 = 0.2 ;
          fEnv("lineWidth", 1.5) ;
          fEllipticalArc(0,0, R1,R1, 90, 270, OPEN) ;
          fEllipticalArc(0,0, R2,R2, 90, 270, OPEN) ;
          fLine(0,R1, L,R1) ;
          fLine(0,R2, L,R2) ;
          fLine(0,-R1, L,-R1) ;
          fLine(0,-R2, L,-R2) ;
          fEllipticalArc(L,(R1+R2)/2, R3,R3, -90, 90, OPEN) ;
          fEllipticalArc(L, -(R1+R2)/2, R3,R3, -90, 90, OPEN) ;
//          fEnv("useColorPs", "true") ;

          fEnv("psFillGray", 0.8) ;
          fDisk(-(R1+R2)/2, 0, R3,r4,  FILLED) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(-(R1+R2)/2, 0, R3,r4, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fEllipticalArc(-(R1+R2)/2, 0, R3,r4, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          double X = (R1+R2)/2/Math.sqrt(2) ;
          fTeXlabel(-X,X, "cc", "$V_1$") ;
          fTeXlabel(-X,-X, "cc", "$V_2$") ;
          fTeXlabel(L/2,R1-0.13, "tc", "$S_1$") ;
          fTeXlabel(L/2,-R1+0.1, "bc", "$S_2$") ;

          


          

          
          fEnv("lineWidth", 0.5) ;
//          fEnv("useColorPs", "true") ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(-R2-0.5, 0, -(R1+R2)/2+0.1,0) ;
          fTeXlabel(-R2-0.5, 0, "rc", "$S_c$") ;
     }
}
