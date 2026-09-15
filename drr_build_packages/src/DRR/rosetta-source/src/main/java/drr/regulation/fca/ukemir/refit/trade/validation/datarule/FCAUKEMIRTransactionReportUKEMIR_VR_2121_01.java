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
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2121_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2121_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2121_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2121_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) and deliveryPoint exists then (deliveryPoint extract dp [ if IsAcceptedEicCode(dp) or IsAcceptedEicCode(interconnectionPoint) then loadType exists else loadType is absent ] then all = True)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2121_01 {
	
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
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get()))).andNullSafe(exists(MapperS.of(fCAUKEMIRTransactionReport).<String>mapC("getDeliveryPoint", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getDeliveryPoint()))).getOrDefault(false)) {
					final MapperC<Boolean> thenArg = MapperS.of(fCAUKEMIRTransactionReport).<String>mapC("getDeliveryPoint", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getDeliveryPoint())
						.mapItem(dp -> {
							if (ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(dp.getMulti()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isAcceptedEicCode.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getInterconnectionPoint", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getInterconnectionPoint()).getMulti())))).getOrDefault(false)) {
								return exists(MapperS.of(fCAUKEMIRTransactionReport).<EnergyLoadType1Code>map("getLoadType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getLoadType())).asMapper();
							}
							return notExists(MapperS.of(fCAUKEMIRTransactionReport).<EnergyLoadType1Code>map("getLoadType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getLoadType())).asMapper();
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2121_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
