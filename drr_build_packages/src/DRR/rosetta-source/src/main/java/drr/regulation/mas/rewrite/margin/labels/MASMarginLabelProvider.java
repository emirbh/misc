package drr.regulation.mas.rewrite.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class MASMarginLabelProvider extends GraphBasedLabelProvider {
	public MASMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "50 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "1 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "3 Counterparty 2 Identifier Type");
		startNode.addLabel(Arrays.asList("counterparty2"), "2 Counterparty 2");
		startNode.addLabel(Arrays.asList("collateralPortfolioIndicator"), "57 Collateral Portfolio Indicator");
		startNode.addLabel(Arrays.asList("uti"), "10 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "75 Collateralisation category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "59 Initial margin posted by Counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "60 Initial margin posted by Counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "61 Currency of initial margin posted");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "65 Variation margin posted by Counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PostHaircut"), "66 Variation margin posted by Counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "67 Currency of variation margin posted");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "62 Initial margin collected by Counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "63 Initial margin collected by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "64 Currency of initial margin collected");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "68 Variation margin collected by Counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PostHaircut"), "69 Variation margin collected by Counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "70 Currency of variation margin collected");
		startNode.addLabel(Arrays.asList("excessCollateralPostedByTheCounterparty1"), "71 Excess collateral posted by Counterparty 1");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralPosted"), "72 Currency of excess collateral posted");
		startNode.addLabel(Arrays.asList("excessCollateralCollectedByTheCounterparty1"), "73 Excess collateral collected by Counterparty 1");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralCollected"), "74 Currency of excess collateral collected");
		startNode.addLabel(Arrays.asList("collateralTimestamp"), "50_0 Collateral timestamp");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "58.2 Variation margin collateral portfolio code (DTCC)");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "58.1 Initial margin collateral portfolio code (DTCC)");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "9 Data submitter");
		startNode.addLabel(Arrays.asList("actionType"), "133 Action Type");
		startNode.addLabel(Arrays.asList("eventTimestamp"), "134 Event Timestamp");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "10 Unique Transaction Identifier (Proprietary)");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "[Internal] Technical Record Id (ISO)");
		startNode.addLabel(Arrays.asList("executionAgentOfTheCounterparty1"), "[Not in regulation] Execution agent of Counterparty 1 (DTCC)");
		startNode.addLabel(Arrays.asList("reportingSpecifiedPerson"), "8 Reporting specified person");
	}
}
