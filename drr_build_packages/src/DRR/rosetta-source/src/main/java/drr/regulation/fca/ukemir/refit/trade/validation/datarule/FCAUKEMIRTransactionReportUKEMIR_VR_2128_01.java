package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

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
import drr.enrichment.eic.functions.IsAcceptedEicCode;
import drr.regulation.common.ReportableDelivery;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2128_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2128_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2128_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2128_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) and deliveryReport exists then (deliveryReport extract dr [ if IsAcceptedEicCode(deliveryPoint) or IsAcceptedEicCode(interconnectionPoint) then dr -> deliveryCapacity exists else dr -> deliveryCapacity is absent ] then all = True)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2128_01 {
	
		@Inject protected IsAcceptedEicCode isAcceptedEicCode;
		
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
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get()))).andNullSafe(exists(MapperS.of(fCAUKEMIRTransactionReport).<ReportableDelivery>mapC("getDeliveryReport", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getDeliveryReport()))).getOrDefault(false)) {
					final MapperC<Boolean> thenArg = MapperS.of(fCAUKEMIRTransactionReport).<ReportableDelivery>mapC("getDeliveryReport", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getDeliveryReport())
						.mapItem(dr -> {
							if (ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<String>mapC("getDeliveryPoint", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getDeliveryPoint()).getMulti()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getInterconnectionPoint", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getInterconnectionPoint()).getMulti())))).getOrDefault(false)) {
								return exists(dr.<BigDecimal>map("getDeliveryCapacity", reportableDelivery -> reportableDelivery.getDeliveryCapacity())).asMapper();
							}
							return notExists(dr.<BigDecimal>map("getDeliveryCapacity", reportableDelivery -> reportableDelivery.getDeliveryCapacity())).asMapper();
						});
					return ComparisonResult.ofNullSafe(areEqual(thenArg, MapperS.of(true), CardinalityOperator.All).asMapper());
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2128_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
