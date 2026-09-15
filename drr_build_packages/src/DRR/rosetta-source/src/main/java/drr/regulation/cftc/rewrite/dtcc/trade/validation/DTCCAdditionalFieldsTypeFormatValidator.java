package drr.regulation.cftc.rewrite.dtcc.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class DTCCAdditionalFieldsTypeFormatValidator implements Validator<DTCCAdditionalFields> {

	private List<ComparisonResult> getComparisonResults(DTCCAdditionalFields o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("submittedForParty", o.getSubmittedForParty(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("corporateActionNewTradeParty1Lei", o.getCorporateActionNewTradeParty1Lei(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DTCCAdditionalFields o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DTCCAdditionalFields", ValidationResult.ValidationType.TYPE_FORMAT, "DTCCAdditionalFields", path, "", res.getError());
				}
				return success("DTCCAdditionalFields", ValidationResult.ValidationType.TYPE_FORMAT, "DTCCAdditionalFields", path, "");
			})
			.collect(toList());
	}

}
