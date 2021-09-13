/*
===========MADE BY PHYSIC DEV (Physic Gamer)===========

you can use this for your own project but i would apreciate 
you mention that this was done by me.

=====================================================
*/
/* ComplexCellular1D

this class change some function of the Cellular1D class
to create automata that depends of the exact configuration of a neighbors instead of the sum of neighbors's states

for more informations refers to Cellular1D
*/


public class ComplexCellular1D extends Cellular1D {
	int MaxRule=256;
	int cells=3;
	
	// the constructor is the same except the maxRule Value is higher.
	ComplexCellular1D(int L, int N, int T) {
		super(L, N, T);
		MaxRule=(int)Math.pow(T,Math.pow(T,N));
	}
	
	//the sum function is no longer a sum, now it convert the neighbor exact configurations in a number.
	public int sum(int x) {
		int S=0,p=(int)Math.pow(t,2*n);
		for(int i=x-n;i<=n+x;i++){S+=p*state[(i+l)%l];p/=2;}
		return S;
	}
	
	//the same function as above but optimized to reduce complexity
	public int sum(int x,int last){return (int) (last-Math.pow(t,2*n)*state[(x-n-1+l)%l])*t+state[(x+n)%l];}
	
	//the new function to compute rule Array
	public int[] RuleDat(){
		int[] Out= new int[(int) Math.pow(t,2*n+1)];
		for(int i=0;i<Out.length;i++)Out[i]=workC(i);
		return(Out);
	}
}
