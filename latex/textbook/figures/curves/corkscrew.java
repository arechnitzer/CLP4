                  /*  File:  corkscrew.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class corkscrew extends Template {

     static {templateClass = new corkscrew() ; }

     public void setup() {
          filePrefix = "corkscrew" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*2.5 ;    
          ysize = 1.0*2.5 ;  
          xmin = -50 ;
          xmax =  100 ;
          ymin = -70 ;
          ymax =  70 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 50 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r = 40 ;
          double rc = 2.5 ;
          double h = 2.5 ;
          double z =  70 ;
          double xm = 80 ;
          double ym = 60 ;
          double zm = 60 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double pi = Math.PI ;


          fEnv("lineWidth", 0.5) ;
          fLine(0,0,ym,0) ;
          fLine(0,0,0,zm) ;
          fLine(0,0, xm*x0, xm*x1) ;
          fTeXlabel(ym+4,0, "lc", "$y$") ;
          fTeXlabel(0,zm+4, "bc", "$z$") ;
          fTeXlabel(xm*x0-1, xm*x1-1, "tr", "$x$") ;

          double xx = 0; double yy = 1.5*r; double zz = rc*yy/h;
          double X = xx*x0+yy ;  double Y = xx*x1+zz ;
          fLine(0,0, X, Y) ;
          fTeXlabel(X+2,Y, "cl", "$y=z, x=0$") ;

          fEnv("lineWidth", 1.5) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new corkscrew3d(al, 0.5,   rc, h),0,5.5*pi,OPEN)  ;

          
     }
}


class circ3d implements S2V {

     double al = 45 ;
     double a = 65 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double r = 50.0 ;

   public circ3d(double al, double a, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.a = a ;
        this.projFactor = projFactor ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.r  = r ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+r*Math.cos(t*Math.PI/180) ;
          double y = cy+r*Math.sin(t*Math.PI/180) ;
          double z = cz ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}


class corkscrew3d implements S2V {

     double al = 65 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double rc = 10.0 ;
     double h = 16.0 ;

   public corkscrew3d(double al, double projFactor, 
                      double rc, double h) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.rc  = rc ;
        this.h  = h ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = rc*t*Math.cos(t) ;
          double y = rc*t*Math.sin(t) ;
          double z = h*t ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}



