package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.ClearingPartyAndTime23__2;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier1Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingPartyAndTime23__2Validator implements Validator<ClearingPartyAndTime23__2> {

	private List<ComparisonResult> getComparisonResults(ClearingPartyAndTime23__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ccp", (OrganisationIdentification15Choice__1) o.getCcp() != null ? 1 : 0, 0, 1), 
				checkCardinality("orgnlIdr", (UniqueTransactionIdentifier1Choice__1) o.getOrgnlIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("orgnlTradRpstryIdr", (OrganisationIdentification15Choice__1) o.getOrgnlTradRpstryIdr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingPartyAndTime23__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingPartyAndTime23__2", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime23__2", path, "", res.getError());
				}
				return success("ClearingPartyAndTime23__2", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime23__2", path, "");
			})
			.collect(toList());
	}

}
