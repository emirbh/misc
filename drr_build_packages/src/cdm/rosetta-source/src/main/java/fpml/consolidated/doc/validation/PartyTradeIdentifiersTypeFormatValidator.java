package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyTradeIdentifiersTypeFormatValidator implements Validator<PartyTradeIdentifiers> {

	private List<ComparisonResult> getComparisonResults(PartyTradeIdentifiers o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeIdentifiers o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeIdentifiers", ValidationResult.ValidationType.TYPE_FORMAT, "PartyTradeIdentifiers", path, "", res.getError());
				}
				return success("PartyTradeIdentifiers", ValidationResult.ValidationType.TYPE_FORMAT, "PartyTradeIdentifiers", path, "");
			})
			.collect(toList());
	}

}
