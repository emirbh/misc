package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.PhysicalForwardLeg;
import fpml.consolidated.com.validation.PhysicalForwardLegTypeFormatValidator;
import fpml.consolidated.com.validation.PhysicalForwardLegValidator;
import fpml.consolidated.com.validation.exists.PhysicalForwardLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalForwardLeg.class)
public class PhysicalForwardLegMeta implements RosettaMetaData<PhysicalForwardLeg> {

	@Override
	public List<Validator<? super PhysicalForwardLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PhysicalForwardLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalForwardLeg> validator(ValidatorFactory factory) {
		return factory.<PhysicalForwardLeg>create(PhysicalForwardLegValidator.class);
	}

	@Override
	public Validator<? super PhysicalForwardLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalForwardLeg>create(PhysicalForwardLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalForwardLeg> validator() {
		return new PhysicalForwardLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalForwardLeg> typeFormatValidator() {
		return new PhysicalForwardLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalForwardLeg, Set<String>> onlyExistsValidator() {
		return new PhysicalForwardLegOnlyExistsValidator();
	}
}
