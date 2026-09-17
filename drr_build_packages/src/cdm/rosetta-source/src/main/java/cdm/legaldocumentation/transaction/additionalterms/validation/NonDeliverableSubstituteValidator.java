package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.observable.asset.SettlementRateOption;
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

public class NonDeliverableSubstituteValidator implements Validator<NonDeliverableSubstitute> {

	private List<ComparisonResult> getComparisonResults(NonDeliverableSubstitute o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonDeliverableSubstituteIsApplicable", (Boolean) o.getNonDeliverableSubstituteIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationDate", (AdjustedRelativeDateOffset) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustedRelativeDateOffset) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementRateOption", (SettlementRateOption) o.getSettlementRateOption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSubstitute o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonDeliverableSubstitute", ValidationResult.ValidationType.CARDINALITY, "NonDeliverableSubstitute", path, "", res.getError());
				}
				return success("NonDeliverableSubstitute", ValidationResult.ValidationType.CARDINALITY, "NonDeliverableSubstitute", path, "");
			})
			.collect(toList());
	}

}
