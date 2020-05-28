                  /*  File:  surfaceProj.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class surfaceProj extends Template {

     static {templateClass = new surfaceProj() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "surfaceProj" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0 ;  
          xmin = -70 ;
          xmax =  110 ;
          ymin = -70 ;
          ymax =  90 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 60 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double X1 = 90 ; double Y1 = 50 ; double Z1 = 55 ;
          double X2 = 90 ; double Y2 = 90 ; double Z2 = 80 ;
          double X3 = 40 ; double Y3 = 90 ; double Z3 = 80 ;
          double X4 = 40 ; double Y4 = 50 ; double Z4 = 55 ;
          double XC = (X1+X3)/2 ; double YC = (Y1+Y2)/2 ; double ZC = (Z1+Z2)/2 ;


          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine3d(X1,Y1,Z1, X2,Y2,Z2) ;
          fLine3d(X2,Y2,Z2, X3,Y3,Z3) ;
          fLine3d(X3,Y3,Z3, X4,Y4,Z4) ;
          fLine3d(X4,Y4,Z4, X1,Y1,Z1) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(X1,Y1,0, X2,Y2,0) ;
          fLine3d(X2,Y2,0, X3,Y3,0) ;
          fLine3d(X3,Y3,0, X4,Y4,0) ;
          fLine3d(X4,Y4,0, X1,Y1,0) ;
          fTeXlabel3d( 0.5*(X2+X3), Y2+4, 0, "cl", "$\\dee{x}$") ;
          fTeXlabel3d( X2+6, 0.5*(Y1+Y2), 0, "ct", "$\\dee{y}$") ;


          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double L = Math.sqrt(1 + (Z2-Z1)*(Z2-Z1) + (Y2-Y1)*(Y2-Y1)) ;
          fArrow3d(XC,YC,ZC, XC,YC,ZC+L) ;
          fArrow3d(XC,YC,ZC, XC,YC-(Z2-Z1),ZC+(Y2-Y1)) ;
          fTeXlabel3d(XC,YC-(Z2-Z1)-3,ZC+(Y2-Y1),  "rc", "$\\hn$") ;
          fTeXlabel3d(XC,YC+4,ZC+L,  "lc", "$\\hk$") ;


          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fLine3d(X1,Y1,0, X1,Y1,Z1) ;
          fLine3d(X2,Y2,0, X2,Y2,Z2) ;
          fLine3d(X3,Y3,0, X3,Y3,Z3) ;
          fLine3d(X4,Y4,0, X4,Y4,Z4) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0-1.5, xmax*x1-1.5, "tr", "$x$") ;
          fTeXlabel3d(XC,YC-5,ZC+15,  "bc", "$\\theta$") ;
          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*x0+y;
          double Y = x*x1+z ;
          fDisk(X,Y,r1,r2,TYPE) ;
     }

     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fArrow(X1,Y1,X2,Y2) ;
     }

     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

}

class circ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = r ; ;
        this.ya = 0 ;
        this.za = 0 ;
        this.xb = 0 ;
        this.yb = r ;
        this.zb = 0 ;
   }


   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.projFactor = projFactor ;
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = xa ;
        this.ya = ya ;
        this.za = za ;
        this.xb = xb ;
        this.yb = yb ;
        this.zb = zb ;
   }

     public double[] map(double t) {
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




