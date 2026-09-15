package drr.regulation.asic.rewrite.margin.labels;

import com.regnosys.rosetta.lib.labelprovider.GraphBasedLabelProvider;
import com.regnosys.rosetta.lib.labelprovider.LabelNode;
import java.util.Arrays;


public class ASICMarginLabelProvider extends GraphBasedLabelProvider {
	public ASICMarginLabelProvider() {
		super(new LabelNode());
		
		startNode.addLabel(Arrays.asList("reportingTimestamp"), "[Not in regulation] Reporting timestamp");
		startNode.addLabel(Arrays.asList("counterparty1"), "3.3 Counterparty 1");
		startNode.addLabel(Arrays.asList("counterparty2IdentifierType"), "3.3_1 Counterparty 2 identifier type");
		startNode.addLabel(Arrays.asList("counterparty2"), "3.5 Counterparty 2");
		startNode.addLabel(Arrays.asList("collateralPortfolioIndicator"), "3.8 Collateral portfolio indicator");
		startNode.addLabel(Arrays.asList("uti"), "10 Unique Transaction Identifier (UTI)");
		startNode.addLabel(Arrays.asList("collateralisationCategory"), "3.7 Collateralisation category");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PreHaircut"), "3.12 Initial margin posted by the Reporting Entity (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByTheCounterparty1PostHaircut"), "3.13 Initial margin posted by the Reporting Entity (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginPostedByCounterparty1Currency"), "3.14 Currency of initial margin posted");
		startNode.addLabel(Arrays.asList("variationMarginPostedByTheCounterparty1PreHaircut"), "3.18 Variation margin posted by the Reporting Entity (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginPostedByCounterparty1Currency"), "3.19 Currency of variation margin posted.");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PreHaircut"), "3.15 Initial margin collected by the Reporting Entity (pre-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1PostHaircut"), "3.16 Initial margin collected by the Reporting Entity (post-haircut)");
		startNode.addLabel(Arrays.asList("initialMarginCollectedByCounterparty1Currency"), "3.17 Currency of initial margin collected");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByTheCounterparty1PreHaircut"), "3.20 Variation margin collected by the Reporting Entity (pre-haircut)");
		startNode.addLabel(Arrays.asList("variationMarginCollectedByCounterparty1Currency"), "3.21 Currency of variation margin collected.");
		startNode.addLabel(Arrays.asList("collateralTimestamp"), "3.6 Collateral timestamp");
		startNode.addLabel(Arrays.asList("variationMarginCollateralPortfolioCode"), "3.11 Collateral portfolio code (VM)");
		startNode.addLabel(Arrays.asList("initialMarginCollateralPortfolioCode"), "3.10 Collateral portfolio code (IM)");
		startNode.addLabel(Arrays.asList("reportSubmittingEntityID"), "3.24 Report submitting entity");
		startNode.addLabel(Arrays.asList("actionType"), "3.22 Action type");
		startNode.addLabel(Arrays.asList("uniqueTransactionIdentifierProprietary"), "10 Unique Transaction Identifier (Proprietary)");
		startNode.addLabel(Arrays.asList("reportingEntity"), "3.2 Reporting entity");
		startNode.addLabel(Arrays.asList("smallScaleBuySideEntityIndicator"), "3.4 Small-scale Buy-side Entity indicator");
		startNode.addLabel(Arrays.asList("portfolioContainingNonReportedComponentIndicator"), "3.9 Portfolio containing non-reported component indicator");
		startNode.addLabel(Arrays.asList("technicalRecordId"), "[Internal] Technical Record Id (ISO)");
		startNode.addLabel(Arrays.asList("executionAgentOfCounterparty1"), "N/A Execution agent of Counterparty 1");
	}
}
