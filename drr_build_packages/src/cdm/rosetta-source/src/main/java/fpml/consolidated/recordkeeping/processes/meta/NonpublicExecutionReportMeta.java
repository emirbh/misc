package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReport;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportValidator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.NonpublicExecutionReportChoice;
import fpml.consolidated.recordkeeping.processes.validation.exists.NonpublicExecutionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonpublicExecutionReport.class)
public class NonpublicExecutionReportMeta implements RosettaMetaData<NonpublicExecutionReport> {

	@Override
	public List<Validator<? super NonpublicExecutionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NonpublicExecutionReport>create(NonpublicExecutionReportChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NonpublicExecutionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonpublicExecutionReport> validator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReport>create(NonpublicExecutionReportValidator.class);
	}

	@Override
	public Validator<? super NonpublicExecutionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReport>create(NonpublicExecutionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReport> validator() {
		return new NonpublicExecutionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReport> typeFormatValidator() {
		return new NonpublicExecutionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonpublicExecutionReport, Set<String>> onlyExistsValidator() {
		return new NonpublicExecutionReportOnlyExistsValidator();
	}
}
