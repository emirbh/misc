package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReportAcknowledgement;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportAcknowledgementTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportAcknowledgementValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.NonpublicExecutionReportAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonpublicExecutionReportAcknowledgement.class)
public class NonpublicExecutionReportAcknowledgementMeta implements RosettaMetaData<NonpublicExecutionReportAcknowledgement> {

	@Override
	public List<Validator<? super NonpublicExecutionReportAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonpublicExecutionReportAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonpublicExecutionReportAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReportAcknowledgement>create(NonpublicExecutionReportAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super NonpublicExecutionReportAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReportAcknowledgement>create(NonpublicExecutionReportAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReportAcknowledgement> validator() {
		return new NonpublicExecutionReportAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReportAcknowledgement> typeFormatValidator() {
		return new NonpublicExecutionReportAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonpublicExecutionReportAcknowledgement, Set<String>> onlyExistsValidator() {
		return new NonpublicExecutionReportAcknowledgementOnlyExistsValidator();
	}
}
