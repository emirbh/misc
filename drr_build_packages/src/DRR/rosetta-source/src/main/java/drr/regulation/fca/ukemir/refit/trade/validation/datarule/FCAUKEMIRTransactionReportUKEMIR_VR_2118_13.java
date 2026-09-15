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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2118_13")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2118_13.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2118_13 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2118_13";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if [\"POTA\", \"DIRY\", \"FRST\", \"SEAF\", \"LSTK\", \"COAL\", \"INRG\", \"RNNG\", \"LGHT\", \"DIST\", \"WTHR\", \"CRBR\", \"CSHP\", \"AMMO\", \"DAPH\", \"PTSH\", \"SLPH\", \"UREA\", \"UAAN\", \"CSTR\", \"MFTG\", \"CBRD\", \"NSPT\", \"PULP\", \"RCVP\", \"PLST\", \"OTHR\"] any = subProduct then furtherSubProduct is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2118_13 {
	
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
					if (areEqual(MapperC.<String>of(MapperS.of("POTA"), MapperS.of("DIRY"), MapperS.of("FRST"), MapperS.of("SEAF"), MapperS.of("LSTK"), MapperS.of("COAL"), MapperS.of("INRG"), MapperS.of("RNNG"), MapperS.of("LGHT"), MapperS.of("DIST"), MapperS.of("WTHR"), MapperS.of("CRBR"), MapperS.of("CSHP"), MapperS.of("AMMO"), MapperS.of("DAPH"), MapperS.of("PTSH"), MapperS.of("SLPH"), MapperS.of("UREA"), MapperS.of("UAAN"), MapperS.of("CSTR"), MapperS.of("MFTG"), MapperS.of("CBRD"), MapperS.of("NSPT"), MapperS.of("PULP"), MapperS.of("RCVP"), MapperS.of("PLST"), MapperS.of("OTHR")), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getSubProduct", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getSubProduct()), CardinalityOperator.Any).getOrDefault(false)) {
						return notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getFurtherSubProduct", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getFurtherSubProduct()));
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2118_13 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
