package drr.regulation.common.dtcc.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.dtcc.trade.CommonDTCCAdditionalFields;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommonDTCCAdditionalFieldsTypeFormatValidator implements Validator<CommonDTCCAdditionalFields> {

	private List<ComparisonResult> getComparisonResults(CommonDTCCAdditionalFields o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("submittedForParty", o.getSubmittedForParty(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("corporateActionNewTradeParty1Lei", o.getCorporateActionNewTradeParty1Lei(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonDTCCAdditionalFields o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonDTCCAdditionalFields", ValidationResult.ValidationType.TYPE_FORMAT, "CommonDTCCAdditionalFields", path, "", res.getError());
				}
				return success("CommonDTCCAdditionalFields", ValidationResult.ValidationType.TYPE_FORMAT, "CommonDTCCAdditionalFields", path, "");
			})
			.collect(toList());
	}

}
