package drr.standards.iosco.cde.version3.event.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypePOSC;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypePositionMODI;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.ActionTypeEnum;
import javax.inject.Inject;


@ImplementedBy(ActionTypeRule.ActionTypeRuleDefault.class)
public abstract class ActionTypeRule implements ReportFunction<TransactionReportInstructionBase, ActionTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypePositionMODI isActionTypePositionMODI;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsActionTypeVALU isActionTypeVALU;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ActionTypeEnum evaluate(TransactionReportInstructionBase input) {
		ActionTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ActionTypeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class ActionTypeRuleDefault extends ActionTypeRule {
		@Override
		protected ActionTypeEnum doEvaluate(TransactionReportInstructionBase input) {
			ActionTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ActionTypeEnum assignOutput(ActionTypeEnum output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final Boolean boolean0 = isActionTypeCORR.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of(ActionTypeEnum.CORR);
					}
					final Boolean boolean1 = isActionTypeEROR.evaluate(item.get());
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of(ActionTypeEnum.EROR);
					}
					final Boolean boolean2 = isActionTypeREVI.evaluate(item.get());
					if ((boolean2 == null ? false : boolean2)) {
						return MapperS.of(ActionTypeEnum.REVI);
					}
					final Boolean boolean3 = isActionTypePRTO.evaluate(item.get());
					if ((boolean3 == null ? false : boolean3)) {
						return MapperS.of(ActionTypeEnum.PRTO);
					}
					final Boolean boolean4 = isActionTypeVALU.evaluate(item.get());
					if ((boolean4 == null ? false : boolean4)) {
						return MapperS.of(ActionTypeEnum.VALU);
					}
					final Boolean boolean5 = isActionTypeTERM.evaluate(item.get());
					if ((boolean5 == null ? false : boolean5)) {
						return MapperS.of(ActionTypeEnum.TERM);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isActionTypeMODI.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePositionMODI.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(ActionTypeEnum.MODI);
					}
					final Boolean boolean6 = isActionTypePOSC.evaluate(item.get());
					if ((boolean6 == null ? false : boolean6)) {
						return MapperS.of(ActionTypeEnum.POSC);
					}
					final Boolean boolean7 = isActionTypeNEWT.evaluate(item.get());
					if ((boolean7 == null ? false : boolean7)) {
						return MapperS.of(ActionTypeEnum.NEWT);
					}
					return MapperS.<ActionTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
