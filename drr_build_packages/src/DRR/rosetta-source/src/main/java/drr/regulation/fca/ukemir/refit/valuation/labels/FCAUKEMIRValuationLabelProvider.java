package drr.regulation.fca.ukemir.refit.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class FCAUKEMIRValuationLabelProvider extends GraphBasedLabelProvider {
	public FCAUKEMIRValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "1.1 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "1.4 Counterparty 1 (reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "1.8 Counterparty 2 Identifier Type");
		startNode.addLabel(Arrays.asList("counterparty2"), "1.9 Counterparty 2");
		startNode.addLabel(Arrays.asList("valuationAmount"), "2.21 Valuation amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "2.22 Valuation currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "2.23 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "2.24 Valuation method");
		startNode.addLabel(Arrays.asList("delta"), "2.25 Delta");
		startNode.addLabel(Arrays.asList("actionType"), "2.151 Action type");
		startNode.addLabel(Arrays.asList("level"), "2.154 Level");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "1.2 Report Submitting entity ID");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "1.3 Entity responsible for reporting");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "2.1 UTI");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "2.1 UTI (Proprietary)");
		startNode.addLabel(Arrays.asList("eventDate"), "2.153 Event Date");
	}
}
