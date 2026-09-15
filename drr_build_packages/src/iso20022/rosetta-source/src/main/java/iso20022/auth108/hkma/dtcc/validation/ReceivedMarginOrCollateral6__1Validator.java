package iso20022.auth108.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.dtcc.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth108.hkma.dtcc.ReceivedMarginOrCollateral6__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReceivedMarginOrCollateral6__1Validator implements Validator<ReceivedMarginOrCollateral6__1> {

	private List<ComparisonResult> getComparisonResults(ReceivedMarginOrCollateral6__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initlMrgnRcvdPreHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnRcvdPreHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("initlMrgnRcvdPstHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnRcvdPstHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("vartnMrgnRcvdPreHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnRcvdPreHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("vartnMrgnRcvdPstHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnRcvdPstHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("xcssCollRcvd", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getXcssCollRcvd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReceivedMarginOrCollateral6__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReceivedMarginOrCollateral6__1", ValidationResult.ValidationType.CARDINALITY, "ReceivedMarginOrCollateral6__1", path, "", res.getError());
				}
				return success("ReceivedMarginOrCollateral6__1", ValidationResult.ValidationType.CARDINALITY, "ReceivedMarginOrCollateral6__1", path, "");
			})
			.collect(toList());
	}

}
