package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CSAMTAVariableSet;
import cdm.observable.asset.CreditRatingAgencyEnum;
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

public class CSAMTAVariableSetValidator implements Validator<CSAMTAVariableSet> {

	private List<ComparisonResult> getComparisonResults(CSAMTAVariableSet o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (CreditRatingAgencyEnum) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (Integer) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountIsInfinity", (Boolean) o.getAmountIsInfinity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMTAVariableSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAMTAVariableSet", ValidationResult.ValidationType.CARDINALITY, "CSAMTAVariableSet", path, "", res.getError());
				}
				return success("CSAMTAVariableSet", ValidationResult.ValidationType.CARDINALITY, "CSAMTAVariableSet", path, "");
			})
			.collect(toList());
	}

}
