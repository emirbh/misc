package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.asset.validation.AnyAssetReferenceTypeFormatValidator;
import fpml.consolidated.asset.validation.AnyAssetReferenceValidator;
import fpml.consolidated.asset.validation.exists.AnyAssetReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AnyAssetReference.class)
public class AnyAssetReferenceMeta implements RosettaMetaData<AnyAssetReference> {

	@Override
	public List<Validator<? super AnyAssetReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnyAssetReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnyAssetReference> validator(ValidatorFactory factory) {
		return factory.<AnyAssetReference>create(AnyAssetReferenceValidator.class);
	}

	@Override
	public Validator<? super AnyAssetReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnyAssetReference>create(AnyAssetReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnyAssetReference> validator() {
		return new AnyAssetReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnyAssetReference> typeFormatValidator() {
		return new AnyAssetReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnyAssetReference, Set<String>> onlyExistsValidator() {
		return new AnyAssetReferenceOnlyExistsValidator();
	}
}
