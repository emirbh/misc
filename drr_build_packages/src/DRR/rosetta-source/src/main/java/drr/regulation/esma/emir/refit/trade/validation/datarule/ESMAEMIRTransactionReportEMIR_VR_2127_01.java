package drr.regulation.esma.emir.refit.trade.validation.datarule;

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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2127_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2127_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2127_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2127_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) and deliveryReport exists then (deliveryReport extract dr [ if IsAcceptedEicCode(deliveryPoint) or IsAcceptedEicCode(interconnectionPoint) then [\"WDAY\", \"WEND\", \"MOND\", \"TUED\", \"WEDD\", \"THUD\", \"FRID\", \"SATD\", \"SUND\", \"XBHL\", \"IBHL\"] = dr -> daysOfTheWeek else dr -> daysOfTheWeek is absent ] then all = True)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2127_01 {
	
		@Inject protected IsAcceptedEicCode isAcceptedEicCode;
		
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
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get()))).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<ReportableDelivery>mapC("getDeliveryReport", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDeliveryReport()))).getOrDefault(false)) {
					final MapperC<Boolean> thenArg = MapperS.of(eSMAEMIRTransactionReport).<ReportableDelivery>mapC("getDeliveryReport", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDeliveryReport())
						.mapItem(dr -> {
							if (ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(MapperS.of(eSMAEMIRTransactionReport).<String>mapC("getDeliveryPoint", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDeliveryPoint()).getMulti()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(MapperS.of(eSMAEMIRTransactionReport).<String>map("getInterconnectionPoint", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getInterconnectionPoint()).getMulti())))).getOrDefault(false)) {
								return areEqual(MapperC.<String>of(MapperS.of("WDAY"), MapperS.of("WEND"), MapperS.of("MOND"), MapperS.of("TUED"), MapperS.of("WEDD"), MapperS.of("THUD"), MapperS.of("FRID"), MapperS.of("SATD"), MapperS.of("SUND"), MapperS.of("XBHL"), MapperS.of("IBHL")), dr.<String>mapC("getDaysOfTheWeek", reportableDelivery -> reportableDelivery.getDaysOfTheWeek()), CardinalityOperator.All).asMapper();
							}
							return notExists(dr.<String>mapC("getDaysOfTheWeek", reportableDelivery -> reportableDelivery.getDaysOfTheWeek())).asMapper();
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2127_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
