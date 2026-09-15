package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.datetime.daycount.DayCountFractionEnum;
import cdm.base.datetime.daycount.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.InterestComputationMethod4Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DayCountConventionRule.DayCountConventionRuleDefault.class)
public abstract class DayCountConventionRule implements ReportFunction<InterestRatePayout, InterestComputationMethod4Code> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public InterestComputationMethod4Code evaluate(InterestRatePayout input) {
		InterestComputationMethod4Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract InterestComputationMethod4Code doEvaluate(InterestRatePayout input);

	public static class DayCountConventionRuleDefault extends DayCountConventionRule {
		@Override
		protected InterestComputationMethod4Code doEvaluate(InterestRatePayout input) {
			InterestComputationMethod4Code output = null;
			return assignOutput(output, input);
		}
		
		protected InterestComputationMethod4Code assignOutput(InterestComputationMethod4Code output, InterestRatePayout input) {
			if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum0 -> fieldWithMetaDayCountFractionEnum0 == null ? null : fieldWithMetaDayCountFractionEnum0.getValue()), MapperS.of(DayCountFractionEnum._30_360), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A001;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum1 -> fieldWithMetaDayCountFractionEnum1 == null ? null : fieldWithMetaDayCountFractionEnum1.getValue()), MapperS.of(DayCountFractionEnum.ACT_360), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A004;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum2 -> fieldWithMetaDayCountFractionEnum2 == null ? null : fieldWithMetaDayCountFractionEnum2.getValue()), MapperS.of(DayCountFractionEnum.ACT_365_FIXED), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A005;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum3 -> fieldWithMetaDayCountFractionEnum3 == null ? null : fieldWithMetaDayCountFractionEnum3.getValue()), MapperS.of(DayCountFractionEnum.ACT_ACT_ICMA), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A006;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum4 -> fieldWithMetaDayCountFractionEnum4 == null ? null : fieldWithMetaDayCountFractionEnum4.getValue()), MapperS.of(DayCountFractionEnum._30E_360_ISDA), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A007;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum5 -> fieldWithMetaDayCountFractionEnum5 == null ? null : fieldWithMetaDayCountFractionEnum5.getValue()), MapperS.of(DayCountFractionEnum.ACT_ACT_ISDA), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A008;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum6 -> fieldWithMetaDayCountFractionEnum6 == null ? null : fieldWithMetaDayCountFractionEnum6.getValue()), MapperS.of(DayCountFractionEnum.ACT_365L), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A009;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum7 -> fieldWithMetaDayCountFractionEnum7 == null ? null : fieldWithMetaDayCountFractionEnum7.getValue()), MapperS.of(DayCountFractionEnum.ACT_ACT_AFB), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A010;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum8 -> fieldWithMetaDayCountFractionEnum8 == null ? null : fieldWithMetaDayCountFractionEnum8.getValue()), MapperS.of(DayCountFractionEnum._30E_360), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A011;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum9 -> fieldWithMetaDayCountFractionEnum9 == null ? null : fieldWithMetaDayCountFractionEnum9.getValue()), MapperS.of(DayCountFractionEnum.ACT_ACT_ISMA), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A015;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum10 -> fieldWithMetaDayCountFractionEnum10 == null ? null : fieldWithMetaDayCountFractionEnum10.getValue()), MapperS.of(DayCountFractionEnum.ACT_364), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A017;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum11 -> fieldWithMetaDayCountFractionEnum11 == null ? null : fieldWithMetaDayCountFractionEnum11.getValue()), MapperS.of(DayCountFractionEnum.CAL_252), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A018;
			} else if (areEqual(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("Type coercion", fieldWithMetaDayCountFractionEnum12 -> fieldWithMetaDayCountFractionEnum12 == null ? null : fieldWithMetaDayCountFractionEnum12.getValue()), MapperS.of(DayCountFractionEnum._1_1), CardinalityOperator.All).getOrDefault(false)) {
				output = InterestComputationMethod4Code.A020;
			} else if (exists(MapperS.of(input).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", interestRatePayout -> interestRatePayout.getDayCountFraction())).getOrDefault(false)) {
				output = InterestComputationMethod4Code.NARR;
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
