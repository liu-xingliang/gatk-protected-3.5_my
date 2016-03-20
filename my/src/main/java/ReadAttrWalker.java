/**
 * Created by liuxl on 3/10/2016.
 */

import org.broadinstitute.gatk.engine.CommandLineGATK;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.engine.walkers.DataSource;
import org.broadinstitute.gatk.engine.walkers.NanoSchedulable;
import org.broadinstitute.gatk.engine.walkers.ReadWalker;
import org.broadinstitute.gatk.engine.walkers.Requires;
import org.broadinstitute.gatk.utils.help.DocumentedGATKFeature;
import org.broadinstitute.gatk.utils.help.HelpConstants;
import org.broadinstitute.gatk.utils.sam.GATKSAMRecord;

@DocumentedGATKFeature( groupName = HelpConstants.DOCS_CAT_QC, extraDocs = {CommandLineGATK.class} )
@Requires({DataSource.READS, DataSource.REFERENCE})
public class ReadAttrWalker  extends ReadWalker<Void, Void> implements NanoSchedulable {
    public Void map(ReferenceContext ref, GATKSAMRecord read, RefMetaDataTracker tracker) {
        System.out.println(read.getAttribute("BI"));
        return null;
    }

    @Override public Void reduceInit() {
        return null;
    }

    public Void reduce(Void value, Void sum) {
        return null;
    }

    public void onTraversalDone(Long result) {
        logger.info("Finish");
    }
}
