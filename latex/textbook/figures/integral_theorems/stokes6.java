                  /*  File:  stokes6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class stokes6 extends Template {

     static {templateClass = new stokes6() ; }



// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     // cabinet projection
//     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     static double[] view = {1, -proj[0][0], -proj[1][0]} ;

////  Orthogonal isometric projection with direction of view (1,1,1).  
//     static double[][] proj = { {-Math.sqrt(3)/2.0, Math.sqrt(3)/2.0, 0},
//                                {             -0.5,             -0.5, 1}   } ;
//     static double[] view = {1, 1, 1} ;

////  General orthogonal projection.  
     static double[] fwd = {1, -0.15, 0.3} ; 
     static double[] up = {0,0,1} ;
     static double Lfwd = Math.sqrt(fwd[0]*fwd[0]+fwd[1]*fwd[1]+fwd[2]*fwd[2]) ; 
     static double[] Nfwd = {fwd[0]/Lfwd,fwd[1]/Lfwd,fwd[2]/Lfwd} ; 

     static double Dot = Nfwd[0]*up[0]+Nfwd[1]*up[1]+Nfwd[2]*up[2] ; 
     static double[] Iup = {up[0]-Dot*Nfwd[0],up[1]-Dot*Nfwd[1],up[2]-Dot*Nfwd[2]};
     static double Lup = Math.sqrt(Iup[0]*Iup[0]+Iup[1]*Iup[1]+Iup[2]*Iup[2]) ; 
     static double[] Nup = {Iup[0]/Lup,Iup[1]/Lup,Iup[2]/Lup} ; 
     static double[] Nleft = {-Nfwd[1]*Nup[2]+Nfwd[2]*Nup[1],
                              -Nfwd[2]*Nup[0]+Nfwd[0]*Nup[2],
                              -Nfwd[0]*Nup[1]+Nfwd[1]*Nup[0]} ; 

     static double[][] proj = { {Nleft[0], Nleft[1], Nleft[2]},
                                { Nup[0],  Nup[1], Nup[2]}   } ;
     static double[] view = {fwd[0], fwd[1], fwd[2]} ;



     public void setup() {
          filePrefix = "stokes6" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  

          double Xmin= -2 ;
          double Xmax=  2 ;
          double Ymin=  -2 ;
          double Ymax=  2 ;
          double Zmin=  0 ;
          double Zmax=  2.5 ;
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


          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double a = 65 ;
          double r = 80 ;


          fEnv("lineWidth", 0.5) ;
//          fLine3d(0,0,0, 0,0,zm) ;
//          fLine3d(0,0,0, 0,ym,0) ;
//          fLine3d(0,0,0, xm,0,0) ;
//          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
//          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
//          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;

          double ax, ay, az, bx, by, bz ;
          ax = 1 ;
          ay = Math.sqrt(2) ;
          az = Math.sqrt(3) ;
          bz = 2.3 ;
          bx = Math.sqrt(bz) ;
          by = Math.sqrt(bz/2) ;

          fEnv("lineWidth", 1.3) ;
          fCurve(new circ3d(proj, 0,0,0, ax,0,0, 0,ay,0), 0,360,OPEN)  ;
          fCurve(new circ3d(proj, 0,0,0, 0,ay,0, 0,0,az), 0,180,OPEN)  ;
          fTeXlabel3d(0, ay+0.05, 0.2, "bl", "$x^2+\\frac{y^2}{2}+\\frac{z^2}{3}=1$") ;


          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new circ3d(proj, 0,0,bz, bx,0,0, 0,by,0), 0,360,OPEN)  ;
          fCurve(new para3d(proj, 8) , -by, by,OPEN)  ;
          fTeXlabel3d(0, by+0.05, bz-0.1, "tl", "$z=x^2+2y^2$") ;


          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new intersect3d(proj, +1) , -0.8355, 0.8355,OPEN)  ;
          fCurve(new intersect3d(proj, -1) , -0.8355, 0.8355,OPEN)  ;
          canvas.append( new fPsWrite(Black+"\n")) ;



//          fEnv("lineWidth", 0.5) ;
//          fCurve(new circ3d(proj, cx,cy,cz, 2*rx,0,0, 0,2*ry,0), 0,180,OPEN)  ;
//          fEnv("lineWidth", 1.0) ;
//          fEnv("psFillGray", 0.8) ;
//          fCurve(new circ3d(proj, cx,cy,cz, 2*rx,0,0, 0,ry*s2,ry*s2), 
//                             0,360,FILLED)  ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fCurve(new circ3d(proj, cx,cy,cz, 2*rx,0,0, 0,ry*s2,ry*s2), 
//                             0,360,CLOSED)  ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//
//          fEnv("lineWidth", 0.5) ;
//          fCurve(new circ3d(proj, cx,cy,cz, 2*rx,0,0, 0,2*ry,0),180, 360,OPEN)  ;
////          fCurve(new circ3d(proj, cx,cy,cz, 2*rx,0,0, 0,0,2*ry), 0,360,OPEN)  ;
//          fCurve(new circ3d(proj, cx,cy,cz, 0,2*ry,0, 0,0,2*ry), 0,360,OPEN)  ;
//          
//          fTeXlabel3d(cx, cy+r/1.6, cz-r/1.6, "cc", "$S''$") ;
//          fTeXlabel3d(cx, cy-r/1.6, cz+r/1.6, "cc", "$S'$") ;
//          fTeXlabel3d(cx, cy+r/3.0, cz+r/3.0, "cc", "$S$") ;

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


class para3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double th = 0 ;
     double cth = 1 ;
     double sth = 0 ;

   public para3d(double[][] proj, double th) {
        this.proj = proj ;
        this.th = th*Math.PI/180 ;
        cth = Math.cos(this.th) ;
        sth = Math.sin(this.th) ;
   }


     public double[] map(double t) {
          double[] out = {0,0} ;
          double x = sth*t ;
          double y = cth*t ;
          double z = x*x+2*y*y;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}

class intersect3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double sign = +1 ;

   public intersect3d(double[][] proj, double sign) {
        this.proj = proj ;
        this.sign  = sign ;
   }


     public double[] map(double t) {
          double[] out = {0,0} ;
          double y = t ;
          double z = Math.sqrt(21.0/4.0+9.0*y*y/2.0)-3.0/2.0 ;
          double x = sign*Math.sqrt(z-2*y*y) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}



