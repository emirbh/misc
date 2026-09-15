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
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EnergyLoadType1Code;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2121_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2121_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2121_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2121_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) and deliveryPoint exists then (deliveryPoint extract dp [ if IsAcceptedEicCode(dp) or IsAcceptedEicCode(interconnectionPoint) then loadType exists else loadType is absent ] then all = True)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2121_01 {
	
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
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get()))).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<String>mapC("getDeliveryPoint", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDeliveryPoint()))).getOrDefault(false)) {
					final MapperC<Boolean> thenArg = MapperS.of(eSMAEMIRTransactionReport).<String>mapC("getDeliveryPoint", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDeliveryPoint())
						.mapItem(dp -> {
							if (ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(dp.getMulti()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(MapperS.of(eSMAEMIRTransactionReport).<String>map("getInterconnectionPoint", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getInterconnectionPoint()).getMulti())))).getOrDefault(false)) {
								return exists(MapperS.of(eSMAEMIRTransactionReport).<EnergyLoadType1Code>map("getLoadType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLoadType())).asMapper();
							}
							return notExists(MapperS.of(eSMAEMIRTransactionReport).<EnergyLoadType1Code>map("getLoadType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLoadType())).asMapper();
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2121_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
