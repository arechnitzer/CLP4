                  /*  File:  phaseHyperbola2.java    */


import figPac.* ;
import fnPac.* ;
//import java.applet.* ;
//import java.awt.* ;


public class phaseHyperbola2 extends Template {

     static {templateClass = new phaseHyperbola2() ; }

     public void setup() {
          filePrefix = "phaseHyperbola2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
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
          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          double r = 0.15 ; 
          fDisk(0, 0, r, r, FILLED) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;


          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          double x = 3; double y = 0 ;
          fArrowhead(x,y, 0) ;
          x = -3; y = 0 ;
          fArrowhead(x,y, 180) ;
          y =  3; x = 0 ;
          fArrowhead(x,y, 270) ;
          y =  -3; x = 0 ;
          fArrowhead(x,y, 90) ;
          
          double C = 1 ; x = 3 ;  y = C/x; double th = Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), 0.01, xmax, OPEN) ;
          fArrowhead(x,y, th) ;

          C = 3 ; x = 3 ;  y = C/x ; th = Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), 0.01, xmax, OPEN) ;
          fArrowhead(x,y, th) ;

          C = -1 ; x = 3 ;  y = C/x ;  th = Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), 0.01, xmax, OPEN) ;
          fArrowhead(x,y, th) ;

          C = -3 ; x = 3 ;  y = C/x ;  th = Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), 0.01, xmax, OPEN) ;
          fArrowhead(x,y, th) ;


          C = 1 ; x = -3 ;  y = C/x ;  th = 180+Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), xmin, -0.01, OPEN) ;
          fArrowhead(x,y, th) ;

          C = 3 ; x = -3 ;  y = C/x ;  th = 180+Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), xmin, -0.01, OPEN) ;
          fArrowhead(x,y, th) ;

          C = -1 ; x = -3 ;  y = C/x ;  th = 180+Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), xmin, -0.01, OPEN) ;
          fArrowhead(x,y, th) ;

          C = -3 ; x = -3 ;  y = C/x ;  th = 180+Math.atan(-C/(x*x))*180/Math.PI ;
          fCurve(new hyp1(C), xmin, -0.01, OPEN) ;
          fArrowhead(x,y, th) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ; 

          C = 4 ; double S=1 ; 
          fCurve(new hyp2(C,S), xmin, xmax, OPEN) ;

          C = 1 ; S=1 ; 
          fCurve(new hyp2(C,S), xmin, xmax, OPEN) ;

          C = 4 ; S=-1 ; 
          fCurve(new hyp2(C,S), xmin, xmax, OPEN) ;

          C = 1 ; S=-1 ; 
          fCurve(new hyp2(C,S), xmin, xmax, OPEN) ;

          fLine(0.01, 0.01, xmax, xmax) ;
          fLine(0.01, -0.01, xmax, -xmax) ;
          fLine(-0.01, -0.01, xmin, xmin) ;
          fLine(0.01, 0.01, xmin, -xmin) ;

          C = 4 ; S=1 ; 
          fCurve(new hyp3(C,S), ymin, ymax, OPEN) ;

          C = 1 ; S=1 ; 
          fCurve(new hyp3(C,S), ymin, ymax, OPEN) ;


          C = 4 ; S=-1 ; 
          fCurve(new hyp3(C,S), ymin, ymax, OPEN) ;

          C = 1 ; S=-1 ; 
          fCurve(new hyp3(C,S), ymin, ymax, OPEN) ;






          
     }
}

class hyp1 implements S2S {

     double C = 1 ;

      public hyp1(double C) {
         this.C = C ;
      }

      public double map(double t) {    
          double out = C/t ;
          return out ;
   }
}


class hyp2 implements S2S {

     double C = 1 ;
     double S = 1 ;

      public hyp2(double C, double S) {
         this.C = C ;
         this.S = S ;
      }

      public double map(double t) {    
          double out = S*Math.sqrt(t*t+C) ;
          return out ;
   }
}

class hyp3 implements S2V {

     double C = 1 ;
     double S = 1 ;

      public hyp3(double C, double S) {
         this.C = C ;
         this.S = S ;
      }

      public double[] map(double t) {    
          double[] out = {0,0} ;
          out[0] = S*Math.sqrt(t*t+C) ;
          out[1] = t ;
          return out ;
   }
}


