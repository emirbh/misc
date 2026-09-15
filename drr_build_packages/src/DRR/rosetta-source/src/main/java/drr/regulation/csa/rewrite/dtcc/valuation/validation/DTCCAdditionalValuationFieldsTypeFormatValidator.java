package drr.regulation.csa.rewrite.dtcc.valuation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class DTCCAdditionalValuationFieldsTypeFormatValidator implements Validator<DTCCAdditionalValuationFields> {

	private List<ComparisonResult> getComparisonResults(DTCCAdditionalValuationFields o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("submittedForParty", o.getSubmittedForParty(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DTCCAdditionalValuationFields o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DTCCAdditionalValuationFields", ValidationResult.ValidationType.TYPE_FORMAT, "DTCCAdditionalValuationFields", path, "", res.getError());
				}
				return success("DTCCAdditionalValuationFields", ValidationResult.ValidationType.TYPE_FORMAT, "DTCCAdditionalValuationFields", path, "");
			})
			.collect(toList());
	}

}
