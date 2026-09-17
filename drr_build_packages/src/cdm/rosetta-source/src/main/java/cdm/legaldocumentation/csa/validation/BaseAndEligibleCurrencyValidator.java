package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.legaldocumentation.csa.BaseAndEligibleCurrency;
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

public class BaseAndEligibleCurrencyValidator implements Validator<BaseAndEligibleCurrency> {

	private List<ComparisonResult> getComparisonResults(BaseAndEligibleCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("baseCurrency", (ISOCurrencyCodeEnum) o.getBaseCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("baseCurrencyTerminationCurrency", (Boolean) o.getBaseCurrencyTerminationCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("baseCurrencyOther", (FieldWithMetaString) o.getBaseCurrencyOther() != null ? 1 : 0, 0, 1), 
				checkCardinality("eligibleCurrencyInclBaseCurrency", (Boolean) o.getEligibleCurrencyInclBaseCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("eligibleCurrencyOther", (FieldWithMetaString) o.getEligibleCurrencyOther() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BaseAndEligibleCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BaseAndEligibleCurrency", ValidationResult.ValidationType.CARDINALITY, "BaseAndEligibleCurrency", path, "", res.getError());
				}
				return success("BaseAndEligibleCurrency", ValidationResult.ValidationType.CARDINALITY, "BaseAndEligibleCurrency", path, "");
			})
			.collect(toList());
	}

}
