package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.validation.BusinessCentersReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessCentersReferenceValidator;
import fpml.consolidated.shared.validation.exists.BusinessCentersReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessCentersReference.class)
public class BusinessCentersReferenceMeta implements RosettaMetaData<BusinessCentersReference> {

	@Override
	public List<Validator<? super BusinessCentersReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCentersReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessCentersReference> validator(ValidatorFactory factory) {
		return factory.<BusinessCentersReference>create(BusinessCentersReferenceValidator.class);
	}

	@Override
	public Validator<? super BusinessCentersReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessCentersReference>create(BusinessCentersReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCentersReference> validator() {
		return new BusinessCentersReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCentersReference> typeFormatValidator() {
		return new BusinessCentersReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCentersReference, Set<String>> onlyExistsValidator() {
		return new BusinessCentersReferenceOnlyExistsValidator();
	}
}
