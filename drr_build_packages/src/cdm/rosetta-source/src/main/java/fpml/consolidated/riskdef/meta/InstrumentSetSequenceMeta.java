package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.InstrumentSetSequence;
import fpml.consolidated.riskdef.validation.InstrumentSetSequenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.InstrumentSetSequenceValidator;
import fpml.consolidated.riskdef.validation.datarule.InstrumentSetSequenceChoice;
import fpml.consolidated.riskdef.validation.exists.InstrumentSetSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InstrumentSetSequence.class)
public class InstrumentSetSequenceMeta implements RosettaMetaData<InstrumentSetSequence> {

	@Override
	public List<Validator<? super InstrumentSetSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InstrumentSetSequence>create(InstrumentSetSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InstrumentSetSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InstrumentSetSequence> validator(ValidatorFactory factory) {
		return factory.<InstrumentSetSequence>create(InstrumentSetSequenceValidator.class);
	}

	@Override
	public Validator<? super InstrumentSetSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InstrumentSetSequence>create(InstrumentSetSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentSetSequence> validator() {
		return new InstrumentSetSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentSetSequence> typeFormatValidator() {
		return new InstrumentSetSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentSetSequence, Set<String>> onlyExistsValidator() {
		return new InstrumentSetSequenceOnlyExistsValidator();
	}
}
