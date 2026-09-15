package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReferenceEntityFormatEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractReferenceEntity;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReferenceEntityFormatRule.ReferenceEntityFormatRuleDefault.class)
public abstract class ReferenceEntityFormatRule implements ReportFunction<TransactionReportInstruction, ReferenceEntityFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReferenceEntity extractReferenceEntity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ReferenceEntityFormatEnum evaluate(TransactionReportInstruction input) {
		ReferenceEntityFormatEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ReferenceEntityFormatEnum doEvaluate(TransactionReportInstruction input);

	public static class ReferenceEntityFormatRuleDefault extends ReferenceEntityFormatRule {
		@Override
		protected ReferenceEntityFormatEnum doEvaluate(TransactionReportInstruction input) {
			ReferenceEntityFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ReferenceEntityFormatEnum assignOutput(ReferenceEntityFormatEnum output, TransactionReportInstruction input) {
			final MapperS<EntityIdentifierTypeEnum> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(extractReferenceEntity.evaluate(item.get())).<EntityIdentifierTypeEnum>map("getIdentifierType", entityIdentifier -> entityIdentifier.getIdentifierType()));
			final MapperS<ReferenceEntityFormatEnum> ifThenElseResult;
			if (areEqual(thenArg, MapperS.of(EntityIdentifierTypeEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(ReferenceEntityFormatEnum.LEI);
			} else if (areEqual(thenArg, MapperS.of(EntityIdentifierTypeEnum.COUNTRY_CODE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(ReferenceEntityFormatEnum.COUNTRY);
			} else {
				ifThenElseResult = MapperS.<ReferenceEntityFormatEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
