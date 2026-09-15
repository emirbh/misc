package drr.regulation.hkma.rewrite.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class HKMAMarginLabelProvider extends GraphBasedLabelProvider {
	public HKMAMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "4 Reporting timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "6 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "9 Counterparty 2 identifier type indicator");
		startNode.addLabel(Arrays.asList("counterparty2"), "7 Counterparty 2");
		startNode.addLabel(Arrays.asList("collateralPortfolioIndicator"), "38 Collateral portfolio indicator");
		startNode.addLabel(Arrays.asList("uti"), "138 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "55 Collateralisation category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "39 Initial margin posted by the reporting counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "40 Initial margin posted by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "41 Currency of initial margin posted (pre-haircut/post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "45 Variation margin posted by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PostHaircut"), "46 Variation margin posted by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "47 Currency of variation margin posted (pre-haircut/post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "42 Initial margin collected by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "43 Initial margin collected by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "44 Currency of initial margin collected (pre-haircut/post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "48 Variation margin collected by the counterparty 1 (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PostHaircut"), "49 Variation margin collected by the counterparty 1 (post-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "50  Currency of variation margin collected (pre-haircut/post-haircut)");
		startNode.addLabel(Arrays.asList("excessCollateralPostedByTheCounterparty1"), "51 Excess collateral posted by the counterparty 1");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralPosted"), "52 Currency of excess collateral posted");
		startNode.addLabel(Arrays.asList("excessCollateralCollectedByTheCounterparty1"), "53 Excess collateral collected by the counterparty 1");
		startNode.addLabel(Arrays.asList("currencyOfTheExcessCollateralCollected"), "54 Currency of excess collateral collected");
		startNode.addLabel(Arrays.asList("collateralTimestamp"), "184 Collateral timestamp");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "152 Variation margin collateral portfolio code");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "150 Initial margin collateral portfolio code");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "153 Submitter identifier");
		startNode.addLabel(Arrays.asList("actionType"), "134 Action type");
		startNode.addLabel(Arrays.asList("eventTimestamp"), "Event date (Non Reportable)");
		startNode.addLabel(Arrays.asList("numberRecords"), "199 Number records");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "200 Technical record identification");
		startNode.addLabel(Arrays.asList("counterparty2Name"), "8 Counterparty 2 name");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierFormat"), "Counterparty 2 Identifier Format (Non Reportable)");
		startNode.addLabel(Arrays.asList("portfolioContainingNonReportableComponentIndicator"), "151 Portfolio containing non-reportable component indicator");
		startNode.addLabel(Arrays.asList("entityResponsibleForReporting"), "154 Entity responsible for reporting");
	}
}
