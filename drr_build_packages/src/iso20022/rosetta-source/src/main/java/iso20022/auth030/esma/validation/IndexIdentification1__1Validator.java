package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.FloatingRateIndex1Code;
import iso20022.auth030.esma.IndexIdentification1__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IndexIdentification1__1Validator implements Validator<IndexIdentification1__1> {

	private List<ComparisonResult> getComparisonResults(IndexIdentification1__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isin", (String) o.getIsin() != null ? 1 : 0, 0, 1), 
				checkCardinality("nm", (String) o.getNm() != null ? 1 : 0, 0, 1), 
				checkCardinality("indx", (FloatingRateIndex1Code) o.getIndx() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexIdentification1__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexIdentification1__1", ValidationResult.ValidationType.CARDINALITY, "IndexIdentification1__1", path, "", res.getError());
				}
				return success("IndexIdentification1__1", ValidationResult.ValidationType.CARDINALITY, "IndexIdentification1__1", path, "");
			})
			.collect(toList());
	}

}
