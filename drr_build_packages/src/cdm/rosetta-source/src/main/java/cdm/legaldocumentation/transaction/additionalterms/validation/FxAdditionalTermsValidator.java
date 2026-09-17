package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.DeterminationRolesAndTerms;
import cdm.legaldocumentation.transaction.additionalterms.FxAdditionalTerms;
import cdm.legaldocumentation.transaction.additionalterms.FxDisruptionEvents;
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

public class FxAdditionalTermsValidator implements Validator<FxAdditionalTerms> {

	private List<ComparisonResult> getComparisonResults(FxAdditionalTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("disruptionEvents", (FxDisruptionEvents) o.getDisruptionEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationTerms", (DeterminationRolesAndTerms) o.getDeterminationTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("noFaultTermination", (Boolean) o.getNoFaultTermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdditionalTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAdditionalTerms", ValidationResult.ValidationType.CARDINALITY, "FxAdditionalTerms", path, "", res.getError());
				}
				return success("FxAdditionalTerms", ValidationResult.ValidationType.CARDINALITY, "FxAdditionalTerms", path, "");
			})
			.collect(toList());
	}

}
