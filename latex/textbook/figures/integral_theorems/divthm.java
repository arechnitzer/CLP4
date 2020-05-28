                  /*  File:  divthm.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class divthm extends Template {

     static {templateClass = new divthm() ; }



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
     static double[] fwd = {1, 0.15, 0.3} ; 
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
          filePrefix = "divthm" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  

          double Xmin= -10 ;
          double Xmax= 90 ;
          double Ymin= -10 ;
          double Ymax= 90 ;
          double Zmin= -10 ;
          double Zmax= 90 ;
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
          double a = 65 ;
          double r = 80 ;
          double xm = 90 ;
          double ym = 90 ;
          double zm = 90 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;

          double cx, cy, cz1, cz2, h1, h2, rx, ry ;
          cx = 50 ;
          cy = 50 ;
          rx = 25 ;
          ry = 30 ;
          cz1 = 50 ;
          cz2 = 80 ;
          h1 = 15 ;
          h2 = -15 ;


          fEnv("lineWidth", 0.5) ;
          fCurve(new circ3d(proj,   cx,cy,0, rx,0,0, 0,ry,0), 0,360,CLOSED)  ;


          double[] X =new double[4] ;
          double[] Y =new double[4] ;
          double dx = 10 ;
          double dy = 10 ;
          double dz1 = 0 ;
          double dz2 = 0 ;

          X[0] = cx*proj[0][0]+cy*proj[0][1]+0*proj[0][2] ;
          Y[0] = cx*proj[1][0]+cy*proj[1][1]+0*proj[1][2] ;
          X[1] = (cx+dx)*proj[0][0]+cy*proj[0][1]+0*proj[0][2] ;
          Y[1] = (cx+dx)*proj[1][0]+cy*proj[1][1]+0*proj[1][2] ;
          X[2] = (cx+dx)*proj[0][0]+(cy+dy)*proj[0][1]+0*proj[0][2] ;
          Y[2] = (cx+dx)*proj[1][0]+(cy+dy)*proj[1][1]+0*proj[1][2] ;
          X[3] = cx*proj[0][0]+(cy+dy)*proj[0][1]+0*proj[0][2] ;
          Y[3] = cx*proj[1][0]+(cy+dy)*proj[1][1]+0*proj[1][2] ;
          fEnv("psFillGray", 0.7) ;
          fPolygon(X, Y, 4, FILLED) ;

          dz1 = dy*h1/ry ;
          X[0] = cx*proj[0][0]+cy*proj[0][1]+cz1*proj[0][2] ;
          Y[0] = cx*proj[1][0]+cy*proj[1][1]+cz1*proj[1][2] ;
          X[1] = (cx+dx)*proj[0][0]+cy*proj[0][1]+cz1*proj[0][2] ;
          Y[1] = (cx+dx)*proj[1][0]+cy*proj[1][1]+cz1*proj[1][2] ;
          X[2] = (cx+dx)*proj[0][0]+(cy+dy)*proj[0][1]+(cz1+dz1)*proj[0][2] ;
          Y[2] = (cx+dx)*proj[1][0]+(cy+dy)*proj[1][1]+(cz1+dz1)*proj[1][2] ;
          X[3] = cx*proj[0][0]+(cy+dy)*proj[0][1]+(cz1+dz1)*proj[0][2] ;
          Y[3] = cx*proj[1][0]+(cy+dy)*proj[1][1]+(cz1+dz1)*proj[1][2] ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.7) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fPolygon(X, Y, 4, FILLED) ;
          fLine3d(cx, cy, 0, cx, cy, cz1) ;
          fLine3d(cx+dx, cy, 0, cx+dx, cy, cz1) ;
          fLine3d(cx+dx, cy+dy, 0, cx+dx, cy+dy, cz1+dz1) ;
          fLine3d(cx, cy+dy, 0, cx, cy+dy, cz1+dz1) ;

          dz2 = dy*h2/ry ;
          X[0] = cx*proj[0][0]+cy*proj[0][1]+cz2*proj[0][2] ;
          Y[0] = cx*proj[1][0]+cy*proj[1][1]+cz2*proj[1][2] ;
          X[1] = (cx+dx)*proj[0][0]+cy*proj[0][1]+cz2*proj[0][2] ;
          Y[1] = (cx+dx)*proj[1][0]+cy*proj[1][1]+cz2*proj[1][2] ;
          X[2] = (cx+dx)*proj[0][0]+(cy+dy)*proj[0][1]+(cz2+dz2)*proj[0][2] ;
          Y[2] = (cx+dx)*proj[1][0]+(cy+dy)*proj[1][1]+(cz2+dz2)*proj[1][2] ;
          X[3] = cx*proj[0][0]+(cy+dy)*proj[0][1]+(cz2+dz2)*proj[0][2] ;
          Y[3] = cx*proj[1][0]+(cy+dy)*proj[1][1]+(cz2+dz2)*proj[1][2] ;
          fEnv("psFillGray", 0.7) ;
          fPolygon(X, Y, 4, FILLED) ;
          fEnv("lineWidth", 0.7) ;
          fLine3d(cx, cy, cz1, cx, cy, cz2) ;
          fLine3d(cx+dx, cy, cz1, cx+dx, cy, cz2) ;
          fLine3d(cx+dx, cy+dy, cz1+dz1, cx+dx, cy+dy, cz2+dz2) ;
          fLine3d(cx, cy+dy, cz1+dz1, cx, cy+dy, cz2+dz2) ;



          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(proj,   cx,cy,cz1, rx,0,0, 0,ry,h1), -90,90,OPEN)  ;
          fCurve(new circ3d(proj,   cx,cy,cz2, rx,0,0, 0,ry,h2), 0,360,CLOSED)  ;
          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fCurve(new circ3d(proj,   cx,cy,cz1, rx,0,0, 0,ry,h1), 90,270,OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(cx, cy-ry, cz1-h1, cx, cy-ry, cz2-h2) ;


          fTeXlabel3d(cx,cy-10, 0, "cc", "$R_{xy}$") ;
          fTeXlabel3d(cx+rx,cy-ry+3,-7, "bl", "$\\partial R_{xy}$") ;
          fTeXlabel3d(cx+rx,cy-ry,cz1-h1-2, "bl", "$z=B(x,y)$") ;
          fTeXlabel3d(cx+rx,cy-ry+3,cz2-h2+10, "bl", "$z=T(x,y)$") ;
          fTeXlabel3d(cx+rx,cy+ry-12,cz1+9, "tl", "$\\cB$") ;
          fTeXlabel3d(cx+rx,cy+ry-12,cz2+12, "bl", "$\\cT$") ;
          fTeXlabel3d(cx+rx,cy-ry+2,(cz1+cz2)/2, "cr", "$\\cS$") ;






          
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}



