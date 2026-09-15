package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.QuantityOrTerm1Choice__1;
import iso20022.auth030.hkma.tr.QuantityTerm1__1;
import iso20022.auth030.hkma.tr.Schedule10__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QuantityOrTerm1Choice__1Validator implements Validator<QuantityOrTerm1Choice__1> {

	private List<ComparisonResult> getComparisonResults(QuantityOrTerm1Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("schdlPrd", (List<? extends Schedule10__1>) o.getSchdlPrd() == null ? 0 : o.getSchdlPrd().size(), 0, 600), 
				checkCardinality("term", (QuantityTerm1__1) o.getTerm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityOrTerm1Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuantityOrTerm1Choice__1", ValidationResult.ValidationType.CARDINALITY, "QuantityOrTerm1Choice__1", path, "", res.getError());
				}
				return success("QuantityOrTerm1Choice__1", ValidationResult.ValidationType.CARDINALITY, "QuantityOrTerm1Choice__1", path, "");
			})
			.collect(toList());
	}

}
