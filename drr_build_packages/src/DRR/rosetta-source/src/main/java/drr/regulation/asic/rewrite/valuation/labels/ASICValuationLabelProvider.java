package drr.regulation.asic.rewrite.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class ASICValuationLabelProvider extends GraphBasedLabelProvider {
	public ASICValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "1.6 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "1.8 Counterparty 2 identifier type indicator");
		startNode.addLabel(Arrays.asList("counterparty2"), "1.7 Counterparty 2");
		startNode.addLabel(Arrays.asList("valuationAmount"), "2.7 Valuation amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "2.8 Valuation Currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "2.6 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "2.9 Valuation method");
		startNode.addLabel(Arrays.asList("delta"), "2.10 Delta");
		startNode.addLabel(Arrays.asList("actionType"), "1.101 Action type");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "[Internal] Technical Record Id (ISO)");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "1.104 Report submitting entity");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "1.5 Reporting entity");
		startNode.addLabel(Arrays.asList("nextFloatingReferenceResetDateLeg1"), "2.11 Next floating reference reset date - Leg 1");
		startNode.addLabel(Arrays.asList("nextFloatingReferenceResetDateLeg2"), "2.12 Next floating reference reset date - Leg 2");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "10 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "10 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("executionAgentOfTheCounterparty2"), "[Not in regulation] Execution Agent of Counterparty 2");
		startNode.addLabel(Arrays.asList("executionAgentOfTheCounterparty1"), "1.13 Execution agent of the Counterparty 1");
		startNode.addLabel(Arrays.asList("smallScaleBuySideEntityIndicator"), "2.4 Small-scale buy-side Entity indicator");
	}
}
