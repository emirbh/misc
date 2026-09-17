package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Instrument;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InstrumentTypeFormatValidator implements Validator<Instrument> {

	private List<ComparisonResult> getComparisonResults(Instrument o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Instrument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Instrument", ValidationResult.ValidationType.TYPE_FORMAT, "Instrument", path, "", res.getError());
				}
				return success("Instrument", ValidationResult.ValidationType.TYPE_FORMAT, "Instrument", path, "");
			})
			.collect(toList());
	}

}
