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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_1006_02")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_1006_02.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_1006_02 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_1006_02";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if natureOfCounterparty1 = N and corporateSectorOfTheCounterparty1 exists then (corporateSectorOfTheCounterparty1 extract ([\"A\", \"B\", \"C\", \"D\", \"E\", \"F\", \"G\", \"H\", \"I\", \"J\", \"K\", \"L\", \"M\", \"N\", \"O\", \"P\", \"Q\", \"R\", \"S\", \"T\", \"U\"] any = item) then all = True)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_1006_02 {
	
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
					if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.N), CardinalityOperator.All).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<String>mapC("getCorporateSectorOfTheCounterparty1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCorporateSectorOfTheCounterparty1()))).getOrDefault(false)) {
						final MapperC<Boolean> thenArg = MapperS.of(eSMAEMIRTransactionReport).<String>mapC("getCorporateSectorOfTheCounterparty1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCorporateSectorOfTheCounterparty1())
							.mapItem(item -> areEqual(MapperC.<String>of(MapperS.of("A"), MapperS.of("B"), MapperS.of("C"), MapperS.of("D"), MapperS.of("E"), MapperS.of("F"), MapperS.of("G"), MapperS.of("H"), MapperS.of("I"), MapperS.of("J"), MapperS.of("K"), MapperS.of("L"), MapperS.of("M"), MapperS.of("N"), MapperS.of("O"), MapperS.of("P"), MapperS.of("Q"), MapperS.of("R"), MapperS.of("S"), MapperS.of("T"), MapperS.of("U")), item, CardinalityOperator.Any).asMapper());
						return ComparisonResult.ofNullSafe(areEqual(thenArg, MapperS.of(true), CardinalityOperator.All).asMapper());
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_1006_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
