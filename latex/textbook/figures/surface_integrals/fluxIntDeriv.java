                  /*  File: fluxIntDeriv.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fluxIntDeriv extends Template {

     static {templateClass = new fluxIntDeriv() ; }

     public void setup() {
          filePrefix = "fluxIntDeriv" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.3 ;      // in inches
          ysize = 5.0*0.3 ;   // in inches. 
          xmin = -2.3 ;
          xmax = 2.7 ;
          ymin = -3.0 ;
          ymax = 2.0 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          double x,y ;
          double t = 0.4 ;

          double x1 = -0.5 ;
          double y1 = 0 ;
          double x2 = 0.5 ;
          double y2 = 0 ;
          double nx = 2*(y1-y2) ;
          double ny = 2*(x2-x1) ;
          
          double vdtX = 1.5 ;
          double vdtY = 2.0 ;
          double x3 = x1+vdtX ;  
          double y3 = y1+vdtY ;
          double x4 = x2+vdtX ;
          double y4 = y2+vdtY ;

          double x5 = x1-vdtX ;  
          double y5 = y1-vdtY ;
          double x6 = x2-vdtX ;
          double y6 = y2-vdtY ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine(2.0*x1, y1, 2.0*x2,y2) ;

          { double[] xlist = {x1, x2, x4, x3} ;
            double[] ylist = {y1, y2, y4, y3} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

          fEnv("psFillGray", 0.6) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          String GGreen = "1 0 1 0.2 setcmykcolor  " ;

//          fEnv("useColorPs", "true") ;


//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fEnv("psFillColor", Blue) ; 
          { double[] xlist = {x1, x2, x6, x5} ;
            double[] ylist = {y1, y2, y6, y5} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }

//          { double[] xlist = {x1, x2, x4, x3} ;
//            double[] ylist = {y1, y2, y4, y3} ;
//            fPolygon(xlist, ylist, 4, CLOSED) ; }


          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite(GGreen+"\n")) ;
          fLine(x1,y1,  x2,y2) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(x6,y6,  x5,y5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(x3,y3,  x4,y4) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fArrow(x1, y1, x1+nx, y1+ny) ;
          double th1=Math.atan(vdtY/vdtX)*180/Math.PI ;
          double th2=Math.atan(ny/nx)*180/Math.PI ;
          double r = 0.4 ;
          fEllipticalArc(x1,y1, r,r, th1, th2, OPEN) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fArrow(x1, y1, x3, y3) ;
          fArrow(x2, y2, x4, y4) ;
          fArrow(x5, y5, x1, y1) ;
          fArrow(x6, y6, x2, y2) ;
          
          fTeXlabel((x1+x5)/2-0.1, (y1+y5)/2+0.1, "cr", "$\\vv\\dee{t}$") ;
          fTeXlabel(x3-0.3, y3-0.1, "cr", "$\\vv\\dee{t}$") ;
          fTeXlabel((x2+x4)/2+0.2, (y2+y4)/2+0.1, "cl", "$\\vv\\dee{t}$") ;
          fTeXlabel((x2+x6)/2+0.2, (y2+y6)/2+0.1, "cl", "$\\vv\\dee{t}$") ;
          fTeXlabel(x1+nx-0.1, y1+ny-0.1, "cr", "$\\hn$") ;
          fTeXlabel(x1+0.25, y1+0.7, "cc", "$\\theta$") ;

          
     }
}
