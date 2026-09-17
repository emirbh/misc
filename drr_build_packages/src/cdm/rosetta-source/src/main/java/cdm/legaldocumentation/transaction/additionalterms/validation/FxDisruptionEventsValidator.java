package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.EventCurrency;
import cdm.legaldocumentation.transaction.additionalterms.FxBenchmarkObligationDefault;
import cdm.legaldocumentation.transaction.additionalterms.FxDisruptionEvents;
import cdm.legaldocumentation.transaction.additionalterms.FxDualExchangeRate;
import cdm.legaldocumentation.transaction.additionalterms.FxForceMajeureOrActOfSStateEnum;
import cdm.legaldocumentation.transaction.additionalterms.FxIllegalityOrImpossibilityEnum;
import cdm.legaldocumentation.transaction.additionalterms.FxInconvertibilityOrNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.FxPriceSourceDisruption;
import cdm.legaldocumentation.transaction.additionalterms.GovernmentalAuthorityDefault;
import cdm.legaldocumentation.transaction.additionalterms.Illiquidity;
import cdm.legaldocumentation.transaction.additionalterms.MaterialChangeInCircumstance;
import cdm.legaldocumentation.transaction.additionalterms.Nationalization;
import cdm.legaldocumentation.transaction.additionalterms.PriceMateriality;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxDisruptionEventsValidator implements Validator<FxDisruptionEvents> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionEvents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("illegalityOrImpossibility", (FxIllegalityOrImpossibilityEnum) o.getIllegalityOrImpossibility() != null ? 1 : 0, 0, 1), 
				checkCardinality("forceMajeureOrActOfSState", (FxForceMajeureOrActOfSStateEnum) o.getForceMajeureOrActOfSState() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventCurrency", (EventCurrency) o.getEventCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceSourceDisruption", (FxPriceSourceDisruption) o.getPriceSourceDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("benchmarkObligationDefault", (FxBenchmarkObligationDefault) o.getBenchmarkObligationDefault() != null ? 1 : 0, 0, 1), 
				checkCardinality("dualExchangeRate", (FxDualExchangeRate) o.getDualExchangeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("inconvertibilityOrNonTransferability", (FxInconvertibilityOrNonTransferability) o.getInconvertibilityOrNonTransferability() != null ? 1 : 0, 0, 1), 
				checkCardinality("governmentalAuthorityDefault", (GovernmentalAuthorityDefault) o.getGovernmentalAuthorityDefault() != null ? 1 : 0, 0, 1), 
				checkCardinality("illiquidity", (Illiquidity) o.getIlliquidity() != null ? 1 : 0, 0, 1), 
				checkCardinality("materialChangeInCircumstance", (MaterialChangeInCircumstance) o.getMaterialChangeInCircumstance() != null ? 1 : 0, 0, 1), 
				checkCardinality("nationalization", (Nationalization) o.getNationalization() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceMateriality", (PriceMateriality) o.getPriceMateriality() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackLanguageBespokeTerms", (Clause) o.getFallbackLanguageBespokeTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionEvents", ValidationResult.ValidationType.CARDINALITY, "FxDisruptionEvents", path, "", res.getError());
				}
				return success("FxDisruptionEvents", ValidationResult.ValidationType.CARDINALITY, "FxDisruptionEvents", path, "");
			})
			.collect(toList());
	}

}
