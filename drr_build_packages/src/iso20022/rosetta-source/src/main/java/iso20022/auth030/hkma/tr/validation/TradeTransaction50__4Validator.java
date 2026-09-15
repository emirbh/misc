package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.DerivativeEvent6__4;
import iso20022.auth030.hkma.tr.OtherPayment5__1;
import iso20022.auth030.hkma.tr.TradeTransaction50__4;
import iso20022.auth030.hkma.tr.UniqueTransactionIdentifier2Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction50__4Validator implements Validator<TradeTransaction50__4> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction50__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__1) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("earlyTermntnDt", (Date) o.getEarlyTermntnDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__4) o.getDerivEvt() != null ? 1 : 0, 1, 1), 
				checkCardinality("othrPmt", (List<? extends OtherPayment5__1>) o.getOthrPmt() == null ? 0 : o.getOthrPmt().size(), 0, 600)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction50__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction50__4", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__4", path, "", res.getError());
				}
				return success("TradeTransaction50__4", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__4", path, "");
			})
			.collect(toList());
	}

}
