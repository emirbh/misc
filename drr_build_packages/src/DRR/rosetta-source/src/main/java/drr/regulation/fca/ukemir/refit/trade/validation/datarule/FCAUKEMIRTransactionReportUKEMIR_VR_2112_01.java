package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2112_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2112_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2112_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2112_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if packageTransactionSpread exists and packageTransactionSpreadNotation = Monetary then packageTransactionSpreadCurrency exists else packageTransactionSpreadCurrency is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2112_01 {
	
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
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<PriceFormat>map("getPackageTransactionSpread", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPackageTransactionSpread())).andNullSafe(areEqual(MapperS.of(fCAUKEMIRTransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPackageTransactionSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All)).getOrDefault(false)) {
						return exists(MapperS.of(fCAUKEMIRTransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPackageTransactionSpreadCurrency()));
					}
					return notExists(MapperS.of(fCAUKEMIRTransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPackageTransactionSpreadCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2112_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
