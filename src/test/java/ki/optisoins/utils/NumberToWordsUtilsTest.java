package ki.optisoins.utils;

import org.junit.Assert;
import org.junit.Test;

public class NumberToWordsUtilsTest {

  Object[][] donnees = {
          // Données simples
          {"zéro", 0},
          {"un", 1},
          {"deux", 2},
          {"trois", 3},
          {"quatre", 4},
          {"cinq", 5},
          {"six", 6},
          {"sept", 7},
          {"huit", 8},
          {"neuf", 9},
          {"dix", 10},
          {"onze", 11},
          {"douze", 12},
          {"treize", 13},
          {"quatorze", 14},
          {"quinze", 15},
          {"seize", 16},
          {"vingt", 20},
          {"trente", 30},
          {"quarante", 40},
          {"cinquante", 50},
          {"soixante", 60},
          {"cent", 100},
          {"mille", 1000},

          //Données composés
          //Prennent un trait d’union tous les nombres composés inférieurs à 100 ne se terminant pas en 1 sauf 81 et 91 :
          {"quatre cent cinquante-trois", 453},
          {"dix-sept", 17},
          {"quarante-huit", 48},

          //Pour les nombres se terminant en 1, on ajoute la conjonction et :
          {"soixante et un", 61},
          {"soixante-douze", 72},
          {"cinquante et un", 51},

          //81 et 91 sont écrits avec un trait d’union:
          {"quatre-vingt-un", 81},
          {"quatre-vingt-onze", 91},

          //Donneées avec accords
          //20 et 100 s’accordent quand ils sont multipliés par un nombre sans être suivis par un autre nombre.
          {"quatre-vingts", 80},
          {"quatre-vingt-trois", 83},
          {"quatre cents", 400},
          {"quatre cent vingt et un", 421},

          //Mille est toujours invariable
          {"trois mille", 3000},
          {"deux mille deux", 2002},
          {"dix mille deux", 10002},

          //Millier, million et milliard sont des noms et non des adjectifs. Ils ne font pas vraiment partie du nombre et laissent place à l’accord :
          {"quatre cents millions", 400000000},
          {"deux cent mille", 200000},

          //Divers
          {"zéro", 0},
          {"neuf", 9},
          {"dix-neuf", 19},
          {"vingt et un", 21},
          {"vingt-huit", 28},
          {"soixante et onze", 71},
          {"soixante-douze", 72},
          {"quatre-vingt-un", 81},
          {"quatre-vingt-neuf", 89},
          {"quatre-vingt-dix", 90},
          {"quatre-vingt-onze", 91},
          {"quatre-vingt-dix-sept", 97},
          {"cent", 100},
          {"cent un", 101},
          {"cent dix", 110},
          {"cent vingt", 120},
          {"deux cents", 200},
          {"deux cent un", 201},
          {"deux cent trente-deux", 232},
          {"neuf cent quatre-vingt-dix-neuf", 999},
          {"mille", 1000},
          {"mille un", 1001},
          {"dix mille", 10000},
          {"dix mille un", 10001},
          {"cent mille", 100000},
          {"deux millions", 2000000},
          {"trois milliards", 3000000000L},
          {"deux milliards cent quarante-sept millions quatre cent quatre-vingt-trois mille six cent quarante-sept", 2147483647},
  };

  @Test
  public void testSpelling() {
    for (Object[] o : donnees) {
      Assert.assertEquals(String.valueOf(o[0]), o[0], NumberToWordsUtils.convert(Long.parseLong(String.valueOf(o[1]))));
    }
  }
}