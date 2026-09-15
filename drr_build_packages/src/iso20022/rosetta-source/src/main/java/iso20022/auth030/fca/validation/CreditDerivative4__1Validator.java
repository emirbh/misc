package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.CreditDerivative4__1;
import iso20022.auth030.fca.DebtInstrumentSeniorityType2Code;
import iso20022.auth030.fca.DerivativePartyIdentification1Choice;
import iso20022.auth030.fca.TrancheIndicator3Choice__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditDerivative4__1Validator implements Validator<CreditDerivative4__1> {

	private List<ComparisonResult> getComparisonResults(CreditDerivative4__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("snrty", (DebtInstrumentSeniorityType2Code) o.getSnrty() != null ? 1 : 0, 0, 1), 
				checkCardinality("refPty", (DerivativePartyIdentification1Choice) o.getRefPty() != null ? 1 : 0, 0, 1), 
				checkCardinality("srs", (Integer) o.getSrs() != null ? 1 : 0, 0, 1), 
				checkCardinality("vrsn", (Integer) o.getVrsn() != null ? 1 : 0, 0, 1), 
				checkCardinality("indxFctr", (BigDecimal) o.getIndxFctr() != null ? 1 : 0, 0, 1), 
				checkCardinality("trch", (TrancheIndicator3Choice__1) o.getTrch() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDerivative4__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDerivative4__1", ValidationResult.ValidationType.CARDINALITY, "CreditDerivative4__1", path, "", res.getError());
				}
				return success("CreditDerivative4__1", ValidationResult.ValidationType.CARDINALITY, "CreditDerivative4__1", path, "");
			})
			.collect(toList());
	}

}
