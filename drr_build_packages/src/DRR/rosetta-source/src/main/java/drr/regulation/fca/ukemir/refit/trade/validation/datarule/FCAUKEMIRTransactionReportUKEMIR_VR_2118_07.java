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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2118_07")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2118_07.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2118_07 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2118_07";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if subProduct = \"OIP\" then [\"BAKK\", \"BDSL\", \"BRNT\", \"BRNX\", \"CNDA\", \"COND\", \"DSEL\", \"DUBA\", \"ESPO\", \"ETHA\", \"FUEL\", \"FOIL\", \"GOIL\", \"GSLN\", \"HEAT\", \"JTFL\", \"KERO\", \"LLSO\", \"MARS\", \"NAPH\", \"NGLO\", \"TAPI\", \"URAL\", \"WTIO\", \"OTHR\"] any = furtherSubProduct";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2118_07 {
	
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
					if (areEqual(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getSubProduct", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OIP"), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperC.<String>of(MapperS.of("BAKK"), MapperS.of("BDSL"), MapperS.of("BRNT"), MapperS.of("BRNX"), MapperS.of("CNDA"), MapperS.of("COND"), MapperS.of("DSEL"), MapperS.of("DUBA"), MapperS.of("ESPO"), MapperS.of("ETHA"), MapperS.of("FUEL"), MapperS.of("FOIL"), MapperS.of("GOIL"), MapperS.of("GSLN"), MapperS.of("HEAT"), MapperS.of("JTFL"), MapperS.of("KERO"), MapperS.of("LLSO"), MapperS.of("MARS"), MapperS.of("NAPH"), MapperS.of("NGLO"), MapperS.of("TAPI"), MapperS.of("URAL"), MapperS.of("WTIO"), MapperS.of("OTHR")), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getFurtherSubProduct", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getFurtherSubProduct()), CardinalityOperator.Any);
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2118_07 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
