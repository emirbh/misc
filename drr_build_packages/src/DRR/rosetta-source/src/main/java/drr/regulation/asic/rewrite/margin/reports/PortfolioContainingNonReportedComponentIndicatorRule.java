package drr.regulation.asic.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ASICPartyInformation;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PortfolioContainingNonReportedComponentIndicatorRule.PortfolioContainingNonReportedComponentIndicatorRuleDefault.class)
public abstract class PortfolioContainingNonReportedComponentIndicatorRule implements ReportFunction<CollateralReportInstruction, Boolean> {

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

	public static class PortfolioContainingNonReportedComponentIndicatorRuleDefault extends PortfolioContainingNonReportedComponentIndicatorRule {
		@Override
		protected Boolean doEvaluate(CollateralReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, CollateralReportInstruction input) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.ASIC), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			output = thenArg2
				.mapSingleToItem(item -> {
					if (exists(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ASICPartyInformation>map("getAsicPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getAsicPartyInformation()).<Boolean>map("getNonReportedTradePortfolio", aSICPartyInformation -> aSICPartyInformation.getNonReportedTradePortfolio())).getOrDefault(false)) {
						return item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ASICPartyInformation>map("getAsicPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getAsicPartyInformation()).<Boolean>map("getNonReportedTradePortfolio", aSICPartyInformation -> aSICPartyInformation.getNonReportedTradePortfolio())
							.first();
					}
					return MapperS.of(false);
				}).get();
			
			return output;
		}
	}
}
