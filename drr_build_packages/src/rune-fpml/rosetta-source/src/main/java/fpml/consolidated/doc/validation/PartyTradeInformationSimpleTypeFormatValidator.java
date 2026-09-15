package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeInformationSimple;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyTradeInformationSimpleTypeFormatValidator implements Validator<PartyTradeInformationSimple> {

	private List<ComparisonResult> getComparisonResults(PartyTradeInformationSimple o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformationSimple o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeInformationSimple", ValidationResult.ValidationType.TYPE_FORMAT, "PartyTradeInformationSimple", path, "", res.getError());
				}
				return success("PartyTradeInformationSimple", ValidationResult.ValidationType.TYPE_FORMAT, "PartyTradeInformationSimple", path, "");
			})
			.collect(toList());
	}

}
