package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.esma.OptionOrSwaption10__1;
import iso20022.auth030.esma.OptionStyle6Code__1;
import iso20022.auth030.esma.OptionType2Code;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionOrSwaption10__1Validator implements Validator<OptionOrSwaption10__1> {

	private List<ComparisonResult> getComparisonResults(OptionOrSwaption10__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tp", (OptionType2Code) o.getTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("exrcStyle", (OptionStyle6Code__1) o.getExrcStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("strkPric", (SecuritiesTransactionPrice17Choice__1) o.getStrkPric() != null ? 1 : 0, 0, 1), 
				checkCardinality("prmAmt", (ActiveOrHistoricCurrencyAnd5DecimalAmount__1) o.getPrmAmt() != null ? 1 : 0, 0, 1), 
				checkCardinality("prmPmtDt", (Date) o.getPrmPmtDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("mtrtyDtOfUndrlyg", (Date) o.getMtrtyDtOfUndrlyg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionOrSwaption10__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionOrSwaption10__1", ValidationResult.ValidationType.CARDINALITY, "OptionOrSwaption10__1", path, "", res.getError());
				}
				return success("OptionOrSwaption10__1", ValidationResult.ValidationType.CARDINALITY, "OptionOrSwaption10__1", path, "");
			})
			.collect(toList());
	}

}
