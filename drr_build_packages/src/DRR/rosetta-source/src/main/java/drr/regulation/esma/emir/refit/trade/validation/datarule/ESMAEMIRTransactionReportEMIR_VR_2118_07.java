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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2118_07")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2118_07.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2118_07 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2118_07";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if subProduct = \"OIP\" then [\"BAKK\", \"BDSL\", \"BRNT\", \"BRNX\", \"CNDA\", \"COND\", \"DSEL\", \"DUBA\", \"ESPO\", \"ETHA\", \"FUEL\", \"FOIL\", \"GOIL\", \"GSLN\", \"HEAT\", \"JTFL\", \"KERO\", \"LLSO\", \"MARS\", \"NAPH\", \"NGLO\", \"TAPI\", \"URAL\", \"WTIO\", \"OTHR\"] any = furtherSubProduct";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2118_07 {
	
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
					if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<String>map("getSubProduct", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OIP"), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperC.<String>of(MapperS.of("BAKK"), MapperS.of("BDSL"), MapperS.of("BRNT"), MapperS.of("BRNX"), MapperS.of("CNDA"), MapperS.of("COND"), MapperS.of("DSEL"), MapperS.of("DUBA"), MapperS.of("ESPO"), MapperS.of("ETHA"), MapperS.of("FUEL"), MapperS.of("FOIL"), MapperS.of("GOIL"), MapperS.of("GSLN"), MapperS.of("HEAT"), MapperS.of("JTFL"), MapperS.of("KERO"), MapperS.of("LLSO"), MapperS.of("MARS"), MapperS.of("NAPH"), MapperS.of("NGLO"), MapperS.of("TAPI"), MapperS.of("URAL"), MapperS.of("WTIO"), MapperS.of("OTHR")), MapperS.of(eSMAEMIRTransactionReport).<String>map("getFurtherSubProduct", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getFurtherSubProduct()), CardinalityOperator.Any);
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2118_07 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
