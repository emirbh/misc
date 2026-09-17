package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.Reference;
import fpml.consolidated.validation.ReferenceTypeFormatValidator;
import fpml.consolidated.validation.ReferenceValidator;
import fpml.consolidated.validation.exists.ReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Reference.class)
public class ReferenceMeta implements RosettaMetaData<Reference> {

	@Override
	public List<Validator<? super Reference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Reference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Reference> validator(ValidatorFactory factory) {
		return factory.<Reference>create(ReferenceValidator.class);
	}

	@Override
	public Validator<? super Reference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Reference>create(ReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Reference> validator() {
		return new ReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Reference> typeFormatValidator() {
		return new ReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Reference, Set<String>> onlyExistsValidator() {
		return new ReferenceOnlyExistsValidator();
	}
}
