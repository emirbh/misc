package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalTypeEnum;
import cdm.legaldocumentation.csa.ApplicableRegime;
import cdm.legaldocumentation.csa.RegimeTerms;
import cdm.legaldocumentation.csa.RegulatoryRegimeEnum;
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

public class ApplicableRegimeValidator implements Validator<ApplicableRegime> {

	private List<ComparisonResult> getComparisonResults(ApplicableRegime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("regime", (RegulatoryRegimeEnum) o.getRegime() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalRegime", (String) o.getAdditionalRegime() != null ? 1 : 0, 0, 1), 
				checkCardinality("regimeTerms", (List<? extends RegimeTerms>) o.getRegimeTerms() == null ? 0 : o.getRegimeTerms().size(), 2, 2), 
				checkCardinality("additionalType", (AdditionalTypeEnum) o.getAdditionalType() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalTerms", (String) o.getAdditionalTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableRegime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableRegime", ValidationResult.ValidationType.CARDINALITY, "ApplicableRegime", path, "", res.getError());
				}
				return success("ApplicableRegime", ValidationResult.ValidationType.CARDINALITY, "ApplicableRegime", path, "");
			})
			.collect(toList());
	}

}
