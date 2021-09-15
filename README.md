# 1DcellularAutomaton_Library
 a java library for making quick 1d cellular automata simulation

if you don't know what are cellular automata, you better document before using the library 

https://fr.wikipedia.org/wiki/Automate_cellulaire

==========MADE BY PHYSIC DEV (Physic Gamer)==========

you can use this for your own project but i would apreciate 
you mention that this was done by me.

=====================================================


DOCUMENTATION :

+ Class Cellular1D


   - Cellular1D(int L,int N,int S)
   constructor,
   L : automata cells number
   N : range (0 = depends only with of itself, 1 = also depends of its directs neighbors)
   S : total possible states

Variables:

int gen : the actual generation
int[] state : contain the actual state of the automata

Functions:
	
   - getLength()
   indicates the length value

   - getNeighbors()
   indicates the neighbors number (always an odd number)

   - getRule()
   indicates the rule value

   - getState()
   indicates the numbers of possible state

   - getTranslate(int state)
   indicates the character associated with the state

   - maxRule()
   indicates the total number of Rule-1,
   it's also the biggest number we can assign to a rule

   - nextGen()
   compute the next generation

   - reset()
   fill the state array (state[]) with 0 exact the middle cell that take the value of 1

   - reset(int value)
   fill the state array (state[]) with 0 exact the middle cell that take the value of value

   - random()
   fill the state array (state[]) randomly with possible state values

   - setChar(char[] c)
   match each state to a character , is used for the render of the automata in the terminal
   (see toString())
   c : char array with a length of state (see getState())

   - setRule(int r)
   assign a rule to the cellular automata
   r : integer between 0 and MaxRule (see maxRule())

   - toString()
   convert the state array in a String with the help of the translate array (see setChar())


