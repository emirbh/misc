package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RelativeDateSequence;
import fpml.consolidated.shared.validation.RelativeDateSequenceTypeFormatValidator;
import fpml.consolidated.shared.validation.RelativeDateSequenceValidator;
import fpml.consolidated.shared.validation.datarule.RelativeDateSequenceChoice;
import fpml.consolidated.shared.validation.exists.RelativeDateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RelativeDateSequence.class)
public class RelativeDateSequenceMeta implements RosettaMetaData<RelativeDateSequence> {

	@Override
	public List<Validator<? super RelativeDateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RelativeDateSequence>create(RelativeDateSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RelativeDateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativeDateSequence> validator(ValidatorFactory factory) {
		return factory.<RelativeDateSequence>create(RelativeDateSequenceValidator.class);
	}

	@Override
	public Validator<? super RelativeDateSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelativeDateSequence>create(RelativeDateSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDateSequence> validator() {
		return new RelativeDateSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDateSequence> typeFormatValidator() {
		return new RelativeDateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDateSequence, Set<String>> onlyExistsValidator() {
		return new RelativeDateSequenceOnlyExistsValidator();
	}
}
