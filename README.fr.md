# 1DcellularAutomaton_Library
 une librairie java pour simmuler des automates cellulaires unidimensionnels

si vous ne savez pas ce que sont les automates cellulaires, il vaut mieux que vous vous documentiez avant
d'utiliser la librairie :

https://fr.wikipedia.org/wiki/Automate_cellulaire

=========FAIT PAR PHYSIC DEV (Physic Gamer)==========

vous pouvez utiliser ce code dans vos propres projets
mais n'oubliez pas d'indiquer que j'ai créé ce code

=====================================================


DOCUMENTATION :

+ Classe Cellular1D


   - Cellular1D(int L,int N,int S)
   constructeur, 
   L : nombre de cellules de l'automate
   N : portée (0 = dépend uniquement de son propre état, 1 = dépends aussi de l'états de ses voisins directs)
   S : nombre d'états possible

Variables:

int gen : indique la génération actuelle
int[] state : contient l'état actuel de l'automate

Fonctions:
	
   - getLength()
   indique la valeur de la longeur

   - getNeighbors()
   indique le nombre de voisins (nombre toujours impair)

   - getRule()
   indique la valeur de la règle

   - getState()
   indique le nombre d'états possible

   - getTranslate(int state)
   indique le caractère associé à l'état state

   - maxRule()
   indique le nombre total de règles possibles - 1 ,
   il s'agit également du nombre le plus grand que l'on peut assigner à une règle

   - nextGen()
   calcule la prochaine génération

   - reset()
   rempli le tableau des états (state[]) de 0 à part la case centrale qui prend la valeur 1

   - reset(int value)
   rempli le tableau des états (state[]) de 0 à part la case centrale qui prend la valeur de value
   value : entier comprit entre 0 et State (voir getState())

   - random()
   rempli le tableau des états (state[]) aléatoirement avec les valeurs possibles des états

   - setChar(char[] c)
   fait correspondre chaque valeur d'états à un caractère, sert pour l'affichage de l'automate dans un terminal
   (voir toString())
   c : tableau de caractères de longeur state (voir getState())

   - setRule(int r)
   assigne une règle à l'automate cellulaire
   r : entier comprit entre 0 et MaxRule (voir maxRule())

   - toString()
   converti le tableau des états des cellules de l'automate (voir state) en une 
   chaîne de caractère à l'aide du tableau de traduction (voir setChar())

+ Classe ComplexCellular1D

fonctionne exactement de la même manière que Cellular1D

cependant les automates cellulaire des ComplexCellular1D ne sont pas totalistique :

exemple :

Cellular1D :

20320+12031 car
20320 = 2+0+3+2+0=7
12031 = 1+2+0+3+1=7

mais dans ComplexCellular1D

20320 != 12031

donc il ces deux configuration peuvent donner des résultats différents

