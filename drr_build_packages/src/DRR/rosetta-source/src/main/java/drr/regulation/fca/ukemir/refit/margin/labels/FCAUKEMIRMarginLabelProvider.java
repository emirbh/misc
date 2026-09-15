package drr.regulation.fca.ukemir.refit.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class FCAUKEMIRMarginLabelProvider extends GraphBasedLabelProvider {
	public FCAUKEMIRMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "3.1 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "3.4 Counterparty 1 (Reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "3.5 Counterparty 2 identifier type");
		startNode.addLabel(Arrays.asList("counterparty2"), "3.6 Counterparty 2");
		startNode.addLabel(Arrays.asList("collateralPortfolioCode"), "3.9 Collateral portfolio code");
		startNode.addLabel(Arrays.asList("collateralPortfolioIndicator"), "3.8 Collateral portfolio indicator");
		startNode.addLabel(Arrays.asList("uti"), "3.10 UTI");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "3.11 Collateralisation category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "3.12 Initial margin posted by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "3.13 Initial margin posted by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "3.14 Currency of the initial margins posted");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "3.15 Variation margin posted by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PostHaircut"), "3.16 Variation margin posted by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "3.17 Currency of the variation margins posted");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "3.20 Initial margin collected by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "3.21 Initial margin collected by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "3.22 Currency of initial margin collected");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "3.23 Variation margin collected by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PostHaircut"), "3.24 Variation margin collected by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "3.25 Currency of variation margin collected");
		startNode.addLabel(Arrays.asList("excessCollateralPostedByTheCounterparty1"), "3.18 Excess collateral posted by the counterparty 1");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralPosted"), "3.19 Currency of the excess collateral posted");
		startNode.addLabel(Arrays.asList("excessCollateralCollectedByTheCounterparty1"), "3.26 Excess collateral collected by the counterparty 1");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralCollected"), "3.27 Currency of excess collateral collected");
		startNode.addLabel(Arrays.asList("collateralTimestamp"), "3.7 Collateral timestamp");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "3.2 Report Submitting entity ID");
		startNode.addLabel(Arrays.asList("actionType"), "3.28 Action Type");
		startNode.addLabel(Arrays.asList("eventDate"), "3.29 Event date");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "3.3 Entity responsible for reporting");
		startNode.addLabel(Arrays.asList("executionAgentOfCounterparty1"), "3.30 Execution Agent of Counterparty 1");
		startNode.addLabel(Arrays.asList("executionAgentOfCounterparty2"), "3.30 Execution Agent of Counterparty 2");
	}
}
