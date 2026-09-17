package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.GeneralSimmElections;
import cdm.legaldocumentation.csa.SimmCalculationCurrency;
import cdm.legaldocumentation.csa.SimmVersion;
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

public class GeneralSimmElectionsValidator implements Validator<GeneralSimmElections> {

	private List<ComparisonResult> getComparisonResults(GeneralSimmElections o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("simmVersion", (SimmVersion) o.getSimmVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("simmCalculationCurrency", (SimmCalculationCurrency) o.getSimmCalculationCurrency() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralSimmElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GeneralSimmElections", ValidationResult.ValidationType.CARDINALITY, "GeneralSimmElections", path, "", res.getError());
				}
				return success("GeneralSimmElections", ValidationResult.ValidationType.CARDINALITY, "GeneralSimmElections", path, "");
			})
			.collect(toList());
	}

}
