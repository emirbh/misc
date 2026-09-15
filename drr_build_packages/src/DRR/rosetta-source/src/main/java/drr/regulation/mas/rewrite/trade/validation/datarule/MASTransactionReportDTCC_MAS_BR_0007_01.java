package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.party.functions.Direction2Leg2_Validation;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0007_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0007_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0007_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0007_01";
	String DEFINITION = "common.party.Direction2Leg2_Validation( actionType, direction1, leg1 -> direction2, leg2 -> direction2 )";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0007_01 {
	
		@Inject protected Direction2Leg2_Validation direction2Leg2_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(direction2Leg2_Validation.evaluate(MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()).get(), MapperS.of(mASTransactionReport).<Direction1Enum>map("getDirection1", _mASTransactionReport -> _mASTransactionReport.getDirection1()).get(), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).get(), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0007_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
