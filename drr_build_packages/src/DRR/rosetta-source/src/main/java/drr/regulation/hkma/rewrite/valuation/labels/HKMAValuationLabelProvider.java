package drr.regulation.hkma.rewrite.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class HKMAValuationLabelProvider extends GraphBasedLabelProvider {
	public HKMAValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "4 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "6 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "9 Counterparty 2 identifier type indicator");
		startNode.addLabel(Arrays.asList("counterparty2"), "7 Counterparty 2");
		startNode.addLabel(Arrays.asList("valuationAmount"), "34 Valuation Amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "35 Valuation Currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "36 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "37 Valuation Method");
		startNode.addLabel(Arrays.asList("delta"), "85 Delta");
		startNode.addLabel(Arrays.asList("actionType"), "134 Action Type");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "200 Technical record identification");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "154 Entity responsible for reporting");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "138 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "138 Unique Transaction Identifier (UTI) Proprietary");
		startNode.addLabel(Arrays.asList("counterparty2Name"), "8 Counterparty 2 name");
		startNode.addLabel(Arrays.asList("submitterIdentifier"), "153 Submitter identifier");
		startNode.addLabel(Arrays.asList("numberRecords"), "199 Number records");
		startNode.addLabel(Arrays.asList("remarks"), "201 Remarks");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierFormat"), "Counterparty 2 Identifier Format (Non Reportable)");
		startNode.addLabel(Arrays.asList("counterparty2SchemeName"), "Counterparty 2 Scheme Name (Non Reportable)");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietarySchemeName"), "Unique Transaction Identifier Proprietary Scheme Name (Non Reportable)");
	}
}
