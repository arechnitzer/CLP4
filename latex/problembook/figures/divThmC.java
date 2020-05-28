                  /*  File: divThmC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class divThmC extends Template {

     static {templateClass = new divThmC() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;




// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 30 ;
     // cabinet projection
     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;




     public void setup() {
          filePrefix = "divThmC" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 2.0 ;  

          double Xmin= -0.1 ;
          double Xmax= 1.3 ;
          double Ymin= -0.1 ;
          double Ymax= 1.3 ;
          double Zmin= -0.1 ;
          double Zmax= 1.3 ;
          xmin = xmax = Xmin*proj[0][0]+Ymin*proj[0][1]+Zmin*proj[0][2] ;
          ymin = ymax = Xmin*proj[1][0]+Ymin*proj[1][1]+Zmin*proj[1][2] ;
          double Dx = (Xmax-Xmin)*proj[0][0] ;
          double Dy = (Xmax-Xmin)*proj[1][0] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
          Dx = (Ymax-Ymin)*proj[0][1] ;
          Dy = (Ymax-Ymin)*proj[1][1] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
          Dx = (Zmax-Zmin)*proj[0][2] ;
          Dy = (Zmax-Zmin)*proj[1][2] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;


//          xmin = -70 ;
//          xmax =  90 ;
//          ymin = -70 ;
//          ymax =  90 ;
          topmargin = 00 ;   // in inches
          bottommargin = -0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
//          useZoom = true ;
//          useDrag = true ;
//          showCoords = true ;
//          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
//          double al = 30 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double Y = 1.0 ;
          double Z = 1.0 ; 
          double ZZ = 0.5 ; 
          double YY = Math.sqrt(1-ZZ) ;
          double r = 0.1 ;

          double xm = 1.3 ;
          double ym = 1.2 ;
          double zm = 1.2 ;
          int nth = 5 ;
          int nphi = 1 ;
          double dth = 90/nth ;
          double dphi = 90/nphi ;

          fEnv("psFillGray", 0.8) ;
          fCurve(new circ3d(proj,   0,0,0, 0,Y,0, Y,0,0),
                      0,90,FILLED)  ;

         {  double[] xlist = {0, 0, 0.7*Y, Y} ;
            double[] ylist = {0, Y, 0.7*Y, 0} ;
            double[] zlist = {0, 0,    0,  0} ;
            fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,Z, 0,0,zm) ;
          fLine3d(0,Y,0, 0,ym,0) ;
          fLine3d(Y,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.05, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.05,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.03,0,0, "tr", "$x$") ;
//          fTeXlabel3d(0, 1.1*YY,ZZ, "cl", "${\\scriptstyle x^2+y^2=1-z}$") ;
          fTeXlabel3d(0, 1.1*YY,ZZ, "cl", "$x^2+y^2=1-z$") ;
//          fTeXlabel3d(0.6*Y, 0.95*Y,0, "cl", "$x^2+y^2=1$") ;
          fTeXlabel3d(0.4*Y, 0.4*Y,0, "cc", "$D$") ;
//          fTeXlabel3d(0, 0.95*Y,0.45*Z, "cc", "$S$") ;

//          fLine3d(0,0,Z,  0,Y,Z) ;
//          fLine3d(0,0,Z,  Y,0,Z) ;
//          fLine3d(0,0,0, xm,0,0) ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(0,0,0,   0,0,Z) ;
          fLine3d(0,0,0,   Y,0,0) ;
          fLine3d(0,0,0,   0,Y,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
//          String Blue = "1 1 0 0 setcmykcolor  " ;
//          String Lblue = "1 0.1 0 0 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Lblue = "0 0.4 0.6 setrgbcolor  " ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fCurve(new revYZ(proj),  0,1,OPEN)  ;
          fCurve(new revXZ(proj),  0,1,OPEN)  ;
          fCurve(new circ3d(proj,   0,0,0, 0,Y,0, Y,0,0),
                      0,90,OPEN)  ;

          fEnv("lineWidth", 5.0) ;
          canvas.append( new fPsWrite(Lblue+"\n")) ;
          fEnv("psFillColor", Blue) ;
//          fEnv("useColorPs", "false") ;
          double ZZZ=ZZ+0.025 ;
          double YYY= Math.sqrt(1-ZZZ) ;
          double S2 = Math.sqrt(2)*1.1 ;
          fCurve(new circ3d(proj,   0,0,ZZZ, 0,YYY,0, YYY,0,0),
                      0,90,FILLED)  ;
          fCurve(new circ3d(proj,   0,0,ZZ, 0,YY,0, YY,0,0),
                      0,90,OPEN)  ;
          double X0 = ZZZ*proj[0][2] ;   double Y0 = ZZZ*proj[1][2] ;
          double X1 = YYY*proj[0][1]+ZZZ*proj[0][2] ;
          double Y1 = YYY*proj[1][1]+ZZZ*proj[1][2] ;
          double X2 = YYY*proj[0][0]/S2+YYY*proj[0][1]/S2+ZZZ*proj[0][2] ;
          double Y2 = YYY*proj[1][0]/S2+YYY*proj[1][1]/S2+ZZZ*proj[1][2] ;
          double X3 = YYY*proj[0][0]+ZZZ*proj[0][2] ;
          double Y3 = YYY*proj[1][0]+ZZZ*proj[1][2] ;
          { double[] xlist = {X0, X1, X2, X3} ;
            double[] ylist = {Y0, Y1, Y2, Y3} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

          
     }


     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fArrow(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;

          fTeXlabel(X, Y, biase, label) ;
     }

     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*proj[0][0]+ylist[i]*proj[0][1]+zlist[i]*proj[0][2] ;
               yy[i] = xlist[i]*proj[1][0]+ylist[i]*proj[1][1]+zlist[i]*proj[1][2] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
     }
}




class circ3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, double r) {
        this.proj = proj ;
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


   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.proj = proj ;
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
          
//          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
//          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

//          out[0] = x*x0+y ;
//          out[1] = x*x1+z;
          return out ;
   }
}

class revYZ implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public revYZ(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double y = t ;
          double z = 1-t*t ;
          double x = 0 ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}


class revXZ implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public revXZ(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = t ;
          double z = 1-t*t ;
          double y = 0 ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}




