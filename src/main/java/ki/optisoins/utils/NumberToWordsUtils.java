package ki.optisoins.utils;

import java.text.*;

public class NumberToWordsUtils {
  private static final String[] dizaineNames = {
          "",
          "",
          "vingt",
          "trente",
          "quarante",
          "cinquante",
          "soixante",
          "soixante",
          "quatre-vingt",
          "quatre-vingt"
  };

  private static final String[] uniteNames1 = {
          "",
          "un",
          "deux",
          "trois",
          "quatre",
          "cinq",
          "six",
          "sept",
          "huit",
          "neuf",
          "dix",
          "onze",
          "douze",
          "treize",
          "quatorze",
          "quinze",
          "seize",
          "dix-sept",
          "dix-huit",
          "dix-neuf"
  };

  private static final String[] uniteNames2 = {
          "",
          "",
          "deux",
          "trois",
          "quatre",
          "cinq",
          "six",
          "sept",
          "huit",
          "neuf",
          "dix"
  };

  private static String convertZeroToHundred(int number) {
    int laDizaine = number / 10;
    int lUnite = number % 10;

    switch (laDizaine) {
      case 1:
      case 7:
      case 9:
        lUnite = lUnite + 10;
        break;
      default:
    }

    // séparateur "-" "et"  ""
    String laLiaison = "";
    if (laDizaine > 1) {
      laLiaison = "-";
    }
    // cas particuliers
    switch (lUnite) {
      case 0:
        laLiaison = "";
        break;
      case 1:
        if (laDizaine == 8) {
          laLiaison = "-";
        } else {
          laLiaison = " et ";
        }
        break;
      case 11:
        if (laDizaine == 7) {
          laLiaison = " et ";
        }
        break;
      default:
    }

    // dizaines en lettres
    switch (laDizaine) {
      case 0:
        return uniteNames1[lUnite];
      case 8:
        return lUnite == 0 ? dizaineNames[laDizaine] : dizaineNames[laDizaine] + laLiaison + uniteNames1[lUnite];
      default:
        return dizaineNames[laDizaine] + laLiaison + uniteNames1[lUnite];
    }
  }

  private static String convertLessThanOneThousand(int number) {
    int lesCentaines = number / 100;
    int leReste = number % 100;
    String sReste = convertZeroToHundred(leReste);

    switch (lesCentaines) {
      case 0:
        return sReste;
      case 1:
        return leReste > 0 ? "cent " + sReste : "cent";
      default:
        return leReste > 0 ? uniteNames2[lesCentaines] + " cent " + sReste : uniteNames2[lesCentaines] + " cents";
    }
  }

  public static String convert(long number) {
    // 0 à 999 999 999 999
    if (number == 0) {
      return "zéro";
    }
    // pad des "0"
    String snumber = new DecimalFormat("000000000000").format(number);

    // XXXnnnnnnnnn
    int lesMilliards = Integer.parseInt(snumber.substring(0, 3));
    // nnnXXXnnnnnn
    int lesMillions = Integer.parseInt(snumber.substring(3, 6));
    // nnnnnnXXXnnn
    int lesCentMille = Integer.parseInt(snumber.substring(6, 9));
    // nnnnnnnnnXXX
    int lesMille = Integer.parseInt(snumber.substring(9, 12));

    String tradMilliards;
    switch (lesMilliards) {
      case 0:
        tradMilliards = "";
        break;
      case 1:
        tradMilliards = convertLessThanOneThousand(lesMilliards) + " milliard ";
        break;
      default:
        tradMilliards = convertLessThanOneThousand(lesMilliards) + " milliards ";
        break;
    }
    String resultat = tradMilliards;

    String tradMillions;
    switch (lesMillions) {
      case 0:
        tradMillions = "";
        break;
      case 1:
        tradMillions = convertLessThanOneThousand(lesMillions) + " million ";
        break;
      default:
        tradMillions = convertLessThanOneThousand(lesMillions) + " millions ";
        break;
    }
    resultat = resultat + tradMillions;

    String tradCentMille;
    switch (lesCentMille) {
      case 0:
        tradCentMille = "";
        break;
      case 1:
        tradCentMille = "mille ";
        break;
      default:
        tradCentMille = convertLessThanOneThousand(lesCentMille) + " mille ";
        break;
    }
    resultat = resultat + tradCentMille;

    resultat = resultat + convertLessThanOneThousand(lesMille);
    return resultat.trim();
  }
}