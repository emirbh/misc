package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.DerivativePartyIdentification1Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativePartyIdentification1ChoiceValidator implements Validator<DerivativePartyIdentification1Choice> {

	private List<ComparisonResult> getComparisonResults(DerivativePartyIdentification1Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctry", (String) o.getCtry() != null ? 1 : 0, 0, 1), 
				checkCardinality("ctrySubDvsn", (String) o.getCtrySubDvsn() != null ? 1 : 0, 0, 1), 
				checkCardinality("lei", (String) o.getLei() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativePartyIdentification1Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativePartyIdentification1Choice", ValidationResult.ValidationType.CARDINALITY, "DerivativePartyIdentification1Choice", path, "", res.getError());
				}
				return success("DerivativePartyIdentification1Choice", ValidationResult.ValidationType.CARDINALITY, "DerivativePartyIdentification1Choice", path, "");
			})
			.collect(toList());
	}

}
