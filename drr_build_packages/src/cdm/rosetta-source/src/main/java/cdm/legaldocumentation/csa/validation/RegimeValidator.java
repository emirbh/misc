package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ApplicableRegime;
import cdm.legaldocumentation.csa.Regime;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegimeValidator implements Validator<Regime> {

	private List<ComparisonResult> getComparisonResults(Regime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicableRegime", (List<? extends ApplicableRegime>) o.getApplicableRegime() == null ? 0 : o.getApplicableRegime().size(), 1, 0), 
				checkCardinality("fallbackToMandatoryMethodDays", (BigDecimal) o.getFallbackToMandatoryMethodDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Regime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Regime", ValidationResult.ValidationType.CARDINALITY, "Regime", path, "", res.getError());
				}
				return success("Regime", ValidationResult.ValidationType.CARDINALITY, "Regime", path, "");
			})
			.collect(toList());
	}

}
