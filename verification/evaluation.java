/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soloditysmartcontractgenerator.Component.evaluationModule;

import java.io.IOException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
/**
 *
 * @author wfabe
 */
public class evaluation {
    public static long executionTime;
    public static long instructionCount ;
     public static long gasConsomation;
     public static double  similarity;
    
  public static void main(String[] args) throws IOException{
        // Start measuring execution time
        long startTime = System.currentTimeMillis();

        // End measuring execution time
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        String generatedCode="";
        System.out.println("Execution Time: " + executionTime + " milliseconds");
        instructionCount = calculateNumberOfInstruction(generatedCode);
         gasConsomation = calculateGasCons(instructionCount);
       

        System.out.println("Number of Instructions: " + instructionCount);
    }  
   public static long calculateGasCons(long instructionCount){
       for(int i=0; i<instructionCount;i++){
           gasConsomation = (long) (gasConsomation+(i*0.0000125));
       }
       return gasConsomation;
      
  }
   public static double Similarity(String generatedContract, String originalContract){
      int length1 = generatedContract.length();
        int length2 = originalContract.length();
        int maxLength = Math.max(length1, length2);
        
        int sumOfSquaredDifferences = 0;
        for (int i = 0; i < maxLength; i++) {
            int char1 = (i < length1) ? generatedContract.charAt(i) : 0;
            int char2 = (i < length2) ? originalContract.charAt(i) : 0;
            
            int difference = char1 - char2;
            sumOfSquaredDifferences += difference * difference;
        }
        
       return similarity = 1.0 - Math.sqrt(sumOfSquaredDifferences) / Math.sqrt(maxLength * maxLength);
       
    } 
  
    public static long calculateNumberOfInstruction(String bytecode) throws IOException{
        Web3j web3j = Web3j.build(new HttpService()); // Connect to a local Ethereum node or Infura

        String contractAddress = "0x..."; // Replace with the actual contract address
        EthGetCode ethGetCode = web3j.ethGetCode(contractAddress, DefaultBlockParameter.valueOf("latest")).send();

        String deployedBytecode = Numeric.cleanHexPrefix(ethGetCode.getCode());
        return instructionCount = deployedBytecode.length() / 2; // Each opcode is represented by 2 characters

    }
}
