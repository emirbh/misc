package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ReferencePair;
import fpml.consolidated.cd.validation.ReferencePairTypeFormatValidator;
import fpml.consolidated.cd.validation.ReferencePairValidator;
import fpml.consolidated.cd.validation.datarule.ReferencePairChoice;
import fpml.consolidated.cd.validation.exists.ReferencePairOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferencePair.class)
public class ReferencePairMeta implements RosettaMetaData<ReferencePair> {

	@Override
	public List<Validator<? super ReferencePair>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReferencePair>create(ReferencePairChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferencePair, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferencePair> validator(ValidatorFactory factory) {
		return factory.<ReferencePair>create(ReferencePairValidator.class);
	}

	@Override
	public Validator<? super ReferencePair> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferencePair>create(ReferencePairTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePair> validator() {
		return new ReferencePairValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePair> typeFormatValidator() {
		return new ReferencePairTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferencePair, Set<String>> onlyExistsValidator() {
		return new ReferencePairOnlyExistsValidator();
	}
}
