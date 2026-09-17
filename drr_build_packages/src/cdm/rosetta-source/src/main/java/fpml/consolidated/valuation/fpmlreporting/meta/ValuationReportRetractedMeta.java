package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.ValuationReportRetracted;
import fpml.consolidated.valuation.fpmlreporting.validation.ValuationReportRetractedTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.ValuationReportRetractedValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.ValuationReportRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationReportRetracted.class)
public class ValuationReportRetractedMeta implements RosettaMetaData<ValuationReportRetracted> {

	@Override
	public List<Validator<? super ValuationReportRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationReportRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationReportRetracted> validator(ValidatorFactory factory) {
		return factory.<ValuationReportRetracted>create(ValuationReportRetractedValidator.class);
	}

	@Override
	public Validator<? super ValuationReportRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationReportRetracted>create(ValuationReportRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReportRetracted> validator() {
		return new ValuationReportRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReportRetracted> typeFormatValidator() {
		return new ValuationReportRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationReportRetracted, Set<String>> onlyExistsValidator() {
		return new ValuationReportRetractedOnlyExistsValidator();
	}
}
