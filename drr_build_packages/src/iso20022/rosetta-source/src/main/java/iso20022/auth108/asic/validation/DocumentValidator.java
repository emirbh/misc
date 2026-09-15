package iso20022.auth108.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.asic.DerivativesTradeMarginDataReportV02;
import iso20022.auth108.asic.Document;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DocumentValidator implements Validator<Document> {

	private List<ComparisonResult> getComparisonResults(Document o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("derivsTradMrgnDataRpt", (DerivativesTradeMarginDataReportV02) o.getDerivsTradMrgnDataRpt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Document o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Document", ValidationResult.ValidationType.CARDINALITY, "Document", path, "", res.getError());
				}
				return success("Document", ValidationResult.ValidationType.CARDINALITY, "Document", path, "");
			})
			.collect(toList());
	}

}
