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
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_1020_02")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_1020_02.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_1020_02 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_1020_02";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if level = PSTN then directlyLinkedToCommercialActivityOrTreasuryFinancing is absent else if level = TCTN then if [common.party.NatureOfCounterpartyEnum -> F, common.party.NatureOfCounterpartyEnum -> C, common.party.NatureOfCounterpartyEnum -> O] any = natureOfCounterparty1 then directlyLinkedToCommercialActivityOrTreasuryFinancing is absent";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_1020_02 {
	
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
					if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<ReportLevelEnum>map("getLevel", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLevel()), MapperS.of(ReportLevelEnum.PSTN), CardinalityOperator.All).getOrDefault(false)) {
						return notExists(MapperS.of(eSMAEMIRTransactionReport).<Boolean>map("getDirectlyLinkedToCommercialActivityOrTreasuryFinancing", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing()));
					}
					if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<ReportLevelEnum>map("getLevel", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLevel()), MapperS.of(ReportLevelEnum.TCTN), CardinalityOperator.All).getOrDefault(false)) {
						if (areEqual(MapperC.<NatureOfCounterpartyEnum>of(MapperS.of(NatureOfCounterpartyEnum.F), MapperS.of(NatureOfCounterpartyEnum.C), MapperS.of(NatureOfCounterpartyEnum.O)), MapperS.of(eSMAEMIRTransactionReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNatureOfCounterparty1()), CardinalityOperator.Any).getOrDefault(false)) {
							return notExists(MapperS.of(eSMAEMIRTransactionReport).<Boolean>map("getDirectlyLinkedToCommercialActivityOrTreasuryFinancing", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing()));
						}
						return ComparisonResult.ofEmpty();
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_1020_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
