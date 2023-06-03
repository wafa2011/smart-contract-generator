/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soloditysmartcontractgenerator.ContractCreator;

import Description.Event;
import Description.EventOutputParameter;
import Description.Input;
import Description.Output;
import Description.function;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.SysexMessage;
import soloditysmartcontractgenerator.Component.templates;

/**
 *
 * @author wfabe
 */
public class contractCreationProcess {
   public static List<function> fns = new ArrayList<>();
   public static List<Event> evs = new ArrayList<>();
  

    public static List<function> FunctionsRecapFromTheJSONFile() {
           // Chemin du fichier JSON
        String filePath = "C:\\Users\\wfabe\\Documents\\NetBeansProjects\\SmartConverter\\SmartConverter\\src\\main\\java\\soloditysmartcontractgenerator\\Component\\twitter2.json";
      // Nom de l'objet à récupérer
        String objectName = "fonction";
       
        
 try {
            // Lire le fichier JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Récupérer l'objet "ffon" de la perspective opérationnelle
            JsonNode operationalPerspectiveNode = rootNode.get("operationalPerspective");
            if (operationalPerspectiveNode != null && operationalPerspectiveNode.isObject()) {
                JsonNode ffonNode = operationalPerspectiveNode.get("Functions");
                if (ffonNode != null && ffonNode.isArray()) {
                    // Le premier objet dans la liste "Functions" est l'objet "ffon"
                    for (int i = 0; i < ffonNode.size(); i++) {
                         JsonNode firstFFONObject = ffonNode.get(i);
                    if (firstFFONObject != null && firstFFONObject.isObject()) {
                        // Convertir l'objet JSON en une classe Java correspondante
                        //function yourObjectFFON = objectMapper.treeToValue(firstFFONObject, function.class);
                        function fn =  new function();
                        fn.setName(firstFFONObject.get("name").textValue());
                        fn.setType(firstFFONObject.get("Type").textValue());
                        fn.setScope(firstFFONObject.get("scope").textValue());
                        fn.setDescription(firstFFONObject.get("description").textValue());
                       // JsonNode functionsNode = operationalPerspectiveNode.get("Functions");
                        // Récupérer les objets "inputs" de chaque fonction
                       
                        
                         List<Input> inputsList = new ArrayList<Input>();
                        JsonNode inputsNode = firstFFONObject.get("inputs");
                        if (inputsNode != null && inputsNode.isArray()) {
                            
                            for (JsonNode inputnode : inputsNode) {
                                // Convertir l'objet JSON en une instance de la classe Java correspondante
                                Input input = new Input();
                                input.setName(inputnode.get("name").textValue());
                                input.setType(inputnode.get("Type").textValue());
                                inputsList.add(input);
                               
                            }
                              fn.setInputs(inputsList);
                        }
                          System.out.println("Objet 'inputsList' waaaa777 : " + inputsList);
                    
                         // Récupérer les objets "inputs" de chaque fonction
                        List<Output> outputList = new ArrayList<>();
                        JsonNode outputsNode = firstFFONObject.get("outputs");
                        if (outputsNode != null && outputsNode.isArray()) {
                            for (JsonNode outputnode : outputsNode) {
                                // Convertir l'objet JSON en une instance de la classe Java correspondante
                                Output output = new Output();
                                output.setName( outputnode.get("name").textValue());
                                output.setType( outputnode.get("Type").textValue());
                                outputList.add(output);
                            
                        }
                    
                    }
                       
                        fn.setOutputs(outputList);
                        fns.add(fn);
                        // Utiliser l'objet "ffon" récupéré
                        System.out.println("Objet 'ffon' récupéré : " + fn.toString());
                    
                   
                    } else {
                        System.out.println("L'objet 'ffon' n'a pas été trouvé dans la liste 'Functions'.");
                    }}
                } else {
                    System.out.println("La liste 'Functions' n'a pas été trouvée dans la perspective opérationnelle.");
                }
            } else {
                System.out.println("La perspective opérationnelle n'a pas été trouvée dans le fichier JSON.");
            }
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture du fichier JSON : " + e.getMessage());
        
 }
    
  
    return fns ;
      
    }
   
     
     
      public static List<Event> EventsRecapFromTheJSONFile() throws IOException {
             // Chemin du fichier JSON
        String filePath = "C:\\Users\\wfabe\\Documents\\NetBeansProjects\\SmartConverter\\SmartConverter\\src\\main\\java\\soloditysmartcontractgenerator\\Component\\twitter2.json";
       // Nom de l'objet à récupérer
            // Lire le fichier JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Récupérer l'objet "ffon" de la perspective opérationnelle
            JsonNode EventsNode =  rootNode.path("operationalPerspective").path("Events");
              System.out.println("waaaw"+EventsNode);
                if (EventsNode != null && EventsNode.isArray()) {
                    // Le premier objet dans la liste "Functions" est l'objet "ffon"
                    for (int i = 0; i < EventsNode.size(); i++) {
                         JsonNode firstFFONObject = EventsNode.get(i);
                          System.out.println(i+ "waaaw"+firstFFONObject);
                    if (firstFFONObject != null && firstFFONObject.isObject()) {
                        // Convertir l'objet JSON en une classe Java correspondante
                        //function yourObjectFFON = objectMapper.treeToValue(firstFFONObject, function.class);
                        Event ev =  new Event();
                        ev.setName(firstFFONObject.get("name").textValue());
                        ev.setType(firstFFONObject.get("Type").textValue());
                        ev.setDescription(firstFFONObject.get("description").textValue());
                          System.out.println(i+ "waaaw"+ev.toString());
       
                         // Récupérer les objets "outputs" de chaque fonction
                        List<EventOutputParameter> outputList = new ArrayList<EventOutputParameter>();
                        System.out.println("wachh" +firstFFONObject.get("outputs"));
                        JsonNode inputsNode = firstFFONObject.get("outputs");
                        
                        if (inputsNode != null && inputsNode.isArray()) {
                            for (JsonNode inputNode : inputsNode) {
                                // Convertir l'objet JSON en une instance de la classe Java correspondante
                                EventOutputParameter output = new EventOutputParameter();
                                output.setName(inputNode.get("name").textValue());
                                output.setType(inputNode.get("Type").textValue());
                                if(inputNode.get("is_indexed").asBoolean()){
                                    output.setIs_indexed(true);
                                } else {
                                    output.setIs_indexed(false);
                                            }
                                
                                outputList.add(output);
                            }
                        }
                        ev.setOutputs(outputList);
                        evs.add(ev);
                        // Utiliser l'objet "ffon" récupéré
                        System.out.println("Objet 'ffon' récupéré : " + ev.toString());
                    }}
                        }else{
                        System.err.println("objet event est vide");
                    }
                        return evs ;     
                        }
 

    public static String GetElementvaluefromJasonFile(String elementToFind){
        String value="";
       // Chemin du fichier JSON
        String filePath = "C:\\Users\\wfabe\\Documents\\NetBeansProjects\\SmartConverter\\SmartConverter\\src\\main\\java\\soloditysmartcontractgenerator\\Component\\twitter2.json";
      
        try {
            // Lire le fichier JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Rechercher l'élément et récupérer sa valeur
            JsonNode elementNode = rootNode.get(elementToFind);
            if (elementNode != null) {
                String elementValue = elementNode.asText();
                value =  elementValue;
            } else {
                System.out.println("L'élément '" + elementToFind + "' n'a pas été trouvé dans le fichier JSON.");
            }
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture du fichier JSON : " + e.getMessage());
        }
    
        return value;
        
    }
    public static File createContractSkeleton()throws Exception{
       File file = new File("C:\\Users\\wfabe\\Documents\\GeneratedContract\\Alphacontract.txt");  
       try (FileWriter fileWriter = new FileWriter(file, false)) {
           fileWriter.write (templates.getEntete());
           fileWriter.write(System.lineSeparator());
           fileWriter.write (templates.getFirst()+GetElementvaluefromJasonFile("udl-SC_version"));
           fileWriter.write(System.lineSeparator());
           fileWriter.write (templates.getContract()+" "+GetElementvaluefromJasonFile("name")+templates.getStart());
           fileWriter.write(System.lineSeparator());
           fns = FunctionsRecapFromTheJSONFile();
           for (int i = 0; i < fns.size(); i++) {
               fileWriter.write(templates.FNkeyword+" "+fns.get(i).getName()+templates.BeginAcolade);
               
               if(fns.get(i).getInputs()==null ){
                   System.out.println("vide");
              }else{
                   for (int j = 0; j< fns.get(i).getInputs().size(); j++) {
                 fileWriter.write(fns.get(i).getInputs().get(j).getType()+" "+fns.get(i).getInputs().get(j).getName());
                       System.out.println("j : : "+ j ); System.out.println("size : : "+ fns.get(i).getInputs().size() );
                 if (j<fns.get(i).getInputs().size()){
                      fileWriter.write(",");
                 }
              }
               }
                fileWriter.write(templates.FinAcolade);
                fileWriter.write(fns.get(i).getScope()+ " "+fns.get(i).getType()+" "+templates.Start);
               fileWriter.write(System.lineSeparator());
               fileWriter.write("//"+fns.get(i).getDescription());
               fileWriter.write(System.lineSeparator());
               fileWriter.write (templates.getEnd());
               fileWriter.write(System.lineSeparator());
           }
           fileWriter.write(System.lineSeparator());
           //get events
            evs = EventsRecapFromTheJSONFile();
           for (int i = 0; i < evs.size(); i++) {
               fileWriter.write(templates.eventkeyword+" "+evs.get(i).getName()+templates.BeginAcolade);
               
               if(evs.get(i).getOutputs()==null ){
                   System.out.println("vide");
              }else{
                   for (int j = 0; j< evs.get(i).getOutputs().size(); j++) {
                 fileWriter.write(evs.get(i).getOutputs().get(j).getType()+" "+evs.get(i).getOutputs().get(j).getName());
                 if (j<evs.get(i).getOutputs().size()){
                      fileWriter.write(",");
                 }
              }
               }
                fileWriter.write(templates.FinAcolade+templates.Fin);
               
               fileWriter.write("//"+fns.get(i).getDescription());
               fileWriter.write(System.lineSeparator());
               fileWriter.write (templates.getEnd());
               fileWriter.write(System.lineSeparator());
           }
           fileWriter.write(System.lineSeparator());
           fileWriter.write (templates.getEnd());
            // Write the extracted string to the file
           // fileWriter.write(transformJsonToaTree());

            

            System.out.println("String added to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
       
       
       return file;
    }
    
     public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\wfabe\\Documents\\GeneratedContract\\contract.txt");
        //contract, constructor skeleton creation
        file = createContractSkeleton();
      
        //function and event skeleton creation
        //function and event logic construction
       
        
    }
    
}
