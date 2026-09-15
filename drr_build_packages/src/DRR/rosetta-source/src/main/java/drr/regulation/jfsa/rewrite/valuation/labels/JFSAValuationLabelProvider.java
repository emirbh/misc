package drr.regulation.jfsa.rewrite.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class JFSAValuationLabelProvider extends GraphBasedLabelProvider {
	public JFSAValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "4 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "7 Counterparty 1 (reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "9 Counterparty 2 Identifier Type");
		startNode.addLabel(Arrays.asList("counterparty2"), "8 Counterparty 2");
		startNode.addLabel(Arrays.asList("valuationAmount"), "39 Valuation Amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "40 Valuation Currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "41 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "42 Valuation Method");
		startNode.addLabel(Arrays.asList("delta"), "43 Delta");
		startNode.addLabel(Arrays.asList("actionType"), "101 Action Type");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "[Internal] Technical Record Id (ISO)");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "12 Submitter Identifier");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "6 Entity Responsible for Reporting");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "25 Unique transaction identifier (UTI)");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "25 Unique Transaction Identifier (UTI Proprietary)");
		startNode.addLabel(Arrays.asList("newSDRIdentifier"), "13 New SDR identifier");
	}
}
