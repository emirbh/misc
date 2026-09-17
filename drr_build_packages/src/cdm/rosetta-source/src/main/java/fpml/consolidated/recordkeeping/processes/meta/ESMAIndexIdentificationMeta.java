package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import fpml.consolidated.recordkeeping.processes.validation.ESMAIndexIdentificationTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.ESMAIndexIdentificationValidator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.ESMAIndexIdentificationChoice;
import fpml.consolidated.recordkeeping.processes.validation.exists.ESMAIndexIdentificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ESMAIndexIdentification.class)
public class ESMAIndexIdentificationMeta implements RosettaMetaData<ESMAIndexIdentification> {

	@Override
	public List<Validator<? super ESMAIndexIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ESMAIndexIdentification>create(ESMAIndexIdentificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ESMAIndexIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMAIndexIdentification> validator(ValidatorFactory factory) {
		return factory.<ESMAIndexIdentification>create(ESMAIndexIdentificationValidator.class);
	}

	@Override
	public Validator<? super ESMAIndexIdentification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMAIndexIdentification>create(ESMAIndexIdentificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMAIndexIdentification> validator() {
		return new ESMAIndexIdentificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMAIndexIdentification> typeFormatValidator() {
		return new ESMAIndexIdentificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMAIndexIdentification, Set<String>> onlyExistsValidator() {
		return new ESMAIndexIdentificationOnlyExistsValidator();
	}
}
