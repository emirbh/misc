package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.RequestValuationReport;
import fpml.consolidated.valuation.fpmlreporting.validation.RequestValuationReportTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.RequestValuationReportValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.RequestValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestValuationReport.class)
public class RequestValuationReportMeta implements RosettaMetaData<RequestValuationReport> {

	@Override
	public List<Validator<? super RequestValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestValuationReport> validator(ValidatorFactory factory) {
		return factory.<RequestValuationReport>create(RequestValuationReportValidator.class);
	}

	@Override
	public Validator<? super RequestValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestValuationReport>create(RequestValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestValuationReport> validator() {
		return new RequestValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestValuationReport> typeFormatValidator() {
		return new RequestValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestValuationReport, Set<String>> onlyExistsValidator() {
		return new RequestValuationReportOnlyExistsValidator();
	}
}
