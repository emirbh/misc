package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.NotionalQuantity9__2;
import iso20022.auth030.esma.QuantityOrTerm1Choice__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalQuantity9__2Validator implements Validator<NotionalQuantity9__2> {

	private List<ComparisonResult> getComparisonResults(NotionalQuantity9__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ttlQty", (BigDecimal) o.getTtlQty() != null ? 1 : 0, 0, 1), 
				checkCardinality("dtls", (QuantityOrTerm1Choice__1) o.getDtls() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalQuantity9__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalQuantity9__2", ValidationResult.ValidationType.CARDINALITY, "NotionalQuantity9__2", path, "", res.getError());
				}
				return success("NotionalQuantity9__2", ValidationResult.ValidationType.CARDINALITY, "NotionalQuantity9__2", path, "");
			})
			.collect(toList());
	}

}
