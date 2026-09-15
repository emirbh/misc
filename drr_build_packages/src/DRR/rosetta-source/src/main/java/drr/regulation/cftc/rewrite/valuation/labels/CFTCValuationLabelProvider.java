package drr.regulation.cftc.rewrite.valuation.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class CFTCValuationLabelProvider extends GraphBasedLabelProvider {
	public CFTCValuationLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "97 Reporting timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "13 Counterparty 1 (reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2"), "14 Counterparty 2");
		startNode.addLabel(Arrays.asList("valuationAmount"), "110 Valuation Amount");
		startNode.addLabel(Arrays.asList("valuationCurrency"), "111 Valuation Currency");
		startNode.addLabel(Arrays.asList("valuationTimestamp"), "113 Valuation Timestamp");
		startNode.addLabel(Arrays.asList("valuationMethod"), "112 Valuation Method");
		startNode.addLabel(Arrays.asList("delta"), "109 Delta");
		startNode.addLabel(Arrays.asList("actionType"), "26 Action type");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "22 Submitter identifier");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierSource"), "15 Counterparty 2 identifier source");
		startNode.addLabel(Arrays.asList("nextFloatingReferenceResetDateLeg1"), "106 Next Floating Reference Reset Date-Leg 1");
		startNode.addLabel(Arrays.asList("nextFloatingReferenceResetDateLeg2"), "106 Next Floating Reference Reset Date-Leg 2");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifier"), "103 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "124 Variation Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "116 Initial Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceValueLeg1"), "107 Last Floating Reference Vale-Leg 1");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceValueLeg2"), "107 Last Floating Reference Vale-Leg 2");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceResetDateLeg1"), "108 Last floating reference reset date-Leg 1");
		startNode.addLabel(Arrays.asList("lastFloatingReferenceResetDateLeg2"), "108 Last floating reference reset date-Leg 2");
		startNode.addLabel(Arrays.asList("uniqueProductIdentifier"), "87 Unique product identifier");
		startNode.addLabel(Arrays.asList("uniqueSwapIdentifier"), "102 Unique Swap Identifier (USI)");
		
		LabelNode dTCCAdditionalValuationFieldsNode = new LabelNode();
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1IDType"), "Trade Party 1 - ID Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("submittingPartyIDType"), "Submitting Party - ID Type");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("usiIDPrefix"), "USI ID Prefix");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("utiIDPrefix"), "UTI ID Prefix");
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
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("tradeParty1TransactionID"), "Trade Party 1 - Transaction ID");
		dTCCAdditionalValuationFieldsNode.addLabel(Arrays.asList("version"), "Version");
		
		startNode.addOutgoingEdge("dtccValuationFields", dTCCAdditionalValuationFieldsNode);
	}
}
