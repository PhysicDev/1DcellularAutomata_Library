import java.util.Arrays;
import java.util.Random;

/*
===========MADE BY PHYSIC DEV (Physic Gamer)===========

you can use this for your own project but i would apreciate 
you mention that this was done by me.

=====================================================
*/
/* Cellular1D are Totalistic Cellular Automata

this mean the Rule is defined by the sum of every neighbors's state
the position of each neighbors have no effect on the Rule
the ComplexCellular1D class take also care of the position of neighbors.

*/
public class Cellular1D {
	
	//variables:
	
	//main infos
	int l=100;//length
	int n=1;//neighbors
	int t=2;//states
	public int gen=0;
	public int getLength(){
		return(l);
	}
	public int getNeighbors(){
		return(n);
	}
	public int getState(){
		return(t);
	}
	
	//World infos
	public int[] state=new int[l];
	int[] Compute=new int[l];
	
	//Rule infos
	int Rule=0;
	int MaxRule=(int)Math.pow(t,(2*n+1)*(t-1)+1);
	private nt[] RuleA= {0,0,0,0};
	
	public int getRule(){
		return(Rule);
	}
	public int maxRule(){
		return(MaxRule);
	}
	
	//this array is for the translation between the Array and the terminal
	char[] trad= {' ','#'};
	public int getTranslate(int state){
		return(MaxRule);
	}
	
	// constructor :
	// L is the length of the automaton
	// N is the range of the neighbors (for example for the elementary cellular automaton n=1);
	// T is the number of states
	public Cellular1D(int L,int N,int T){
		l=L;
		n=(N-1)/2;
		t=T;
		trad=new char[T];
		for(int i=0;i<T;i++)trad[i]=(char)(32+i);
		MaxRule=(int)Math.pow(t,(2*n+1)*(t-1)+1);
		state=new int[L];
		Arrays.fill(state,0);
		Compute=new int[L];
	}
	
	// compute the neighbors value
	int sum(int x){
		int S=0;
		for(int i=x-n;i<=n+x;i++)S+=state[(i+l)%l];
		return(S);
	}
	
	// better sum to avoid doing the same calcul multiple time
	int sum(int x,int last) {return(last-state[(x-n-1+l)%l]+state[(x+n)%l]);}//somme optimisée pour reduire la complexité.
	
	
	// reset function (generate an empty array exept one value, 1 by default)
	public void reset(int value) {Arrays.fill(state,0);state[l/2]=value;gen=0;}
	public void reset() {Arrays.fill(state,0);state[l/2]=1;gen=0;}
	
	//fill the array randomly with all the possible state
	public void random(){
        Random r = new Random();
		for(int i=0;i<l;)state[i++]=r.nextInt(t);
	}
	
	// use this to change the automaton Rule
	public void setRule(int r) {
		Rule=r;
		RuleA=RuleDat();
	}
	
	// use this to change the char linked with each state
	public void setChars(char[] dat) {System.arraycopy(dat, 0, trad, 0,t);}
	
	// use this to compute the next gen
	public void nextGen(){
		int Dat=sum(0);
		for(int i=0;i<l;i++){
			Compute[i]=work(Dat);
			Dat=sum(i+1,Dat);
		}
		gen++;
		System.arraycopy(Compute, 0, state, 0,l);
	}
	
	//use this to print the Array
	public String toString(){
		String Out="|";
		for(int s:state){
			Out+=trad[s];
		}
		return(Out+"|");
	}
	
	//pour pré-calculer les valeurs de règle.
	// convert Rule Value in Rule Array
	public int[] RuleDat(){
		int[] Out= new int[(t-1)*(2*n+1)+1];
		for(int i=0;i<Out.length;i++)Out[i]=workC(i);
		return(Out);
	}

	// get the next value of a cell with the neighbors value 
	// workC use the Rule value and work use the Rule array
	int workC(int S) {return(int)(((int)Rule%Math.pow(t,S+1))/(int)Math.pow(t,S));}
	int work(int S) {return(int)RuleA[S];}
	
}
