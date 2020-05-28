                  /*  File:  OE17D_4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE17D_4 extends Template {

     static {templateClass = new OE17D_4() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE17D_4" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.3 ;    
          ysize = 2.0 ;  
          xmin = -0.8 ;
          xmax =  3.2 ;
          ymin = -1.2 ;
          ymax =  2.3 ;
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
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double X1 = 0 ; double Y1 = 0   ; double Z1 = 0 ;
          double X2 = 2 ; double Y2 = 0   ; double Z2 = 0 ;
          double X3 = 0 ; double Y3 = 0   ; double Z3 = 2 ;
          double X4 = 0 ; double Y4 = 3   ; double Z4 = 0 ;
          double X5 = 0 ; double Y5 = 0   ; double Z5 = 0 ;

          double dX1 = X2-X1 ; double dY1 = Y2-Y1 ; double dZ1 = Z2-Z1 ;
          double dX2 = X3-X2 ; double dY2 = Y3-Y2 ; double dZ2 = Z3-Z2 ;
          double dX3 = X4-X3 ; double dY3 = Y4-Y3 ; double dZ3 = Z4-Z3 ;
          double dX4 = X5-X4 ; double dY4 = Y5-Y4 ; double dZ4 = Z5-Z4 ;


          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;

          {  double[] xlist = {X1, X2, X3} ;
             double[] ylist = {Y1, Y2, Y3} ;
             double[] zlist = {Z1, Z2, Z3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }


          {  double[] xlist = {X1, X3, X4} ;
             double[] ylist = {Y1, Y3, Y4} ;
             double[] zlist = {Z1, Z3, Z4} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }

          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0*0.75, xmax*x1*0.75) ;


//          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
//          fLine3d(0,0,0, 2,0,0) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


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
             fPolygon3d(xlist, ylist, zlist, 4, CLOSED) ; }

          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          fArrow3d(X1,Y1,Z1, X1+0.6*dX1,Y1+0.6*dY1,Z1+0.6*dZ1) ;
          fArrow3d(X2,Y2,Z2, X2+0.6*dX2,Y2+0.6*dY2,Z2+0.6*dZ2) ;
          fArrow3d(X3,Y3,Z3, X3+0.6*dX3,Y3+0.6*dY3,Z3+0.6*dZ3) ;
          fArrow3d(X4,Y4,Z4, X4+0.6*dX4,Y4+0.6*dY4,Z4+0.6*dZ4) ;
//          fEnv("lineWidth", 0.5) ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//
//          fEnv("lineWidth", 0.5) ;
//          fEnv("headHalfWidth", 2.0*1.2) ;
//          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
//          double L = 1.0 ;
//          fArrow3d(XC,YC,ZC, XC+L,YC+L,ZC+L) ;
//          fTeXlabel3d(XC+L*1.05,YC+L*1.05,ZC+L*1.05,  "lb", "$\\hn$") ;
          double r = 0.07 ;
          fDisk3d(X1,Y1,Z1, r,r, FILLED) ;
          fDisk3d(X2,Y2,Z2, r,r, FILLED) ;
          fTeXlabel3d(X2,Y2-0.07,Z2,  "br", "$(2,0,0)$") ;
          fDisk3d(X3,Y3,Z3, r,r, FILLED) ;
          fTeXlabel3d(X3,Y3-0.07,Z3,  "rc", "$(0,0,2)$") ;
          fDisk3d(X4,Y4,Z4, r,r, FILLED) ;
          fTeXlabel3d(X4,Y4-0.05,Z4-0.05,  "rt", "$(0,3,0)$") ;


          fTeXlabel3d(0.7, 0, 0.4,  "cc", "$S_x$") ;
          fTeXlabel3d(0, 1, 0.5,  "cc", "$S_y$") ;


          fTeXlabel(xmax+0.05,0, "cl", "$y$") ;
          fTeXlabel(0,ymax+0.05, "bc", "$z$") ;
          fTeXlabel(xmax*x0*0.77, xmax*x1*0.77, "tr", "$x$") ;
          
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




