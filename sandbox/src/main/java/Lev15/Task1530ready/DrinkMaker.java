package Lev15.Task1530ready;

 abstract class DrinkMaker {
  abstract void getRightCup();
  abstract void putIngredient();
  abstract void pour();

   void makeDrink(){
     getRightCup();
     putIngredient();
     pour();
   }



 }
