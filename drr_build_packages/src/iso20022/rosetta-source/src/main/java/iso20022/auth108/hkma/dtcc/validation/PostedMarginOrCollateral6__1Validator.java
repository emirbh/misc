package iso20022.auth108.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.dtcc.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth108.hkma.dtcc.PostedMarginOrCollateral6__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PostedMarginOrCollateral6__1Validator implements Validator<PostedMarginOrCollateral6__1> {

	private List<ComparisonResult> getComparisonResults(PostedMarginOrCollateral6__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initlMrgnPstdPreHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnPstdPreHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("initlMrgnPstdPstHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnPstdPstHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("vartnMrgnPstdPreHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnPstdPreHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("vartnMrgnPstdPstHrcut", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnPstdPstHrcut() != null ? 1 : 0, 0, 1), 
				checkCardinality("xcssCollPstd", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getXcssCollPstd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostedMarginOrCollateral6__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostedMarginOrCollateral6__1", ValidationResult.ValidationType.CARDINALITY, "PostedMarginOrCollateral6__1", path, "", res.getError());
				}
				return success("PostedMarginOrCollateral6__1", ValidationResult.ValidationType.CARDINALITY, "PostedMarginOrCollateral6__1", path, "");
			})
			.collect(toList());
	}

}
