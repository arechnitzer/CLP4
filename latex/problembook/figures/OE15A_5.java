                  /*  File:  OE15A_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE15A_5 extends Template {

     static {templateClass = new OE15A_5() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;




// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     // cabinet projection
     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;




     public void setup() {
          filePrefix = "OE15A_5" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 2.0 ;  

          double Xmin= -0.1 ;
          double Xmax= 3.2 ;
          double Ymin= -0.1 ;
          double Ymax= 3.2 ;
          double Zmin= -0.2 ;
          double Zmax= 4.0 ;
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
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
//          useZoom = true ;
//          useDrag = true ;
//          showCoords = true ;
//          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double Y = 2.5 ;
          double Z = 3.5 ; 
//          double YY = 2.5 ;
//          double ZZ = 0.5*Math.exp(YY/1.5) ; 
//          double XX1 = YY*proj[0][1]+ZZ*proj[0][2] ;
//          double YY1 = YY*proj[1][1]+ZZ*proj[1][2] ;
          double r = 0.1 ;
          double h = 1 ;
          double s = 0.9 ;

          double xm = 3.2 ;
          double ym = 3.2 ;
          double zm = 4.0 ;
          int nth = 5 ;
          int nphi = 1 ;
          double dth = 90/nth ;
          double dphi = 90/nphi ;

          fEnv("psFillGray", 0.9) ;
          fCurve(new circ3d(proj,   0,0,Z, 0,Y,0, Y,0,0),
                      0,90,FILLED)  ;
          { double[] xlist = {Z*proj[0][2], Y*proj[0][1]+Z*proj[0][2], Y*proj[0][0]+Z*proj[0][2]} ;
            double[] ylist = {Z*proj[1][2], Y*proj[1][1]+Z*proj[1][2], Y*proj[1][0]+Z*proj[1][2]} ;
            fPolygon(xlist, ylist, 3, FILLED) ; }
          fEnv("psFillGray", 0.85) ;
          fCurve(new ellipse(proj, Y, h, s), 0,90,FILLED)  ;
          { double[] xlist = {h*proj[0][2], Y*proj[0][1]+h*proj[0][2], 0.5*Y*proj[0][0]+0.5*Y*proj[0][1]+h*proj[0][2], Y*proj[0][0]+h*proj[0][2]} ;
            double[] ylist = {h*proj[1][2], Y*proj[1][1]+h*proj[1][2], 0.5*Y*proj[1][0]+0.5*Y*proj[1][1]+(h+0.6*Y*s)*proj[1][2], Y*proj[1][0]+(h+Y*s)*proj[1][2]} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,Z, 0,0,zm) ;
          fLine3d(0,Y,0, 0,ym,0) ;
          fLine3d(Y,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.05,-0.05,0, "tr", "$x$") ;
          fTeXlabel3d(0, Y+0.1,0.6*Z, "cl", "$x^2+y^2=4$") ;

          fLine3d(0,0,Z,  0,Y,Z) ;
          fLine3d(0,0,Z,  Y,0,Z) ;

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine3d(0,0,0,  0,Y,0) ;
          fLine3d(0,0,0,  Y,0,0) ;
          fLine3d(0,0,0,  0,0,Z) ;
          fEnv("lineWidth", 1.5) ;
          fLine3d(0,0,h,  0,Y,h) ;
          fLine3d(0,0,h,  Y,0,h+Y*s) ;
          
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("lineWidth", 2.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new circ3d(proj,   0,0,Z, 0,Y,0, Y,0,0),
                      0,90,OPEN)  ;
          fCurve(new circ3d(proj,   0,0,0, 0,Y,0, Y,0,0),
                      0,90,OPEN)  ;
          fLine3d(0,Y,0, 0,Y,Z) ;
          fLine3d(Y,0,0, Y,0,Z) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fCurve(new ellipse(proj, Y, h, s), 0,90,OPEN)  ;
          double th = 45 ;
          double x1 = Y*Math.cos(th*Math.PI/180.0) ;
          double y1 = Y*Math.sin(th*Math.PI/180.0) ;
          double z1 = s*x1+h ;
          th = 44 ;
          double x2 = Y*Math.cos(th*Math.PI/180.0) ;
          double y2 = Y*Math.sin(th*Math.PI/180.0) ;
          double z2 = s*x2+h ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrow3d(x1,y1,z1, x2,y2,z2) ;
          fTeXlabel3d(x2,y2,z2+0.1, "bl", "$C$") ;
          fTeXlabel3d(0.5*Y,0.4*Y, 0.45*s*Y+h, "cc", "$S$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          double l = 0.6 ;
          fArrow3d(0,0,h, 1.5*l,0,h-l) ;
          fTeXlabel3d(1.5*l,0.1,h-l+0.4, "br", "$\\hn$") ;




          
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

class ellipse implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double R = 1 ;
     double h = 1 ;
     double s = 0.7 ;

   public ellipse(double[][] proj, double R, double h, double s) {
        this.proj = proj ;
        this.R = R ;
        this.h = h ;
        this.s = s ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = R*Math.cos(t*Math.PI/180.0) ;
          double y = R*Math.sin(t*Math.PI/180.0) ;
          double z = s*x+h ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}





