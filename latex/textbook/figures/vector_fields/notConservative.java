                  /*  File:  notConservative.java    */


import figPac.* ;
import fnPac.* ;
//import java.applet.* ;
//import java.awt.* ;


public class notConservative extends Template {

     static {templateClass = new notConservative() ; }

     public void setup() {
          filePrefix = "notConservative" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.2, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          double th = 350 ; double thRad = th*Math.PI/180 ;
          double x = 4*Math.cos(thRad) ; double y = 4*Math.sin(thRad) ;
          fEllipticalArc(0, 0, 4, 4, 0, th, OPEN) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrowhead(x,y, th+90) ;



          fEnv("lineWidth", 0.5) ;
          fEnv("useColorPs", "false") ;
//          fEnv("psGray", 0.6) ;
          fEnv("psFillGray", 1.0) ;

          th = 0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          double r = 0.15 ; 
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.1,y+0.1, "bl", "$\\varphi=0$") ;

          th = 45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.3,y+0.1, "cl", "$\\varphi=\\pi/8$") ;

          th = 45 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.3,y+0.1, "cl", "$\\varphi=2\\pi/8$") ;

          th = 3*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.1,y+0.1, "bl", "$\\varphi=3\\pi/8$") ;

          th = 90 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
//          fTeXlabel(x+0.1,y+0.1, "bl", "$\\varphi=\\pi/2$") ;


          th = 5*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.1,y+0.1, "br", "$\\varphi=5\\pi/8$") ;

          th = 6*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.3,y+0.1, "cr", "$\\varphi=6\\pi/8$") ;

          th = 7*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.3,y+0.1, "cr", "$\\varphi=7\\pi/8$") ;

          th = 8*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.1,y+0.1, "br", "$\\varphi=\\pi$") ;

          th = 9*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.3,y-0.1, "cr", "$\\varphi=9\\pi/8$") ;

          th = 10*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.3,y-0.1, "cr", "$\\varphi=10\\pi/8$") ;

          th = 11*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x-0.3,y+0.1, "tr", "$\\varphi=11\\pi/8$") ;

          th = 12*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
//          fTeXlabel(x-0.1,y+0.1, "br", "$\\varphi=\\pi$") ;

          th = 13*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.2,y+0.15, "tl", "$\\varphi=13\\pi/8$") ;

          th = 14*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.3,y-0.05, "cl", "$\\varphi=14\\pi/8$") ;

          th = 15*45/2.0 ;thRad = th*Math.PI/180 ;
          x = 4*Math.cos(thRad) ; y = 4*Math.sin(thRad) ;
          fDisk(x, y, r, r, FILLED+CLOSED) ;
          fTeXlabel(x+0.3,y-0.05, "cl", "$\\varphi=15\\pi/8$") ;


          




          
     }
}


