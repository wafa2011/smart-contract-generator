/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soloditysmartcontractgenerator.Component;

/**
 *
 * @author wfabe
 */
public class templates {
    //basic elements
   public static String Start = "{";
    public static String end = "}";
    public static String BeginAcolade="(";
    public static  String FinAcolade=")";
     public static String comma=",";
    public static  String Fin=";";
    //main apptern
     public static String entete="SPDX-License-Identifier: MIT";
   public static   String first="pragma solidity ^";
    public static  String importtKeyWord="import";
    public static  String contract="contract";
    public static  String interfaceHeritage="is";
    public static  String constructor="constructor";
    public static  String constructorparam=BeginAcolade+""+FinAcolade;
    //function
     public static  String FNkeyword="function";
     public static  String FNparam=BeginAcolade+""+FinAcolade;
     public static  String FNScope="";
     public static  String FnReturns="returns";
     public static  String returnParams=BeginAcolade+""+FinAcolade;
    public static   String returnkeyword="return";
     //view function
     public static  String viewKeyword="view";
    //pure function
     public static  String purekeyword="pure";
     //fallbackFunction
     public static  String externalKeyword="external";
     //event
     public static  String eventkeyword="event";
    public static   String eventParm="";
     //modifier
      public static String modifierkeyword="modifier";
     public static  String modifierParam=BeginAcolade+""+FinAcolade;
      public static String require="require";
      public static  String modifierFin="_;";
     //String ="";String ="";String ="";String ="";String ="";

    public static String getStart() {
        return Start;
    }

    public static String getEnd() {
        return end;
    }

    public static String getBeginAcolade() {
        return BeginAcolade;
    }

    public static String getFinAcolade() {
        return FinAcolade;
    }

    public static String getComma() {
        return comma;
    }

    public static String getFin() {
        return Fin;
    }

    public static String getEntete() {
        return entete;
    }

    public static String getFirst() {
        return first;
    }

    public static String getImporttKeyWord() {
        return importtKeyWord;
    }

    public static String getContract() {
        return contract;
    }

    public static String getInterfaceHeritage() {
        return interfaceHeritage;
    }

    public static String getConstructor() {
        return constructor;
    }

    public static String getConstructorparam() {
        return constructorparam;
    }

    public static String getFNkeyword() {
        return FNkeyword;
    }

    public static String getFNparam() {
        return FNparam;
    }

    public static String getFNScope() {
        return FNScope;
    }

    public static String getFnReturns() {
        return FnReturns;
    }

    public static String getReturnParams() {
        return returnParams;
    }

    public static String getReturnkeyword() {
        return returnkeyword;
    }

    public static String getViewKeyword() {
        return viewKeyword;
    }

    public static String getPurekeyword() {
        return purekeyword;
    }

    public static String getExternalKeyword() {
        return externalKeyword;
    }

    public static String getEventkeyword() {
        return eventkeyword;
    }

    public static String getEventParm() {
        return eventParm;
    }

    public static String getModifierkeyword() {
        return modifierkeyword;
    }

    public static String getModifierParam() {
        return modifierParam;
    }

    public static String getRequire() {
        return require;
    }

    public static String getModifierFin() {
        return modifierFin;
    }

    
     
     
}
