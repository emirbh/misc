package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.GenericIdentification184;
import iso20022.auth030.jfsa.InstrumentIdentification6Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InstrumentIdentification6Choice__1Validator implements Validator<InstrumentIdentification6Choice__1> {

	private List<ComparisonResult> getComparisonResults(InstrumentIdentification6Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isin", (String) o.getIsin() != null ? 1 : 0, 0, 1), 
				checkCardinality("othrId", (GenericIdentification184) o.getOthrId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentIdentification6Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentIdentification6Choice__1", ValidationResult.ValidationType.CARDINALITY, "InstrumentIdentification6Choice__1", path, "", res.getError());
				}
				return success("InstrumentIdentification6Choice__1", ValidationResult.ValidationType.CARDINALITY, "InstrumentIdentification6Choice__1", path, "");
			})
			.collect(toList());
	}

}
