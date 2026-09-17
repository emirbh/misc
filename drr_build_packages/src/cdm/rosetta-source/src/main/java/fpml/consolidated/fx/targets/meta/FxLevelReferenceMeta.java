package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxLevelReference;
import fpml.consolidated.fx.targets.validation.FxLevelReferenceTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxLevelReferenceValidator;
import fpml.consolidated.fx.targets.validation.exists.FxLevelReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxLevelReference.class)
public class FxLevelReferenceMeta implements RosettaMetaData<FxLevelReference> {

	@Override
	public List<Validator<? super FxLevelReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxLevelReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxLevelReference> validator(ValidatorFactory factory) {
		return factory.<FxLevelReference>create(FxLevelReferenceValidator.class);
	}

	@Override
	public Validator<? super FxLevelReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxLevelReference>create(FxLevelReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxLevelReference> validator() {
		return new FxLevelReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxLevelReference> typeFormatValidator() {
		return new FxLevelReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxLevelReference, Set<String>> onlyExistsValidator() {
		return new FxLevelReferenceOnlyExistsValidator();
	}
}
