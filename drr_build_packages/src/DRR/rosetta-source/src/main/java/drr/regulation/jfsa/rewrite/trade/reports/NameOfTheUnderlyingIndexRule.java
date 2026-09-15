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
import drr.regulation.common.trade.underlier.reports.UnderlyingIdentificationRule;
import drr.regulation.jfsa.rewrite.functions.GetUnderlyingIndexIndicator;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NameOfTheUnderlyingIndexRule.NameOfTheUnderlyingIndexRuleDefault.class)
public abstract class NameOfTheUnderlyingIndexRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected GetUnderlyingIndexIndicator getUnderlyingIndexIndicator;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected drr.regulation.common.trade.underlier.reports.NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;
	@Inject protected UnderlyingIdentificationRule underlyingIdentificationRule;

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

	public static class NameOfTheUnderlyingIndexRuleDefault extends NameOfTheUnderlyingIndexRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final String string0 = underlyingIdentificationRule.evaluate(thenArg.get());
			final String string1 = underlyingIdentificationRule.evaluate(thenArg.get());
			final MapperS<String> ifThenElseResult;
			if (areEqual(MapperS.of(assetClassRule.evaluate(thenArg.get())), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(getUnderlyingIndexIndicator.evaluate(thenArg.get())))).andNullSafe((string0 == null ? notExists(MapperS.<FieldWithMetaString>ofNull()) : notExists(MapperS.of(FieldWithMetaString.builder().setValue(string0).build())))).orNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI)), MapperS.of(assetClassRule.evaluate(thenArg.get())), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All)).andNullSafe((string1 == null ? notExists(MapperS.<FieldWithMetaString>ofNull()) : notExists(MapperS.of(FieldWithMetaString.builder().setValue(string1).build()))))).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(thenArg.get())), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> MapperS.of(nameOfTheUnderlyingIndexRule.evaluate(item.get())));
			} else {
				ifThenElseResult = MapperS.<String>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
