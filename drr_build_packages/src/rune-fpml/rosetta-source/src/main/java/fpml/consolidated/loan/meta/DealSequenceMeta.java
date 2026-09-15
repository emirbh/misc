package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealSequence;
import fpml.consolidated.loan.validation.DealSequenceTypeFormatValidator;
import fpml.consolidated.loan.validation.DealSequenceValidator;
import fpml.consolidated.loan.validation.exists.DealSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealSequence.class)
public class DealSequenceMeta implements RosettaMetaData<DealSequence> {

	@Override
	public List<Validator<? super DealSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealSequence> validator(ValidatorFactory factory) {
		return factory.<DealSequence>create(DealSequenceValidator.class);
	}

	@Override
	public Validator<? super DealSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealSequence>create(DealSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealSequence> validator() {
		return new DealSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DealSequence> typeFormatValidator() {
		return new DealSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealSequence, Set<String>> onlyExistsValidator() {
		return new DealSequenceOnlyExistsValidator();
	}
}
