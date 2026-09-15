package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetUnderlyingIdentificationType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.common.trade.underlier.reports.NameOfTheUnderlyingIndexRule;
import drr.regulation.jfsa.rewrite.functions.GetUnderlyingIndexIndicator;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIdentificationRule.UnderlyingIdentificationRuleDefault.class)
public abstract class UnderlyingIdentificationRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected GetUnderlyingIndexIndicator getUnderlyingIndexIndicator;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;
	@Inject protected drr.regulation.common.trade.underlier.reports.UnderlyingIdentificationRule underlyingIdentificationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIdentificationRuleDefault extends UnderlyingIdentificationRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<FieldWithMetaString> ifThenElseResult;
			if (areEqual(MapperS.of(assetClassRule.evaluate(thenArg.get())), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(nameOfTheUnderlyingIndexRule.evaluate(thenArg.get())))).andNullSafe(notExists(MapperS.of(getUnderlyingIndexIndicator.evaluate(thenArg.get())))))).orNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI)), MapperS.of(assetClassRule.evaluate(thenArg.get())), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(nameOfTheUnderlyingIndexRule.evaluate(thenArg.get()))))))).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(thenArg.get())), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> {
						final String string = underlyingIdentificationRule.evaluate(item.get());
						return string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build());
					});
			} else {
				ifThenElseResult = MapperS.<FieldWithMetaString>ofNull();
			}
			final FieldWithMetaString fieldWithMetaString = ifThenElseResult.get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
