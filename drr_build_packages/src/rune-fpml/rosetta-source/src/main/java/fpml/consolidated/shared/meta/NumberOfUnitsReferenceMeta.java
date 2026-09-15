package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NumberOfUnitsReference;
import fpml.consolidated.shared.validation.NumberOfUnitsReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.NumberOfUnitsReferenceValidator;
import fpml.consolidated.shared.validation.exists.NumberOfUnitsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NumberOfUnitsReference.class)
public class NumberOfUnitsReferenceMeta implements RosettaMetaData<NumberOfUnitsReference> {

	@Override
	public List<Validator<? super NumberOfUnitsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NumberOfUnitsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NumberOfUnitsReference> validator(ValidatorFactory factory) {
		return factory.<NumberOfUnitsReference>create(NumberOfUnitsReferenceValidator.class);
	}

	@Override
	public Validator<? super NumberOfUnitsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NumberOfUnitsReference>create(NumberOfUnitsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NumberOfUnitsReference> validator() {
		return new NumberOfUnitsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NumberOfUnitsReference> typeFormatValidator() {
		return new NumberOfUnitsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NumberOfUnitsReference, Set<String>> onlyExistsValidator() {
		return new NumberOfUnitsReferenceOnlyExistsValidator();
	}
}
