package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCentersOrReference;
import fpml.consolidated.shared.validation.BusinessCentersOrReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessCentersOrReferenceValidator;
import fpml.consolidated.shared.validation.datarule.BusinessCentersOrReferenceChoice;
import fpml.consolidated.shared.validation.exists.BusinessCentersOrReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessCentersOrReference.class)
public class BusinessCentersOrReferenceMeta implements RosettaMetaData<BusinessCentersOrReference> {

	@Override
	public List<Validator<? super BusinessCentersOrReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BusinessCentersOrReference>create(BusinessCentersOrReferenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BusinessCentersOrReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessCentersOrReference> validator(ValidatorFactory factory) {
		return factory.<BusinessCentersOrReference>create(BusinessCentersOrReferenceValidator.class);
	}

	@Override
	public Validator<? super BusinessCentersOrReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessCentersOrReference>create(BusinessCentersOrReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCentersOrReference> validator() {
		return new BusinessCentersOrReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCentersOrReference> typeFormatValidator() {
		return new BusinessCentersOrReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCentersOrReference, Set<String>> onlyExistsValidator() {
		return new BusinessCentersOrReferenceOnlyExistsValidator();
	}
}
