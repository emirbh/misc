package cdm.legaldocumentation.transaction.validation;

import cdm.legaldocumentation.master.NationalizationOrInsolvencyOrDelistingEventEnum;
import cdm.legaldocumentation.transaction.AdditionalDisruptionEvents;
import cdm.legaldocumentation.transaction.ExtraordinaryEvents;
import cdm.legaldocumentation.transaction.additionalterms.EquityCorporateEvents;
import cdm.legaldocumentation.transaction.additionalterms.IndexAdjustmentEvents;
import cdm.legaldocumentation.transaction.additionalterms.Representations;
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

public class ExtraordinaryEventsValidator implements Validator<ExtraordinaryEvents> {

	private List<ComparisonResult> getComparisonResults(ExtraordinaryEvents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mergerEvents", (EquityCorporateEvents) o.getMergerEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenderOfferEvents", (EquityCorporateEvents) o.getTenderOfferEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("compositionOfCombinedConsideration", (Boolean) o.getCompositionOfCombinedConsideration() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAdjustmentEvents", (IndexAdjustmentEvents) o.getIndexAdjustmentEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDisruptionEvents", (AdditionalDisruptionEvents) o.getAdditionalDisruptionEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToDeliver", (Boolean) o.getFailureToDeliver() != null ? 1 : 0, 0, 1), 
				checkCardinality("representations", (Representations) o.getRepresentations() != null ? 1 : 0, 0, 1), 
				checkCardinality("nationalizationOrInsolvency", (NationalizationOrInsolvencyOrDelistingEventEnum) o.getNationalizationOrInsolvency() != null ? 1 : 0, 0, 1), 
				checkCardinality("delisting", (NationalizationOrInsolvencyOrDelistingEventEnum) o.getDelisting() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtraordinaryEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExtraordinaryEvents", ValidationResult.ValidationType.CARDINALITY, "ExtraordinaryEvents", path, "", res.getError());
				}
				return success("ExtraordinaryEvents", ValidationResult.ValidationType.CARDINALITY, "ExtraordinaryEvents", path, "");
			})
			.collect(toList());
	}

}
