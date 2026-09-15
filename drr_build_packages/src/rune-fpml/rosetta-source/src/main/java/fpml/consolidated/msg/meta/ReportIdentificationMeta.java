package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ReportIdentification;
import fpml.consolidated.msg.validation.ReportIdentificationTypeFormatValidator;
import fpml.consolidated.msg.validation.ReportIdentificationValidator;
import fpml.consolidated.msg.validation.exists.ReportIdentificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportIdentification.class)
public class ReportIdentificationMeta implements RosettaMetaData<ReportIdentification> {

	@Override
	public List<Validator<? super ReportIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportIdentification> validator(ValidatorFactory factory) {
		return factory.<ReportIdentification>create(ReportIdentificationValidator.class);
	}

	@Override
	public Validator<? super ReportIdentification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportIdentification>create(ReportIdentificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportIdentification> validator() {
		return new ReportIdentificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportIdentification> typeFormatValidator() {
		return new ReportIdentificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportIdentification, Set<String>> onlyExistsValidator() {
		return new ReportIdentificationOnlyExistsValidator();
	}
}
