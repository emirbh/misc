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

@ImplementedBy(SmallScaleBuySideEntityIndicatorRule.SmallScaleBuySideEntityIndicatorRuleDefault.class)
public abstract class SmallScaleBuySideEntityIndicatorRule implements ReportFunction<CollateralReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class SmallScaleBuySideEntityIndicatorRuleDefault extends SmallScaleBuySideEntityIndicatorRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.ASIC), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			final MapperC<Boolean> thenArg3 = thenArg2
				.mapSingleToList(item -> distinctIgnoringPrecision(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ASICPartyInformation>map("getAsicPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getAsicPartyInformation()).<Boolean>map("getSmallScaleBuySideIndicator", aSICPartyInformation -> aSICPartyInformation.getSmallScaleBuySideIndicator())));
			final MapperC<String> thenArg4 = thenArg3
				.mapItem(item -> {
					if (exists(item).andNullSafe(areEqual(item, MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of("SSBS");
					}
					return MapperS.<String>ofNull();
				});
			output = MapperS.of(thenArg4.get()).get();
			
			return output;
		}
	}
}
