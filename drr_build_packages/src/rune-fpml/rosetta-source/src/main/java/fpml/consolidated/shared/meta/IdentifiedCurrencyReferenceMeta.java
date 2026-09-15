package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import fpml.consolidated.shared.validation.IdentifiedCurrencyReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.IdentifiedCurrencyReferenceValidator;
import fpml.consolidated.shared.validation.exists.IdentifiedCurrencyReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IdentifiedCurrencyReference.class)
public class IdentifiedCurrencyReferenceMeta implements RosettaMetaData<IdentifiedCurrencyReference> {

	@Override
	public List<Validator<? super IdentifiedCurrencyReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedCurrencyReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IdentifiedCurrencyReference> validator(ValidatorFactory factory) {
		return factory.<IdentifiedCurrencyReference>create(IdentifiedCurrencyReferenceValidator.class);
	}

	@Override
	public Validator<? super IdentifiedCurrencyReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IdentifiedCurrencyReference>create(IdentifiedCurrencyReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedCurrencyReference> validator() {
		return new IdentifiedCurrencyReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedCurrencyReference> typeFormatValidator() {
		return new IdentifiedCurrencyReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedCurrencyReference, Set<String>> onlyExistsValidator() {
		return new IdentifiedCurrencyReferenceOnlyExistsValidator();
	}
}
