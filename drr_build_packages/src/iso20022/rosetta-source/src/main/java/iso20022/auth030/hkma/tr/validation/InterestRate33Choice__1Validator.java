package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.FixedRate10__1;
import iso20022.auth030.hkma.tr.FloatingRate13__1;
import iso20022.auth030.hkma.tr.InterestRate33Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestRate33Choice__1Validator implements Validator<InterestRate33Choice__1> {

	private List<ComparisonResult> getComparisonResults(InterestRate33Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxd", (FixedRate10__1) o.getFxd() != null ? 1 : 0, 0, 1), 
				checkCardinality("fltg", (FloatingRate13__1) o.getFltg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRate33Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRate33Choice__1", ValidationResult.ValidationType.CARDINALITY, "InterestRate33Choice__1", path, "", res.getError());
				}
				return success("InterestRate33Choice__1", ValidationResult.ValidationType.CARDINALITY, "InterestRate33Choice__1", path, "");
			})
			.collect(toList());
	}

}
