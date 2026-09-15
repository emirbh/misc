package drr.regulation.jfsa.rewrite.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class JFSAMarginLabelProvider extends GraphBasedLabelProvider {
	public JFSAMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "4 Reporting Timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "7 Counterparty 1 (reporting counterparty)");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "9 Counterparty 2 identifier type");
		startNode.addLabel(Arrays.asList("counterparty2"), "8 Counterparty 2");
		startNode.addLabel(Arrays.asList("collateralPortfolioIndicator"), "44 Collateral portfolio indicator");
		startNode.addLabel(Arrays.asList("uti"), "25 Unique transaction identifier (UTI)");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "61 Collateralisation category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "45 Initial margin posted by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "46 Initial margin posted by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "47 Currency of the initial margins posted");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "51 Variation margin posted by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PostHaircut"), "52 Variation margin posted by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "53 Currency of the variation margins posted");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "48 Initial margin collected by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "49 Initial margin collected by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "50 Currency of initial margin collected");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "54 Variation margin collected by the reporting counterparty (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PostHaircut"), "55 Variation margin collected by the reporting counterparty (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "56 Currency of variation margin collected");
		startNode.addLabel(Arrays.asList("excessCollateralPostedByTheCounterparty1"), "57 Excess collateral posted by the reporting counterparty");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralPosted"), "58 Currency of the excess collateral posted");
		startNode.addLabel(Arrays.asList("excessCollateralCollectedByTheCounterparty1"), "59 Excess Collateral Collected By The reporting counterparty");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralCollected"), "60 Currency of excess collateral collected");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "63 Variation Margin Collateral portfolio code");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "62 Initial margin Collateral portfolio code");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "12 Submitter Identifier");
		startNode.addLabel(Arrays.asList("actionType"), "101 Action Type");
		startNode.addLabel(Arrays.asList("eventTimestamp"), "104 Event timestamp");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "6 Entity responsible for reporting");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "[Internal] Technical Record Id (ISO)");
	}
}
