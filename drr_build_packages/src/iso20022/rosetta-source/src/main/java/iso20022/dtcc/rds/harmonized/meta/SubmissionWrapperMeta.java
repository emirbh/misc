package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.SubmissionWrapper;
import iso20022.dtcc.rds.harmonized.validation.SubmissionWrapperTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.SubmissionWrapperValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.SubmissionWrapperOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SubmissionWrapper.class)
public class SubmissionWrapperMeta implements RosettaMetaData<SubmissionWrapper> {

	@Override
	public List<Validator<? super SubmissionWrapper>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SubmissionWrapper, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SubmissionWrapper> validator(ValidatorFactory factory) {
		return factory.<SubmissionWrapper>create(SubmissionWrapperValidator.class);
	}

	@Override
	public Validator<? super SubmissionWrapper> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SubmissionWrapper>create(SubmissionWrapperTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SubmissionWrapper> validator() {
		return new SubmissionWrapperValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SubmissionWrapper> typeFormatValidator() {
		return new SubmissionWrapperTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SubmissionWrapper, Set<String>> onlyExistsValidator() {
		return new SubmissionWrapperOnlyExistsValidator();
	}
}
