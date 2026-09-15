package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassification;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryClassification.class)
public class RegulatoryClassificationMeta implements RosettaMetaData<RegulatoryClassification> {

	@Override
	public List<Validator<? super RegulatoryClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryClassification> validator(ValidatorFactory factory) {
		return factory.<RegulatoryClassification>create(RegulatoryClassificationValidator.class);
	}

	@Override
	public Validator<? super RegulatoryClassification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryClassification>create(RegulatoryClassificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassification> validator() {
		return new RegulatoryClassificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassification> typeFormatValidator() {
		return new RegulatoryClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryClassification, Set<String>> onlyExistsValidator() {
		return new RegulatoryClassificationOnlyExistsValidator();
	}
}
