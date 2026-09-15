package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.ContractType15__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ContractType15__1TypeFormatValidator implements Validator<ContractType15__1> {

	private List<ComparisonResult> getComparisonResults(ContractType15__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("undrlygAsstTradgPltfmIdr", o.getUndrlygAsstTradgPltfmIdr(), 0, empty(), of(Pattern.compile("[A-Z0-9]{4,4}"))), 
				checkString("undrlygAsstPricSrc", o.getUndrlygAsstPricSrc(), 1, of(50), empty()), 
				checkString("plcOfSttlm", o.getPlcOfSttlm(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractType15__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractType15__1", ValidationResult.ValidationType.TYPE_FORMAT, "ContractType15__1", path, "", res.getError());
				}
				return success("ContractType15__1", ValidationResult.ValidationType.TYPE_FORMAT, "ContractType15__1", path, "");
			})
			.collect(toList());
	}

}
