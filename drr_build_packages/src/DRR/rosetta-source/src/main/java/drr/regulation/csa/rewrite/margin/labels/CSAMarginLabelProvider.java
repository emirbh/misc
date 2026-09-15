package drr.regulation.csa.rewrite.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class CSAMarginLabelProvider extends GraphBasedLabelProvider {
	public CSAMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "15 Reporting timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "1 Counterparty 1 (reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2"), "2 Counterparty 2 (non-reporting counterparty)");
		startNode.addLabel(Arrays.asList("uti"), "16 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "79 Collateralisation Category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "81 Initial margin posted by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "82 Initial margin posted by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "83 Currency of Initial Margin Posted");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "87 Variation margin posted by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PostHaircut"), "88 Variation margin posted by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "89 Currency of variation margin posted");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "84 Initial margin collected by the counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "85 Initial margin collected by the counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "86 Currency of Initial Margin Collected");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "90 Variation margin collected by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PostHaircut"), "91 Variation margin collected by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "92 Currency of variation margin collected");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "93 Variation Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "94 Initial Margin Collateral Portfolio Code");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "21 Submitter identifier");
		startNode.addLabel(Arrays.asList("actionType"), "98 Action Type");
		startNode.addLabel(Arrays.asList("eventTimestamp"), "95 Event Timestamp");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierSource"), "3 Counterparty 2 identifier source");
		startNode.addLabel(Arrays.asList("portfolioContainingNonReportableComponentIndicator"), "80 Portfolio containing non-reportable component indicator");
		startNode.addLabel(Arrays.asList("tradeParty1IDType"), "Trade Party 1 - ID Type");
		startNode.addLabel(Arrays.asList("submittingPartyIDType"), "Submitting Party - ID Type");
		startNode.addLabel(Arrays.asList("usiID"), "USI ID");
		startNode.addLabel(Arrays.asList("usiIDPrefix"), "USI ID Prefix");
		startNode.addLabel(Arrays.asList("tradeParty1ReportingDestination"), "Trade Party 1 - Reporting Destination");
		startNode.addLabel(Arrays.asList("comment1"), "Comment 1");
		startNode.addLabel(Arrays.asList("messageID"), "Message ID");
		startNode.addLabel(Arrays.asList("messageType"), "Message Type");
		startNode.addLabel(Arrays.asList("version"), "Version");
	}
}
