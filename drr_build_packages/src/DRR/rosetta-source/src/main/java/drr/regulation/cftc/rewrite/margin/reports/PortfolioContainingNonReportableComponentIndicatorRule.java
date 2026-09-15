package drr.regulation.cftc.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PortfolioContainingNonReportableComponentIndicatorRule.PortfolioContainingNonReportableComponentIndicatorRuleDefault.class)
public abstract class PortfolioContainingNonReportableComponentIndicatorRule implements ReportFunction<CollateralReportInstruction, Boolean> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(CollateralReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(CollateralReportInstruction input);

	public static class PortfolioContainingNonReportableComponentIndicatorRuleDefault extends PortfolioContainingNonReportableComponentIndicatorRule {
		@Override
		protected Boolean doEvaluate(CollateralReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, CollateralReportInstruction input) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			final MapperC<Boolean> thenArg3 = thenArg2
				.mapSingleToList(item -> distinctIgnoringPrecision(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()).<Boolean>map("getNonReportedTradePortfolio", cFTCPartyInformation -> cFTCPartyInformation.getNonReportedTradePortfolio())));
			final MapperC<Boolean> thenArg4 = thenArg3
				.mapItem(item -> {
					if (exists(item).getOrDefault(false)) {
						return item;
					}
					return MapperS.of(false);
				});
			output = MapperS.of(thenArg4.get()).get();
			
			return output;
		}
	}
}
