package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ProtectionTermsReference;
import fpml.consolidated.cd.validation.ProtectionTermsReferenceTypeFormatValidator;
import fpml.consolidated.cd.validation.ProtectionTermsReferenceValidator;
import fpml.consolidated.cd.validation.exists.ProtectionTermsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProtectionTermsReference.class)
public class ProtectionTermsReferenceMeta implements RosettaMetaData<ProtectionTermsReference> {

	@Override
	public List<Validator<? super ProtectionTermsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProtectionTermsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProtectionTermsReference> validator(ValidatorFactory factory) {
		return factory.<ProtectionTermsReference>create(ProtectionTermsReferenceValidator.class);
	}

	@Override
	public Validator<? super ProtectionTermsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProtectionTermsReference>create(ProtectionTermsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProtectionTermsReference> validator() {
		return new ProtectionTermsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProtectionTermsReference> typeFormatValidator() {
		return new ProtectionTermsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProtectionTermsReference, Set<String>> onlyExistsValidator() {
		return new ProtectionTermsReferenceOnlyExistsValidator();
	}
}
