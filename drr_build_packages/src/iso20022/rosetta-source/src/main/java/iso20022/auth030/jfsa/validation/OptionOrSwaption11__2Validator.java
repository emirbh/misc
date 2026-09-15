package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.jfsa.EmbeddedType1Code;
import iso20022.auth030.jfsa.ExerciseDate1Choice__1;
import iso20022.auth030.jfsa.OptionOrSwaption11__2;
import iso20022.auth030.jfsa.OptionStyle6Code;
import iso20022.auth030.jfsa.OptionType2Code;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionOrSwaption11__2Validator implements Validator<OptionOrSwaption11__2> {

	private List<ComparisonResult> getComparisonResults(OptionOrSwaption11__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tp", (OptionType2Code) o.getTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("mbddTp", (EmbeddedType1Code) o.getMbddTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("exrcStyle", (OptionStyle6Code) o.getExrcStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("exrcDt", (ExerciseDate1Choice__1) o.getExrcDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("strkPric", (SecuritiesTransactionPrice17Choice__1) o.getStrkPric() != null ? 1 : 0, 0, 1), 
				checkCardinality("callAmt", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getCallAmt() != null ? 1 : 0, 0, 1), 
				checkCardinality("putAmt", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getPutAmt() != null ? 1 : 0, 0, 1), 
				checkCardinality("prmAmt", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getPrmAmt() != null ? 1 : 0, 0, 1), 
				checkCardinality("prmPmtDt", (Date) o.getPrmPmtDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("mtrtyDtOfUndrlyg", (Date) o.getMtrtyDtOfUndrlyg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionOrSwaption11__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionOrSwaption11__2", ValidationResult.ValidationType.CARDINALITY, "OptionOrSwaption11__2", path, "", res.getError());
				}
				return success("OptionOrSwaption11__2", ValidationResult.ValidationType.CARDINALITY, "OptionOrSwaption11__2", path, "");
			})
			.collect(toList());
	}

}
