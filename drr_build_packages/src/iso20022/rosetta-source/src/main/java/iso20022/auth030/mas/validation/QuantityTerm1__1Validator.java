package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.Frequency19Code;
import iso20022.auth030.mas.QuantityTerm1__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QuantityTerm1__1Validator implements Validator<QuantityTerm1__1> {

	private List<ComparisonResult> getComparisonResults(QuantityTerm1__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("qty", (BigDecimal) o.getQty() != null ? 1 : 0, 0, 1), 
				checkCardinality("val", (Integer) o.getVal() != null ? 1 : 0, 0, 1), 
				checkCardinality("tmUnit", (Frequency19Code) o.getTmUnit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityTerm1__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuantityTerm1__1", ValidationResult.ValidationType.CARDINALITY, "QuantityTerm1__1", path, "", res.getError());
				}
				return success("QuantityTerm1__1", ValidationResult.ValidationType.CARDINALITY, "QuantityTerm1__1", path, "");
			})
			.collect(toList());
	}

}
