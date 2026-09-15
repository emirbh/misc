package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.PhysicalSwapLeg;
import fpml.consolidated.com.validation.PhysicalSwapLegTypeFormatValidator;
import fpml.consolidated.com.validation.PhysicalSwapLegValidator;
import fpml.consolidated.com.validation.exists.PhysicalSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalSwapLeg.class)
public class PhysicalSwapLegMeta implements RosettaMetaData<PhysicalSwapLeg> {

	@Override
	public List<Validator<? super PhysicalSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PhysicalSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalSwapLeg> validator(ValidatorFactory factory) {
		return factory.<PhysicalSwapLeg>create(PhysicalSwapLegValidator.class);
	}

	@Override
	public Validator<? super PhysicalSwapLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalSwapLeg>create(PhysicalSwapLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSwapLeg> validator() {
		return new PhysicalSwapLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSwapLeg> typeFormatValidator() {
		return new PhysicalSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalSwapLeg, Set<String>> onlyExistsValidator() {
		return new PhysicalSwapLegOnlyExistsValidator();
	}
}
