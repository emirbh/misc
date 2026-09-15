package drr.regulation.esma.emir.refit.trade.validation.datarule;

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
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2138_03")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2138_03.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2138_03 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2138_03";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if strikePriceCurrency exists then [ ISOCurrencyCodeEnum -> XAG to-string, ISOCurrencyCodeEnum -> XAU to-string, ISOCurrencyCodeEnum -> XBA to-string, ISOCurrencyCodeEnum -> XBB to-string, ISOCurrencyCodeEnum -> XBC to-string, ISOCurrencyCodeEnum -> XBD to-string, ISOCurrencyCodeEnum -> XDR to-string, ISOCurrencyCodeEnum -> XPD to-string, ISOCurrencyCodeEnum -> XPT to-string, ISOCurrencyCodeEnum -> XXX to-string ] all <> strikePriceCurrency else strikePriceCurrency is absent";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2138_03 {
	
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			try {
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					if (exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getStrikePriceCurrency", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getStrikePriceCurrency())).getOrDefault(false)) {
						return notEqual(MapperC.<String>of(MapperS.of(ISOCurrencyCodeEnum.XAG).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XAU).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBA).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBB).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBC).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XBD).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XDR).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XPD).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XPT).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of(ISOCurrencyCodeEnum.XXX).map("to-string", ISOCurrencyCodeEnum::toDisplayString)), MapperS.of(eSMAEMIRTransactionReport).<String>map("getStrikePriceCurrency", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getStrikePriceCurrency()), CardinalityOperator.All);
					}
					return notExists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getStrikePriceCurrency", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getStrikePriceCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2138_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
