package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.common.trade.payment.functions.OtherPaymentReceiver_Validation;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0131_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0131_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0131_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0131_01";
	String DEFINITION = "if otherPayment exists and [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> TERM] any = actionType then common.payment.OtherPaymentReceiver_Validation(otherPayment) default True and otherPayment -> payer <> otherPayment -> receiver";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0131_01 {
	
		@Inject protected OtherPaymentReceiver_Validation otherPaymentReceiver_Validation;
		
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
				if (exists(MapperS.of(mASTransactionReport).<OtherPayment>mapC("getOtherPayment", _mASTransactionReport -> _mASTransactionReport.getOtherPayment())).andNullSafe(areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.TERM)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any)).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(MapperS.of(otherPaymentReceiver_Validation.evaluate(MapperS.of(mASTransactionReport).<OtherPayment>mapC("getOtherPayment", _mASTransactionReport -> _mASTransactionReport.getOtherPayment()).getMulti())).getOrDefault(true))).andNullSafe(notEqual(MapperS.of(mASTransactionReport).<OtherPayment>mapC("getOtherPayment", _mASTransactionReport -> _mASTransactionReport.getOtherPayment()).<String>map("getPayer", otherPayment -> otherPayment.getPayer()), MapperS.of(mASTransactionReport).<OtherPayment>mapC("getOtherPayment", _mASTransactionReport -> _mASTransactionReport.getOtherPayment()).<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()), CardinalityOperator.Any));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0131_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
