package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.AmendmentEffectiveDateEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AmendmentEffectiveDateValidator implements Validator<AmendmentEffectiveDate> {

	private List<ComparisonResult> getComparisonResults(AmendmentEffectiveDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("specificDate", (AmendmentEffectiveDateEnum) o.getSpecificDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("customProvision", (String) o.getCustomProvision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmendmentEffectiveDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmendmentEffectiveDate", ValidationResult.ValidationType.CARDINALITY, "AmendmentEffectiveDate", path, "", res.getError());
				}
				return success("AmendmentEffectiveDate", ValidationResult.ValidationType.CARDINALITY, "AmendmentEffectiveDate", path, "");
			})
			.collect(toList());
	}

}
