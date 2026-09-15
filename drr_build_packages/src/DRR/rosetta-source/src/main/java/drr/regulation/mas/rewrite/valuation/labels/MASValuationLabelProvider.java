package drr.regulation.mas.rewrite.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class MASValuationLabelProvider extends GraphBasedLabelProvider {
	public MASValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "50 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "1 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "3 Counterparty 2 Identifier Type");
		startNode.addLabel(Arrays.asList("counterparty2"), "2 Counterparty 2");
		startNode.addLabel(Arrays.asList("valuationAmount"), "53 Valuation amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "54 Valuation currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "56 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "55 Valuation method");
		startNode.addLabel(Arrays.asList("actionType"), "133 Action type");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "[Internal] Technical Record Id (ISO)");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "9 Data submitter");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "8 Reporting specified person");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "10 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "10 Unique Transaction Identifier (Proprietary)");
		startNode.addLabel(Arrays.asList("executionAgentOfTheCounterparty1"), "[Not in regulation] Execution agent of Counterparty 1 (DTCC)");
		startNode.addLabel(Arrays.asList("executionAgentOfTheCounterparty2"), "[Not in regulation] Execution agent of Counterparty 2 (DTCC)");
	}
}
