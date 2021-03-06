import java.math.BigInteger;
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
	BigInteger MaxRule=new BigInteger("256");
	int cells=3;
	
	// the constructor is the same except the maxRule Value is higher.
	public ComplexCellular1D(int L, int N, int T) {
		super(L, N, T);
		MaxRule=new BigInteger(T+"").pow((int)(Math.pow(T, N))) ;
	}
	
	//the sum function is no longer a sum, now it convert the neighbors exact configurations in a number.
	int sum(int x) {
		int S=0,p=(int)Math.pow(t,2*n);
		for(int i=x-n;i<=n+x;i++){S+=p*state[(i+l)%l];p/=t;}
		return S;
	}
	
	//the same function as above but optimized to reduce complexity
	int sum(int x,int last){return (int) (last-Math.pow(t,2*n)*state[(x-n-1+l)%l])*t+state[(x+n)%l];}
	
	int[] RuleDat(){
		int[] Out= new int[(int) Math.pow(t,2*n+1)];
		for(int i=0;i<Out.length;i++){Out[i]=workC(i);}
		return(Out);
	}
}
