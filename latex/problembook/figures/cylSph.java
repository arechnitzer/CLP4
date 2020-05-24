                  /*  File:  cylSph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cylSph extends Template {

     static {templateClass = new cylSph() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "cylSph" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  
          xmin = -70 ;
          xmax =  90 ;
          ymin = -70 ;
          ymax =  90 ;
          topmargin = 0.3 ;   // in inches
          bottommargin = -0.3 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
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
          double a = 65 ;
          double r1 = 50 ;
          double R = 80 ;
          double th1 = 0 ;
          double th2 = 90 ;
          double phi1 = 90*0.35 ;
          double phi2 = 90*0.7 ;
          double h  = R*Math.cos(phi1*Math.PI/180);
          double r  = R*Math.sin(phi1*Math.PI/180);

          double xm = 90 ;
          double ym = 90 ;
          double zm = 90 ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,h, 0,0,zm) ;
          fLine3d(0,r,0, 0,ym,0) ;
          fLine3d(r,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;

          // outside sphere
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,R, R,0,0),   0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,R, 0,R,0),   0,90,OPEN)  ;
         fEnv("lineWidth", 2.0) ;
//          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new circ3d(al, 0.5,   0,0,0, R,0,0, 0,R,0),   0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,R, R,0,0),   phi1,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,R, 0,R,0),   phi1,90,OPEN)  ;

          // drill hole
          fCurve(new circ3d(al, 0.5,   0,0,h,   r), 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0,   r), 0,90,OPEN)  ;

          fLine3d(0,r,0, 0,r,h) ;
          fLine3d(r,0,0, r,0, h) ;
          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,h, r, 0,h) ;
          fLine3d(0,0,h, 0, r, h) ;
          fLine3d(0,0,0, r, 0, 0) ;
          fLine3d(0,0,0, 0, r, 0) ;
          fLine3d(0,0,0, 0, 0, h) ;

           // pancake
          fEnv("psFillGray", 0.7) ;
          double hh  = R*Math.cos(phi2*Math.PI/180);
          double rr  = R*Math.sin(phi2*Math.PI/180);
          fCurve(new circ3d(al, 0.5,   0,0,hh,   rr), 0,90,OPEN+FILLED)  ;

          double xa = rr ; double ya = 0  ; double za = hh ;
                       double Xa = xa*x0+ya;  double Ya = xa*x1+za;
          double xb = r  ; double yb = 0  ; double zb = hh ;
                       double Xb = xb*x0+yb;  double Yb = xb*x1+zb;
          double xc = 0  ; double yc = r  ; double zc = hh ;
                       double Xc = xc*x0+yc;  double Yc = xc*x1+zc;
          double xd = 0  ; double yd = rr ; double zd = hh ;
                       double Xd = xd*x0+yd;  double Yd = xd*x1+zd;
          double xe = r/Math.sqrt(2)  ; double ye = r/Math.sqrt(2)  ; double ze = hh ;
                       double Xe = xe*x0+ye;  double Ye = xe*x1+ze;
          double xf = rr/Math.sqrt(2)  ; double yf = rr/Math.sqrt(2) ; double zf = hh ;
                       double Xf = xf*x0+yf;  double Yf = xf*x1+zf;
          {double[] xlist = {Xa, Xb, Xe, Xc, Xd} ; 
           double[] ylist = {Ya, Yb, Ye, Yc, Yd} ; 
           fPolygon(xlist, ylist, 5, FILLED) ;}
          {double[] xlist = {Xd, Xe, Xa, Xf} ; 
           double[] ylist = {Yd, Ye, Ya, Yf} ; 
           fPolygon(xlist, ylist, 4, FILLED) ;}
          fEnv("psFillGray", 1.0) ;
          fCurve(new circ3d(al, 0.5,   0,0,hh,   r), 0,90,FILLED)  ;

          fLine3d(r,0,hh, rr, 0,hh) ;
          fLine3d(0,r,hh, 0, rr, hh) ;
          fCurve(new circ3d(al, 0.5,   0,0,hh,   r), 0,90,OPEN)  ;
          fLine3d(0,0,0.52*hh, 0,0,zm) ;

          fEnv("psFillGray", 0.0) ;
          double rrr = 1.4 ;
          fDisk3d(0, r, h, rrr, rrr) ;
               fTeXlabel3d(0, r+2, h+5, "cl", "$(0,\\sqrt{2}  , \\sqrt{2})$") ;
          fDisk3d(0, rr, hh, rrr, rrr) ;
               fTeXlabel3d(0, rr+3, hh, "cl", "$(0,\\sqrt{4-z^2}  , z)$") ;
          fTeXlabel3d(1.0*R, 0.3*R ,0, "tl", "$x^2+y^2+z^2=4$") ;
          fTeXlabel3d(0.9*r, 0.5*r ,0, "tl", "$\\scriptstyle x^2+y^2=2$") ;


          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fArrow(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double rx, double ry) {
          double X = x*x0+y;
          double Y = x*x1+z;
          fDisk(X,Y,rx,ry, FILLED) ;
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



