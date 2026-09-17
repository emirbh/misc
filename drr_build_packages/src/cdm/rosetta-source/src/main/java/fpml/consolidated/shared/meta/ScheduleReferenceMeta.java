package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ScheduleReference;
import fpml.consolidated.shared.validation.ScheduleReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.ScheduleReferenceValidator;
import fpml.consolidated.shared.validation.exists.ScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ScheduleReference.class)
public class ScheduleReferenceMeta implements RosettaMetaData<ScheduleReference> {

	@Override
	public List<Validator<? super ScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ScheduleReference> validator(ValidatorFactory factory) {
		return factory.<ScheduleReference>create(ScheduleReferenceValidator.class);
	}

	@Override
	public Validator<? super ScheduleReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ScheduleReference>create(ScheduleReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ScheduleReference> validator() {
		return new ScheduleReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ScheduleReference> typeFormatValidator() {
		return new ScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ScheduleReference, Set<String>> onlyExistsValidator() {
		return new ScheduleReferenceOnlyExistsValidator();
	}
}
