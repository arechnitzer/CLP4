                  /*  File:  helix2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class helix2 extends Template {

     static {templateClass = new helix2() ; }

     public void setup() {
          filePrefix = "helix2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*2.5 ;    
          ysize = 1.0*2.5 ;  
          xmin = -50 ;
          xmax =  100 ;
          ymin = -70 ;
          ymax =  130 ;
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
          double h = 15 ;
          double z = 100 ;
          double xm = 80 ;
          double ym = 60 ;
          double zm = 130 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 0.5) ;
          fLine(0,0,ym,0) ;
          fLine(0,0,0,zm) ;
          fLine(0,0, xm*x0, xm*x1) ;
          fTeXlabel(ym+4,0, "lc", "$y$") ;
          fTeXlabel(0,zm+4, "bc", "$z$") ;
          fTeXlabel(xm*x0-1, xm*x1-1, "tr", "$x$") ;

          fCurve(new circ3d(al, a, 0.5,   0,0,0, r*0.97),270,450,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,0, r*0.97),90,270,OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,z, r*0.97),0,360,OPEN)  ;
          fLine(r,0, r, z+0.8) ;
          fLine(-r,-0.8, -r, z-0.9) ;

          fEnv("lineWidth", 1.5) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new helix3d(al, 0.5,   0,0,0, r*0.97, h),0,90,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new helix3d(al, 0.5,   0,0,0, r*0.97, h),90,270,OPEN)  ;
          fCurve(new helix3d(al, 0.5,   0,0,0, r*0.97, h),450,630,OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fCurve(new helix3d(al, 0.5,   0,0,0, r*0.97, h),270,450,OPEN)  ;
          double xx = r; double yy = 0; double zz = 0;
          double X = xx*x0+yy ;  double Y = xx*x1+zz ;
          double R = 2.0;
          fEnv("psFillColor", Red) ;
          fDisk(X, Y, R, R*aspect, FILLED) ;
          fTeXlabel(X-3,Y-5, "tl", "$t=0$") ;
          xx = 0; yy = r; zz = h*90/100;
          X = xx*x0+yy ;  Y = xx*x1+zz ;
          fDisk(X, Y, R, R*aspect, FILLED) ;
          fTeXlabel(X+5,Y, "lb", "$t=\\frac{\\pi}{2}$") ;
          xx = 0; yy = -r; zz = h*270/100;
          X = xx*x0+yy ;  Y = xx*x1+zz ;
          fDisk(X, Y, R, R*aspect, FILLED) ;
          fTeXlabel(X-5,Y, "cr", "$t=\\frac{3\\pi}{2}$") ;
          xx = 0; yy = r; zz = h*450/100;
          X = xx*x0+yy ;  Y = xx*x1+zz ;
          fDisk(X, Y, R, R*aspect, FILLED) ;
          fTeXlabel(X+5,Y, "cl", "$t=\\frac{5\\pi}{2}$") ;

          
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


class helix3d implements S2V {

     double al = 65 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double r = 50.0 ;
     double h = 16.0 ;

   public helix3d(double al, double projFactor, 
                 double cx, double cy, double cz, double r, double h) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.r  = r ;
        this.h  = h ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+r*Math.cos(t*Math.PI/180) ;
          double y = cy+r*Math.sin(t*Math.PI/180) ;
          double z = cz + h*t/100 ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}



