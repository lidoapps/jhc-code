package org.archive.crawler.byexample.datastructure.documents;

import java.io.BufferedWriter;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.archive.crawler.byexample.utils.FileUtils;

/**
 * Set containing top DocumentClassificationEntry objects, sorted by one of the
 * available DocumentClassificationEntry Comparators.
 * 
 * @see org.archive.crawler.byexample.datastructure.documents.BottomUpComparator
 * @see org.archive.crawler.byexample.datastructure.documents.TopDownComparator
 * @see org.archive.crawler.byexample.datastructure.documents.DocumentClassificationEntry
 * @author Michael Bendersky
 *
 */
public class TopClassificationSet {
    private SortedSet<DocumentClassificationEntry> topClassificationSet;
    private int maxSize;
    private BufferedWriter dumpFile=null;
    
    /**
     * Default constructor 
     * @param c Comparator for set construction
     * @param maxSize set maximum allowed size
     * @param dumpFile BufferedWriter for dump file
     */
    public TopClassificationSet(Comparator<DocumentClassificationEntry> c, int maxSize, BufferedWriter dumpFile){
        topClassificationSet=new TreeSet<DocumentClassificationEntry>(c);
        this.maxSize=maxSize; 
        this.dumpFile=dumpFile;
    }
    
    /**
     * Add set entry
     */
    public void addEntry(DocumentClassificationEntry dce){
        // Add only documents with relevance score above 0
        if (dce.getClassificationRelevanceScore()>0){
            topClassificationSet.add(dce);
        }
        //Makes sure set size never exceeds maxSize
        if (topClassificationSet.size()>maxSize)
            topClassificationSet.remove(topClassificationSet.last());                
    }
    
    /**
     * Write set to designated output file
     */
    public void dumpListingToFile(){
        //No dump file defined - do nothing
        if (dumpFile==null)
            return;
        
        StringBuffer dump=new StringBuffer();
        for (DocumentClassificationEntry dce : topClassificationSet) {
            dump.append(dce.toString()+"\n");
        }
        FileUtils.dumpBufferToFile(dumpFile,dump);  
    }
    
} // END OF CLASS
