package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.CustomBasket4__1;
import iso20022.auth030.fca.IndexIdentification1__1;
import iso20022.auth030.fca.SecurityIdentification41Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecurityIdentification41Choice__1Validator implements Validator<SecurityIdentification41Choice__1> {

	private List<ComparisonResult> getComparisonResults(SecurityIdentification41Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isin", (String) o.getIsin() != null ? 1 : 0, 0, 1), 
				checkCardinality("bskt", (CustomBasket4__1) o.getBskt() != null ? 1 : 0, 0, 1), 
				checkCardinality("indx", (IndexIdentification1__1) o.getIndx() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityIdentification41Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityIdentification41Choice__1", ValidationResult.ValidationType.CARDINALITY, "SecurityIdentification41Choice__1", path, "", res.getError());
				}
				return success("SecurityIdentification41Choice__1", ValidationResult.ValidationType.CARDINALITY, "SecurityIdentification41Choice__1", path, "");
			})
			.collect(toList());
	}

}
