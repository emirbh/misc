package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.ValuationReport;
import fpml.consolidated.valuation.fpmlreporting.validation.ValuationReportTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.ValuationReportValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.ValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationReport.class)
public class ValuationReportMeta implements RosettaMetaData<ValuationReport> {

	@Override
	public List<Validator<? super ValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationReport> validator(ValidatorFactory factory) {
		return factory.<ValuationReport>create(ValuationReportValidator.class);
	}

	@Override
	public Validator<? super ValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationReport>create(ValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReport> validator() {
		return new ValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReport> typeFormatValidator() {
		return new ValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationReport, Set<String>> onlyExistsValidator() {
		return new ValuationReportOnlyExistsValidator();
	}
}
