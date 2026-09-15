package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessDayAdjustmentsReference;
import fpml.consolidated.shared.validation.BusinessDayAdjustmentsReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessDayAdjustmentsReferenceValidator;
import fpml.consolidated.shared.validation.exists.BusinessDayAdjustmentsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessDayAdjustmentsReference.class)
public class BusinessDayAdjustmentsReferenceMeta implements RosettaMetaData<BusinessDayAdjustmentsReference> {

	@Override
	public List<Validator<? super BusinessDayAdjustmentsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessDayAdjustmentsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessDayAdjustmentsReference> validator(ValidatorFactory factory) {
		return factory.<BusinessDayAdjustmentsReference>create(BusinessDayAdjustmentsReferenceValidator.class);
	}

	@Override
	public Validator<? super BusinessDayAdjustmentsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessDayAdjustmentsReference>create(BusinessDayAdjustmentsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDayAdjustmentsReference> validator() {
		return new BusinessDayAdjustmentsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDayAdjustmentsReference> typeFormatValidator() {
		return new BusinessDayAdjustmentsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDayAdjustmentsReference, Set<String>> onlyExistsValidator() {
		return new BusinessDayAdjustmentsReferenceOnlyExistsValidator();
	}
}
