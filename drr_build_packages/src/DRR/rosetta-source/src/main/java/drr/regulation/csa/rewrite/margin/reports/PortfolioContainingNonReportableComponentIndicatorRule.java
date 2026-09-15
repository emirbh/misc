package drr.regulation.csa.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CSAPartyInformation;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PortfolioContainingNonReportableComponentIndicatorRule.PortfolioContainingNonReportableComponentIndicatorRuleDefault.class)
public abstract class PortfolioContainingNonReportableComponentIndicatorRule implements ReportFunction<CollateralReportInstruction, List<Boolean>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<Boolean> evaluate(CollateralReportInstruction input) {
		List<Boolean> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<Boolean> doEvaluate(CollateralReportInstruction input);

	public static class PortfolioContainingNonReportableComponentIndicatorRuleDefault extends PortfolioContainingNonReportableComponentIndicatorRule {
		@Override
		protected List<Boolean> doEvaluate(CollateralReportInstruction input) {
			List<Boolean> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<Boolean> assignOutput(List<Boolean> output, CollateralReportInstruction input) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
			final MapperListOfLists<JurisdictionPartyInformation> thenArg2 = thenArg1
				.mapItemToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
			final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
				.flattenList();
			output = thenArg3
				.mapItem(item -> {
					if (exists(item.<CSAPartyInformation>map("getCsaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCsaPartyInformation()).<Boolean>map("getNonReportedTradePortfolio", cSAPartyInformation -> cSAPartyInformation.getNonReportedTradePortfolio())).getOrDefault(false)) {
						return item.<CSAPartyInformation>map("getCsaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCsaPartyInformation()).<Boolean>map("getNonReportedTradePortfolio", cSAPartyInformation -> cSAPartyInformation.getNonReportedTradePortfolio());
					}
					return MapperS.of(false);
				}).getMulti();
			
			return output;
		}
	}
}
