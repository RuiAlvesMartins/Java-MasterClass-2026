package section18.Localization;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class ResourceBundleDemo {
    
    //  java.util.RESOURCEBUNDLE
    //  it is an ABSTRACT Class:
    //          it can be implemented by other classes (subclasses house data in code);
    //          or instantiated by static .getBundle() (dependent on RESOURCE DATA);
    //                  resource data provided by a series of files;
    //                  resource data provided y a service;

    //  You can think of RESOURCE DATA as:
    //          a series of files that have the same base name
    //          but are differentiated by Locale (i.e. language) specifics:
    //                  the KEYS can be in an arbitrary language (though they need be CONSISTENT across files!)
    //                  the VALUES will be in the specified language (e.g. resources/BasicText_fr_CA.properties)
    //  files can vary not only according to Language, but also Country, Script and Variant/Dialect        
    //  for rules regarding the searching and matching of properties files to a Locale, consult: 
    //  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ResourceBundle.html#default_behavior
    
    //  consult resources/BasicText.properties for more information, it is a must!
    //  also: consider installing Resource Bundle Editor (extention)


    
    //  Related Classes:
    //          java.util.LISTRESOURCEBUNDLE
    //                  related class, also abstract;
    //          java.util.ResourceBundle.CONTROL
    //                  subclass of ResourceBundle; 
    //                  extending it allows the use of XML file format;
    //                  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ResourceBundle.Control.html



    public static void main(String[] args) {

        //  Because resources folder is not part of the class output folder;
        //  it is not immeadiatly included in the CLASS PATH!
        //  but the IDE still needs to have it included!
        //  Visual Studio Code, unlike Intellij, does not support the creation of resource bundles!

        //  How do we ResourceBundle in VSC?
        //          Step #1: create 'resources' folder (project root per convention);
        //          Step #2: create properties files;
        //          Step #3: update classpaths on launch.json:
        //                  {
        //                      "type": "java",
        //                      "name": "ResourceBundleDemo",
        //                      "request": "launch",
        //                      "mainClass": "section18.Localization.ResourceBundleDemo",
        //                      "projectName": "Java-MasterClass-2026_9a19a2d3",
        //                      "classPaths": [
        //                          "${workspaceFolder}/bin",
        //                          "${workspaceFolder}/resources"
        //                      ]
        //                  }
        //          Step #4: java should run fine;

        //  You may also try these alternative (but impractical) methods: 
        //  OPTION #1: run the class manually from terminal, updating classpath:
        // java -cp "bin:resources" section18.Localization.ResourceBundleDemo
        ResourceBundle rb = ResourceBundle.getBundle("BasicText");
        //  OPTION #2: move resource folder into class directory, and input the classpath directly into .getBundle():
        // ResourceBundle rb = ResourceBundle.getBundle("section18.Localization.resources.BasicText");



        System.out.println(rb.getClass().getName());
        //  Output: java.util.PropertyResourceBundle
        System.out.println(rb.getBaseBundleName());
        //  Output: BasicText
        System.out.println(rb.keySet());
        //  Output: []
        //  if you already added key-value pairs in BasicText.properties, the output will not be empty;

        System.out.println("%s %s!".formatted(rb.getString("hello"), rb.getString("world")));
        System.out.println();



        for (Locale l : List.of(Locale.US, Locale.CANADA_FRENCH, Locale.CANADA)) {
            //  .getBundle(baseNameString, Locale)
            rb = ResourceBundle.getBundle("BasicText", l);
            String message = "%s %s!".formatted(rb.getString("hello"), rb.getString("world"));
            System.out.println(message);

            //  you need to pass locale as arg if you want to print in that locale format!

            //  Although BasicText_en_CA has no value mapped for 'hello', it still printed 'hello world';
            //  Due to the searching and matching algorithm on ResourceBundle,
            //  java's .getString() will use different resource files, if needed, to resolve keys!
            //  In this example, it found no 'hello' key on BasicText_en_CA,
            //  so it defaulted to 'hello' key on BasicText!
            //  This means you don't need to map words that are similar across dialects, scripts, or languages!



            ResourceBundle ui = ResourceBundle.getBundle("UIComponents", l);

            //  Do NOT stress about JOptionPane
            //  You are not supposed to know about it, for now;
            JOptionPane.showOptionDialog(null,
                message,
                ui.getString("first.title"),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[] {ui.getString("btn.ok"), ui.getString("btn.cancel")},
                null
            );

        }

    }

}
