package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.LegalEntityReference;
import fpml.consolidated.shared.validation.LegalEntityReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.LegalEntityReferenceValidator;
import fpml.consolidated.shared.validation.exists.LegalEntityReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegalEntityReference.class)
public class LegalEntityReferenceMeta implements RosettaMetaData<LegalEntityReference> {

	@Override
	public List<Validator<? super LegalEntityReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalEntityReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalEntityReference> validator(ValidatorFactory factory) {
		return factory.<LegalEntityReference>create(LegalEntityReferenceValidator.class);
	}

	@Override
	public Validator<? super LegalEntityReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalEntityReference>create(LegalEntityReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalEntityReference> validator() {
		return new LegalEntityReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalEntityReference> typeFormatValidator() {
		return new LegalEntityReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalEntityReference, Set<String>> onlyExistsValidator() {
		return new LegalEntityReferenceOnlyExistsValidator();
	}
}
