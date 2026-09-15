package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.GenericIdentification175__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier2Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UniqueTransactionIdentifier2Choice__1Validator implements Validator<UniqueTransactionIdentifier2Choice__1> {

	private List<ComparisonResult> getComparisonResults(UniqueTransactionIdentifier2Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unqTxIdr", (String) o.getUnqTxIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("prtry", (GenericIdentification175__1) o.getPrtry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UniqueTransactionIdentifier2Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UniqueTransactionIdentifier2Choice__1", ValidationResult.ValidationType.CARDINALITY, "UniqueTransactionIdentifier2Choice__1", path, "", res.getError());
				}
				return success("UniqueTransactionIdentifier2Choice__1", ValidationResult.ValidationType.CARDINALITY, "UniqueTransactionIdentifier2Choice__1", path, "");
			})
			.collect(toList());
	}

}
