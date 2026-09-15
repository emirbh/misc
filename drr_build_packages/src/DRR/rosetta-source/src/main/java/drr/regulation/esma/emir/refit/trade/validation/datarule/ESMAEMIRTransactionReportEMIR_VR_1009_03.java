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
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import drr.regulation.common.trade.NonReportable;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_1009_03")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_1009_03.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_1009_03 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_1009_03";
	String DEFINITION = "if counterparty2IdentifierType = True and [ActionTypeEnum -> TERM, ActionTypeEnum -> REVI, ActionTypeEnum -> EROR] any = actionType then GetOrFetchLeiData(nonReportable -> enrichment -> leiData, counterparty2) exists";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_1009_03 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
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
				if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<Boolean>map("getCounterparty2IdentifierType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.EROR)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(eSMAEMIRTransactionReport).<NonReportable>map("getNonReportable", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(eSMAEMIRTransactionReport).<String>map("getCounterparty2", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCounterparty2()).get())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_1009_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
