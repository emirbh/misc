package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.util.string.functions.SubString;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0110_04")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0110_04.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0110_04 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0110_04";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CommonAssetClass -> CURR then (if customBasketCode exists and GetOrFetchLeiData(nonReportable -> enrichment -> leiData, SubString(customBasketCode, 1, 20)) -> lei exists then underlyingIdentificationType exists)";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0110_04 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
		@Inject protected SubString subString;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).getOrDefault(false)) {
					if (exists(MapperS.of(jFSATransactionReport).<String>map("getCustomBasketCode", _jFSATransactionReport -> _jFSATransactionReport.getCustomBasketCode())).andNullSafe(exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(jFSATransactionReport).<NonReportable>map("getNonReportable", _jFSATransactionReport -> _jFSATransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), subString.evaluate(MapperS.of(jFSATransactionReport).<String>map("getCustomBasketCode", _jFSATransactionReport -> _jFSATransactionReport.getCustomBasketCode()).get(), 1, 20))).<String>map("getLei", leiData -> leiData.getLei()))).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", _jFSATransactionReport -> _jFSATransactionReport.getUnderlyingIdentificationType()));
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
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0110_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
