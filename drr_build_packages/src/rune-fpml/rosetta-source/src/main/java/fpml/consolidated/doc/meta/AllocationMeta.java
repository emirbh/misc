package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Allocation;
import fpml.consolidated.doc.validation.AllocationTypeFormatValidator;
import fpml.consolidated.doc.validation.AllocationValidator;
import fpml.consolidated.doc.validation.datarule.AllocationChoice;
import fpml.consolidated.doc.validation.exists.AllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Allocation.class)
public class AllocationMeta implements RosettaMetaData<Allocation> {

	@Override
	public List<Validator<? super Allocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Allocation>create(AllocationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Allocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Allocation> validator(ValidatorFactory factory) {
		return factory.<Allocation>create(AllocationValidator.class);
	}

	@Override
	public Validator<? super Allocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Allocation>create(AllocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Allocation> validator() {
		return new AllocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Allocation> typeFormatValidator() {
		return new AllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Allocation, Set<String>> onlyExistsValidator() {
		return new AllocationOnlyExistsValidator();
	}
}
