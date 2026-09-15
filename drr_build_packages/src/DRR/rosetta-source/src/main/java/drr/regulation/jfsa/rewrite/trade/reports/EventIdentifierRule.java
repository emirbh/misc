package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventIdentifierRule.EventIdentifierRuleDefault.class)
public abstract class EventIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.event.reports.EventIdentifierRule eventIdentifierRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

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

	public static class EventIdentifierRuleDefault extends EventIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<FieldWithMetaString> ifThenElseResult;
			if (areEqual(MapperS.of(eventTypeRule.evaluate(thenArg.get())), MapperS.of(EventTypeEnum.COMP), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeNEWT.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isActionTypeMODI.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All))).orNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(thenArg.get())), MapperS.of(EventTypeEnum.CREV), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeMODI.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All)))).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> {
						final String string = eventIdentifierRule.evaluate(item.get());
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
