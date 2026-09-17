package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.X509DataTypeSequence;
import fpml.consolidated.validation.X509DataTypeSequenceTypeFormatValidator;
import fpml.consolidated.validation.X509DataTypeSequenceValidator;
import fpml.consolidated.validation.datarule.X509DataTypeSequenceChoice;
import fpml.consolidated.validation.exists.X509DataTypeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=X509DataTypeSequence.class)
public class X509DataTypeSequenceMeta implements RosettaMetaData<X509DataTypeSequence> {

	@Override
	public List<Validator<? super X509DataTypeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<X509DataTypeSequence>create(X509DataTypeSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super X509DataTypeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super X509DataTypeSequence> validator(ValidatorFactory factory) {
		return factory.<X509DataTypeSequence>create(X509DataTypeSequenceValidator.class);
	}

	@Override
	public Validator<? super X509DataTypeSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<X509DataTypeSequence>create(X509DataTypeSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super X509DataTypeSequence> validator() {
		return new X509DataTypeSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super X509DataTypeSequence> typeFormatValidator() {
		return new X509DataTypeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509DataTypeSequence, Set<String>> onlyExistsValidator() {
		return new X509DataTypeSequenceOnlyExistsValidator();
	}
}
