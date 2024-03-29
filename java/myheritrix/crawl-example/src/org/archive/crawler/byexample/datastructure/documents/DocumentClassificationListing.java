package org.archive.crawler.byexample.datastructure.documents;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.archive.crawler.byexample.constants.OutputConstants;
import org.archive.crawler.byexample.utils.FileUtils;

/**
 * Datastructure class implementing listing of document possible classifications.
 * Each listing record is an object of type DocumentClassification
 * 
 * @see org.archive.crawler.byexample.datastructure.documents.DocumentClassificationEntry
 * 
 * @author Michael Bendersky
 *
 */
public class DocumentClassificationListing{
        
    private ArrayList<DocumentClassificationEntry> docClasses;
    private BufferedWriter dumpFile=null;
    
    /**
     * Default constructor
     * @param bw Listing output file
     */
    public DocumentClassificationListing(BufferedWriter bw){
        docClasses=new ArrayList<DocumentClassificationEntry>();
        dumpFile=bw;
    }
    
    /**
     * Adds new classification to listing
     * @param crawledURL
     * @param scores
     * @param scopeResult
     */
    public void addClassification(DocumentClassificationEntry dce){        
        if (docClasses.size()>OutputConstants.MAX_ENTRIES_IN_MEMORY && dumpFile!=null){
            dumpListingToFile();
            docClasses.clear();
        }          
        docClasses.add(dce);
    }
    
    /**
     * Write listing to designated output file
     */
    public void dumpListingToFile(){
        //No dump file defined - do nothing
        if (dumpFile==null)
            return;
        
        StringBuffer dump=new StringBuffer();
        for (DocumentClassificationEntry currKey : docClasses) {            
            dump.append(currKey.toString()+"\n");
        }
        FileUtils.dumpBufferToFile(dumpFile,dump);  
    }
    
    
    /**
     * String represantion of this list
     */
    public String toString(){
        return docClasses.toString();
    }


    
} //END OF CLASS
