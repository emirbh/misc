package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2138_03")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2138_03.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2138_03 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2138_03";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if strikePriceCurrency exists then [ ISOCurrencyCodeEnum -> XAG to-string, ISOCurrencyCodeEnum -> XAU to-string, ISOCurrencyCodeEnum -> XBA to-string, ISOCurrencyCodeEnum -> XBB to-string, ISOCurrencyCodeEnum -> XBC to-string, ISOCurrencyCodeEnum -> XBD to-string, ISOCurrencyCodeEnum -> XDR to-string, ISOCurrencyCodeEnum -> XPD to-string, ISOCurrencyCodeEnum -> XPT to-string, ISOCurrencyCodeEnum -> XXX to-string ] all <> strikePriceCurrency else strikePriceCurrency is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2138_03 {
	
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			try {
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getStrikePriceCurrency", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getStrikePriceCurrency())).getOrDefault(false)) {
						return notEqual(MapperC.<String>of(MapperS.of(ISOCurrencyCodeEnum.XAG).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XAU).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBA).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBB).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBC).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBD).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XDR).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XPD).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XPT).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XXX).map("to-string", ISOCurrencyCodeEnum::toDisplayString)), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getStrikePriceCurrency", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getStrikePriceCurrency()), CardinalityOperator.All);
					}
					return notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getStrikePriceCurrency", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getStrikePriceCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2138_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
