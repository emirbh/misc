package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.validation.LastFloatingReferenceTypeFormatValidator;
import drr.regulation.common.validation.LastFloatingReferenceValidator;
import drr.regulation.common.validation.exists.LastFloatingReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=LastFloatingReference.class)
public class LastFloatingReferenceMeta implements RosettaMetaData<LastFloatingReference> {

	@Override
	public List<Validator<? super LastFloatingReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LastFloatingReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LastFloatingReference> validator(ValidatorFactory factory) {
		return factory.<LastFloatingReference>create(LastFloatingReferenceValidator.class);
	}

	@Override
	public Validator<? super LastFloatingReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LastFloatingReference>create(LastFloatingReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LastFloatingReference> validator() {
		return new LastFloatingReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LastFloatingReference> typeFormatValidator() {
		return new LastFloatingReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LastFloatingReference, Set<String>> onlyExistsValidator() {
		return new LastFloatingReferenceOnlyExistsValidator();
	}
}
