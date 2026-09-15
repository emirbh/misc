package drr.regulation.cftc.rewrite.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class CFTCMarginLabelProvider extends GraphBasedLabelProvider {
	public CFTCMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "97 Reporting timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "13 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2"), "14 Counterparty 2");
		startNode.addLabel(Arrays.asList("uti"), "103 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "115 Collateralisation Category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "119 Initial Margin Posted By The Reporting Counterparty (Pre-Haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "118 Initial Margin Posted By The Reporting Counterparty Post Haircut");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "120 Currency Of Initial Margin Posted");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "125 Variation Margin Posted By The Reporting Counterparty (Pre-Haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "126 Currency Of Variation Margin Posted");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "122 Initial Margin Collected By The Reporting Counterparty (Pre-Haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "121 Initial Margin Collected By The Reporting Counterparty (Post-Haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "123 Currency Of Initial Margin Collected");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "127 Variation Margin Collected By The Reporting Counterparty (Pre-Haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "128 Currency Of Variation Margin Collected");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "124 Variation Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "116 Initial Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "22 Submitter identifier");
		startNode.addLabel(Arrays.asList("actionType"), "26 Action type");
		startNode.addLabel(Arrays.asList("eventTimestamp"), "30 Event timestamp");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierSource"), "15 Counterparty 2 identifier source");
		startNode.addLabel(Arrays.asList("uniqueSwapIdentifier"), "102 Unique Swap Identifier (USI)");
		startNode.addLabel(Arrays.asList("affiliatedCounterpartyForMarginAndCapitalIndicator"), "114 Affiliated Counterparty for Margin and Capital Indicator");
		startNode.addLabel(Arrays.asList("portfolioContainingNonReportableComponentIndicator"), "117 Portfolio Containing Non Reportable Component Indicator");
		startNode.addLabel(Arrays.asList("tradeParty1IDType"), "Trade Party 1 - ID Type");
		startNode.addLabel(Arrays.asList("submittingPartyIDType"), "Submitting Party - ID Type");
		startNode.addLabel(Arrays.asList("usiIDPrefix"), "USI ID Prefix");
		startNode.addLabel(Arrays.asList("utiIDPrefix"), "UTI ID Prefix");
		startNode.addLabel(Arrays.asList("tradeParty1ReportingDestination"), "Trade Party 1 - Reporting Destination");
		startNode.addLabel(Arrays.asList("comment1"), "Comment 1");
		startNode.addLabel(Arrays.asList("messageID"), "Message ID");
		startNode.addLabel(Arrays.asList("messageType"), "Message Type");
		startNode.addLabel(Arrays.asList("version"), "Version");
	}
}
