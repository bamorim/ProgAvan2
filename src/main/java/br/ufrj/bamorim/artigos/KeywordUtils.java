package br.ufrj.bamorim.artigos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KeywordUtils {
  public static List<String> splitKeywords(String keywords){
    List<String> kws;
    if(keywords.isEmpty() || keywords.matches("^[,\\s]*$")){
      kws = new LinkedList<String>();
    } else {
        kws = Arrays.asList(keywords.split("[,\\s]+"));
    }
    return kws;
  }
}
