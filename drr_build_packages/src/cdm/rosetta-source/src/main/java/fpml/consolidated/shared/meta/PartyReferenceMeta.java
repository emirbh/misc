package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.validation.PartyReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyReferenceValidator;
import fpml.consolidated.shared.validation.exists.PartyReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyReference.class)
public class PartyReferenceMeta implements RosettaMetaData<PartyReference> {

	@Override
	public List<Validator<? super PartyReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyReference> validator(ValidatorFactory factory) {
		return factory.<PartyReference>create(PartyReferenceValidator.class);
	}

	@Override
	public Validator<? super PartyReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyReference>create(PartyReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyReference> validator() {
		return new PartyReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyReference> typeFormatValidator() {
		return new PartyReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyReference, Set<String>> onlyExistsValidator() {
		return new PartyReferenceOnlyExistsValidator();
	}
}
