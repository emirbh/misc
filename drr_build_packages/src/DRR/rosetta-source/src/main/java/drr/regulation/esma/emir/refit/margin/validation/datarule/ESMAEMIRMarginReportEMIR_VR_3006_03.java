package drr.regulation.esma.emir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiStatusEnum;
import drr.enrichment.lei.functions.API_GetLeiData;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3006_03")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3006_03.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3006_03 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3006_03";
	String DEFINITION = "if counterparty2IdentifierType = True then (API_GetLeiData(counterparty2) -> entityStatus exists and API_GetLeiData(counterparty2) -> entityCategory <> LeiCategoryEnum -> Branch)";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3006_03 {
	
		@Inject protected API_GetLeiData aPI_GetLeiData;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			try {
				if (areEqual(MapperS.of(eSMAEMIRMarginReport).<Boolean>map("getCounterparty2IdentifierType", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(aPI_GetLeiData.evaluate(MapperS.of(eSMAEMIRMarginReport).<String>map("getCounterparty2", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCounterparty2()).get())).<LeiStatusEnum>map("getEntityStatus", leiData -> leiData.getEntityStatus())).andNullSafe(notEqual(MapperS.of(aPI_GetLeiData.evaluate(MapperS.of(eSMAEMIRMarginReport).<String>map("getCounterparty2", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCounterparty2()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3006_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
