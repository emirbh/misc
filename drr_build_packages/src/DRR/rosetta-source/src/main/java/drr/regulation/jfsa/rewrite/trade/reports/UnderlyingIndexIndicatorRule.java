package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetUnderlyingIdentificationType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.common.trade.underlier.reports.NameOfTheUnderlyingIndexRule;
import drr.regulation.common.trade.underlier.reports.UnderlyingIdentificationRule;
import drr.regulation.jfsa.rewrite.functions.GetUnderlyingIndexIndicator;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIndexIndicatorRule.UnderlyingIndexIndicatorRuleDefault.class)
public abstract class UnderlyingIndexIndicatorRule implements ReportFunction<TransactionReportInstruction, IndexEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected GetUnderlyingIndexIndicator getUnderlyingIndexIndicator;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;
	@Inject protected UnderlyingIdentificationRule underlyingIdentificationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public IndexEnum evaluate(TransactionReportInstruction input) {
		IndexEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract IndexEnum doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIndexIndicatorRuleDefault extends UnderlyingIndexIndicatorRule {
		@Override
		protected IndexEnum doEvaluate(TransactionReportInstruction input) {
			IndexEnum output = null;
			return assignOutput(output, input);
		}
		
		protected IndexEnum assignOutput(IndexEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final String string = underlyingIdentificationRule.evaluate(thenArg.get());
			final MapperS<IndexEnum> ifThenElseResult;
			if (areEqual(MapperS.of(assetClassRule.evaluate(thenArg.get())), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(nameOfTheUnderlyingIndexRule.evaluate(thenArg.get())))).andNullSafe((string == null ? notExists(MapperS.<FieldWithMetaString>ofNull()) : notExists(MapperS.of(FieldWithMetaString.builder().setValue(string).build())))).orNullSafe(areEqual(MapperS.of(assetClassRule.evaluate(thenArg.get())), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(getUnderlyingIndexIndicator.evaluate(thenArg.get()));
			} else {
				ifThenElseResult = MapperS.<IndexEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
