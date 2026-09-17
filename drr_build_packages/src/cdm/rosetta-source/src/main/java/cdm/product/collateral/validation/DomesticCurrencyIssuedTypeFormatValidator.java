package cdm.product.collateral.validation;

import cdm.product.collateral.DomesticCurrencyIssued;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DomesticCurrencyIssuedTypeFormatValidator implements Validator<DomesticCurrencyIssued> {

	private List<ComparisonResult> getComparisonResults(DomesticCurrencyIssued o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DomesticCurrencyIssued o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DomesticCurrencyIssued", ValidationResult.ValidationType.TYPE_FORMAT, "DomesticCurrencyIssued", path, "", res.getError());
				}
				return success("DomesticCurrencyIssued", ValidationResult.ValidationType.TYPE_FORMAT, "DomesticCurrencyIssued", path, "");
			})
			.collect(toList());
	}

}
