package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ObjectTypeSequence;
import fpml.consolidated.validation.ObjectTypeSequenceTypeFormatValidator;
import fpml.consolidated.validation.ObjectTypeSequenceValidator;
import fpml.consolidated.validation.exists.ObjectTypeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObjectTypeSequence.class)
public class ObjectTypeSequenceMeta implements RosettaMetaData<ObjectTypeSequence> {

	@Override
	public List<Validator<? super ObjectTypeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObjectTypeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObjectTypeSequence> validator(ValidatorFactory factory) {
		return factory.<ObjectTypeSequence>create(ObjectTypeSequenceValidator.class);
	}

	@Override
	public Validator<? super ObjectTypeSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObjectTypeSequence>create(ObjectTypeSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObjectTypeSequence> validator() {
		return new ObjectTypeSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObjectTypeSequence> typeFormatValidator() {
		return new ObjectTypeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObjectTypeSequence, Set<String>> onlyExistsValidator() {
		return new ObjectTypeSequenceOnlyExistsValidator();
	}
}
