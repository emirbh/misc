package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.FxInconvertibilityOrNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.GeneralInconvertibility;
import cdm.legaldocumentation.transaction.additionalterms.GeneralNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.SpecificInconvertibility;
import cdm.legaldocumentation.transaction.additionalterms.SpecificNonTransferability;
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

public class FxInconvertibilityOrNonTransferabilityValidator implements Validator<FxInconvertibilityOrNonTransferability> {

	private List<ComparisonResult> getComparisonResults(FxInconvertibilityOrNonTransferability o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("generalInconvertibility", (GeneralInconvertibility) o.getGeneralInconvertibility() != null ? 1 : 0, 0, 1), 
				checkCardinality("generalNonTransferability", (GeneralNonTransferability) o.getGeneralNonTransferability() != null ? 1 : 0, 0, 1), 
				checkCardinality("specificInconvertibility", (SpecificInconvertibility) o.getSpecificInconvertibility() != null ? 1 : 0, 0, 1), 
				checkCardinality("specificNonTransferability", (SpecificNonTransferability) o.getSpecificNonTransferability() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxInconvertibilityOrNonTransferability o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxInconvertibilityOrNonTransferability", ValidationResult.ValidationType.CARDINALITY, "FxInconvertibilityOrNonTransferability", path, "", res.getError());
				}
				return success("FxInconvertibilityOrNonTransferability", ValidationResult.ValidationType.CARDINALITY, "FxInconvertibilityOrNonTransferability", path, "");
			})
			.collect(toList());
	}

}
