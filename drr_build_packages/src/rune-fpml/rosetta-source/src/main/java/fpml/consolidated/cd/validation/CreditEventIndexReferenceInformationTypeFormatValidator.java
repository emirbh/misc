package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CreditEventIndexReferenceInformation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CreditEventIndexReferenceInformationTypeFormatValidator implements Validator<CreditEventIndexReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(CreditEventIndexReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("indexSeries", o.getIndexSeries(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("indexAnnexVersion", o.getIndexAnnexVersion(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEventIndexReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEventIndexReferenceInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CreditEventIndexReferenceInformation", path, "", res.getError());
				}
				return success("CreditEventIndexReferenceInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CreditEventIndexReferenceInformation", path, "");
			})
			.collect(toList());
	}

}
