                  /*  File:  OE12D_4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12D_4 extends Template {

     static {templateClass = new OE12D_4() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE12D_4" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.5*0.75 ;    
          ysize = 4.0*0.75 ;  
          xmin = -1.2 ;
          xmax =  2.3 ;
          ymin = -1.5 ;
          ymax =  3.5 ;
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
          double al = 70 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double X1 = 0 ; double Y1 = 0 ; double Z1 = 0 ;
          double X2 = 0 ; double Y2 = 0 ; double Z2 = 3 ;
          double X3 = 0 ; double Y3 = 1 ; double Z3 = 0 ;
          double X4 = 2 ; double Y4 = 0 ; double Z4 = 0 ;
          double XC1 = 0 ; double YC1 = 0.8*Y2+0.2*Y3 ; double ZC1 = 0.4*Z2+0.6*Z3 ;
          double XC2 = 0.7*X3+0.3*X4 ; double YC2 = 0.2*Y3+0.8*Y4 ; double ZC2 = 0 ;


          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine(0,0,xmax*0.6,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0*1.1, xmax*x1*1.1) ;

          fTeXlabel(xmax*0.6,-0.1, "tr", "$y$") ;
          fTeXlabel(0,ymax+0.1, "bc", "$z$") ;
          fTeXlabel(xmax*x0*1.1, xmax*x1*1.1, "tr", "$x$") ;


          {  double[] xlist = {X1, X2, X3} ;
             double[] ylist = {Y1, Y2, Y3} ;
             double[] zlist = {Z1, Z2, Z3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }

          {  double[] xlist = {X1, X3, X4} ;
             double[] ylist = {Y1, Y3, Y4} ;
             double[] zlist = {Z1, Z3, Z4} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }

          fLine3d(0,0,0, 0,0,3) ;
          fLine3d(0,0,3, 0,1,0) ;
          fLine3d(0,1,0, 2,0,0) ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          {  double[] xlist = {X1, X2, X3, X4} ;
             double[] ylist = {Y1, Y2, Y3, Y4} ;
             double[] zlist = {Z1, Z2, Z3, Z4} ;
             fPolygon3d(xlist, ylist, zlist, 4, OPEN) ; }

          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          double x = 0 ;
          double y = 0 ;
          double z = 3*0.5 ;
          fArrow3d(X1+0.95*x,Y1+0.95*y,Z1+0.95*z, X1+1.05*x,Y1+1.05*y,Z1+1.05*z) ;
          fTeXlabel3d(0,-0.1,1.5,  "cr", "$C$") ;
          x = 0 ;
          y = 1*0.55 ;
          z = -3*0.55 ;
          fArrow3d(X2+0.95*x,Y2+0.95*y,Z2+0.95*z, X2+1.05*x,Y2+1.05*y,Z2+1.05*z) ;
          fTeXlabel3d(0,0.6,1.5,  "cl", "$C$") ;
          x =2*0.55 ;
          y = -1*0.55 ;
          z = 0 ;
          fArrow3d(X3+0.95*x,Y3+0.95*y,Z3+0.95*z, X3+1.05*x,Y3+1.05*y,Z3+1.05*z) ;
          fTeXlabel3d(1.2,0.5,0,  "tl", "$C$") ;
          fTeXlabel3d(1,-0.07,0,  "br", "$L$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine3d(2,0,0, 0,0,0) ;
          x =-2*0.7 ;
          y = 0 ;
          z = 0 ;
          fArrow3d(X4+0.95*x,Y4+0.95*y,Z4+0.95*z, X4+1.05*x,Y4+1.05*y,Z4+1.05*z) ;


          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          double L = 2.5 ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(XC1,YC1,ZC1, XC1-0.5*L,YC1,ZC1) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fArrow3d(XC1-0.5*L,YC1,ZC1, XC1-L,YC1,ZC1) ;
          fTeXlabel3d(XC1-L,YC1,ZC1+0.1,  "lc", "$-\\hi$") ;
          L=1 ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(XC2,YC2,ZC2, XC2,YC2,ZC2-0.4*L) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fArrow3d(XC2,YC2,ZC2-0.4*L, XC2,YC2,ZC2-L) ;
          fTeXlabel3d(XC2,YC2,ZC2-L,  "lc", "$-\\hk$") ;

          fLine(0,0,xmax*0.6,0) ;

          fTeXlabel3d(X4,Y4-0.05,Z4,  "rb", "$(2,0,0)$") ;
          fTeXlabel3d(X3,Y3,Z3+0.1,  "lb", "$(0,1,0)$") ;
          fTeXlabel3d(X2,Y2-0.05,Z2,  "cr", "$(0,0,3)$") ;

//          fTeXlabel3d(XC1-L,YC1,ZC1-1.0,  "cc", "${\\scriptstyle T_1}$") ;
//          fTeXlabel3d(XC2-0.13,YC2+0.2,ZC2,  "cc", "${\\scriptstyle T_2}$") ;
          fTeXlabel3d(XC1-L,YC1,ZC1-1.0,  "cc", "$T_1$") ;
          fTeXlabel3d(XC2-0.13,YC2+0.2,ZC2,  "cc", "$T_2$") ;


          
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

     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*x0+ylist[i] ;
               yy[i] = xlist[i]*x1+zlist[i] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
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




