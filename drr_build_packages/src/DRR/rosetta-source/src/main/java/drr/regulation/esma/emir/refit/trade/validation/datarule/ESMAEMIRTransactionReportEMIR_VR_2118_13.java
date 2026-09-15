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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2118_13")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2118_13.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2118_13 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2118_13";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if [\"POTA\", \"DIRY\", \"FRST\", \"SEAF\", \"LSTK\", \"COAL\", \"INRG\", \"RNNG\", \"LGHT\", \"DIST\", \"WTHR\", \"CRBR\", \"CSHP\", \"AMMO\", \"DAPH\", \"PTSH\", \"SLPH\", \"UREA\", \"UAAN\", \"CSTR\", \"MFTG\", \"CBRD\", \"NSPT\", \"PULP\", \"RCVP\", \"PLST\", \"OTHR\"] any = subProduct then furtherSubProduct is absent";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2118_13 {
	
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
					if (areEqual(MapperC.<String>of(MapperS.of("POTA"), MapperS.of("DIRY"), MapperS.of("FRST"), MapperS.of("SEAF"), MapperS.of("LSTK"), MapperS.of("COAL"), MapperS.of("INRG"), MapperS.of("RNNG"), MapperS.of("LGHT"), MapperS.of("DIST"), MapperS.of("WTHR"), MapperS.of("CRBR"), MapperS.of("CSHP"), MapperS.of("AMMO"), MapperS.of("DAPH"), MapperS.of("PTSH"), MapperS.of("SLPH"), MapperS.of("UREA"), MapperS.of("UAAN"), MapperS.of("CSTR"), MapperS.of("MFTG"), MapperS.of("CBRD"), MapperS.of("NSPT"), MapperS.of("PULP"), MapperS.of("RCVP"), MapperS.of("PLST"), MapperS.of("OTHR")), MapperS.of(eSMAEMIRTransactionReport).<String>map("getSubProduct", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getSubProduct()), CardinalityOperator.Any).getOrDefault(false)) {
						return notExists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getFurtherSubProduct", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getFurtherSubProduct()));
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2118_13 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
