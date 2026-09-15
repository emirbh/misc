package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.DataSubmission;
import iso20022.dtcc.rds.harmonized.validation.DataSubmissionTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.DataSubmissionValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.DataSubmissionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DataSubmission.class)
public class DataSubmissionMeta implements RosettaMetaData<DataSubmission> {

	@Override
	public List<Validator<? super DataSubmission>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DataSubmission, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DataSubmission> validator(ValidatorFactory factory) {
		return factory.<DataSubmission>create(DataSubmissionValidator.class);
	}

	@Override
	public Validator<? super DataSubmission> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DataSubmission>create(DataSubmissionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DataSubmission> validator() {
		return new DataSubmissionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DataSubmission> typeFormatValidator() {
		return new DataSubmissionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DataSubmission, Set<String>> onlyExistsValidator() {
		return new DataSubmissionOnlyExistsValidator();
	}
}
