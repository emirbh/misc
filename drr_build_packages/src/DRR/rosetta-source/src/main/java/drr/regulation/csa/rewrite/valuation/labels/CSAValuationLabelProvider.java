package drr.regulation.csa.rewrite.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class CSAValuationLabelProvider extends GraphBasedLabelProvider {
	public CSAValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "15 Reporting timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "1 Counterparty 1 (reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2"), "2 Counterparty 2 (non-reporting counterparty)");
		startNode.addLabel(Arrays.asList("valuationAmount"), "101 Valuation Amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "102 Valuation Currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "104 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "103 Valuation Method");
		startNode.addLabel(Arrays.asList("delta"), "108 Delta");
		startNode.addLabel(Arrays.asList("actionType"), "98 Action Type");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "21 Submitter identifier");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierSource"), "3 Counterparty 2 identifier source");
		startNode.addLabel(Arrays.asList("nextFloatingReferenceResetDateLeg1"), "105 Next Floating Reference Reset Date-Leg 1");
		startNode.addLabel(Arrays.asList("nextFloatingReferenceResetDateLeg2"), "105 Next Floating Reference Reset Date-Leg 2");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "16 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "93 Variation Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "94 Initial Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceValueLeg1"), "106 Last Floating Reference Value-Leg 1");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceValueLeg2"), "106 Last Floating Reference Value-Leg 2");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceResetDateLeg1"), "107 Last Floating Reference Reset Date-Leg 1");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceResetDateLeg2"), "107 Last Floating Reference Reset Date-Leg 2");
		startNode.addLabel(Arrays.asList("uniqueProductIdentifier"), "117 Unique Product Identifier");
		
		LabelNode dTCCAdditionalValuationFieldsNode = new LabelNode();
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1IDType"), "Trade Party 1 - ID Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("submittingPartyIDType"), "Submitting Party - ID Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("usiIDPrefix"), "USI ID Prefix");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("submittedForParty"), "Submitted For Party");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1ReportingDestination"), "Trade Party 1 - Reporting Destination");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty2ReportingDestination"), "Trade Party 2 - Reporting Destination");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("primaryAssetClass"), "Primary Asset Class");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("comment1"), "Comment 1");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("messageID"), "Message ID");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("messageType"), "Message Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty2ExecutionAgentID"), "Trade Party 2 - Execution Agent ID");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty2ExecutionAgentIDType"), "Trade Party 2 - Execution Agent ID Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1ExecutionAgentID"), "Trade Party 1 - Execution Agent ID");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1ExecutionAgentIDType"), "Trade Party 1 - Execution Agent ID Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1TransactionID"), "Valuation Trade Party 1 - Transaction ID");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("version"), "Version");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("usiID"), "USI ID");
		
		startNode.addOutgoingEdge("dtccValuationFields", dTCCAdditionalValuationFieldsNode);
	}
}
