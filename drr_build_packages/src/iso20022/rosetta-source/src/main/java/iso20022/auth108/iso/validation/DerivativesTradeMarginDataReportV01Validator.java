package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.DerivativesTradeMarginDataReportV01;
import iso20022.auth108.iso.TradeData55Choice;
import iso20022.auth108.iso.TradeReportHeader4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativesTradeMarginDataReportV01Validator implements Validator<DerivativesTradeMarginDataReportV01> {

	private List<ComparisonResult> getComparisonResults(DerivativesTradeMarginDataReportV01 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptHdr", (TradeReportHeader4) o.getRptHdr() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradData", (TradeData55Choice) o.getTradData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativesTradeMarginDataReportV01 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativesTradeMarginDataReportV01", ValidationResult.ValidationType.CARDINALITY, "DerivativesTradeMarginDataReportV01", path, "", res.getError());
				}
				return success("DerivativesTradeMarginDataReportV01", ValidationResult.ValidationType.CARDINALITY, "DerivativesTradeMarginDataReportV01", path, "");
			})
			.collect(toList());
	}

}
