package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PricingStructureReference;
import fpml.consolidated.shared.validation.PricingStructureReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.PricingStructureReferenceValidator;
import fpml.consolidated.shared.validation.exists.PricingStructureReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingStructureReference.class)
public class PricingStructureReferenceMeta implements RosettaMetaData<PricingStructureReference> {

	@Override
	public List<Validator<? super PricingStructureReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingStructureReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingStructureReference> validator(ValidatorFactory factory) {
		return factory.<PricingStructureReference>create(PricingStructureReferenceValidator.class);
	}

	@Override
	public Validator<? super PricingStructureReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingStructureReference>create(PricingStructureReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructureReference> validator() {
		return new PricingStructureReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructureReference> typeFormatValidator() {
		return new PricingStructureReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructureReference, Set<String>> onlyExistsValidator() {
		return new PricingStructureReferenceOnlyExistsValidator();
	}
}
