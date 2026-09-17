package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.AdditionalDisruptionEvents;
import fpml.consolidated.eq.shared.EquityCorporateEvents;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.IndexAdjustmentEvents;
import fpml.consolidated.eq.shared.Representations;
import fpml.consolidated.fpmlenum.NationalisationOrInsolvencyOrDelistingEventEnum;
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
				checkCardinality("tenderOffer", (Boolean) o.getTenderOffer() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenderOfferEvents", (EquityCorporateEvents) o.getTenderOfferEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("compositionOfCombinedConsideration", (Boolean) o.getCompositionOfCombinedConsideration() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAdjustmentEvents", (IndexAdjustmentEvents) o.getIndexAdjustmentEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDisruptionEvents", (AdditionalDisruptionEvents) o.getAdditionalDisruptionEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToDeliver", (Boolean) o.getFailureToDeliver() != null ? 1 : 0, 0, 1), 
				checkCardinality("representations", (Representations) o.getRepresentations() != null ? 1 : 0, 0, 1), 
				checkCardinality("nationalisationOrInsolvency", (NationalisationOrInsolvencyOrDelistingEventEnum) o.getNationalisationOrInsolvency() != null ? 1 : 0, 0, 1), 
				checkCardinality("delisting", (NationalisationOrInsolvencyOrDelistingEventEnum) o.getDelisting() != null ? 1 : 0, 0, 1)
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
