package cdm.base.staticdata.asset.credit.validation;

import cdm.base.staticdata.asset.credit.SpecifiedCurrency;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SpecifiedCurrencyValidator implements Validator<SpecifiedCurrency> {

	private List<ComparisonResult> getComparisonResults(SpecifiedCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (FieldWithMetaString) o.getCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecifiedCurrency", ValidationResult.ValidationType.CARDINALITY, "SpecifiedCurrency", path, "", res.getError());
				}
				return success("SpecifiedCurrency", ValidationResult.ValidationType.CARDINALITY, "SpecifiedCurrency", path, "");
			})
			.collect(toList());
	}

}
