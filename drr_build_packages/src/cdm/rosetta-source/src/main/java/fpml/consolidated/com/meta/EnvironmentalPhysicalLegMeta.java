package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.com.validation.EnvironmentalPhysicalLegTypeFormatValidator;
import fpml.consolidated.com.validation.EnvironmentalPhysicalLegValidator;
import fpml.consolidated.com.validation.datarule.EnvironmentalPhysicalLegChoice;
import fpml.consolidated.com.validation.exists.EnvironmentalPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EnvironmentalPhysicalLeg.class)
public class EnvironmentalPhysicalLegMeta implements RosettaMetaData<EnvironmentalPhysicalLeg> {

	@Override
	public List<Validator<? super EnvironmentalPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EnvironmentalPhysicalLeg>create(EnvironmentalPhysicalLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalPhysicalLeg> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalPhysicalLeg>create(EnvironmentalPhysicalLegValidator.class);
	}

	@Override
	public Validator<? super EnvironmentalPhysicalLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalPhysicalLeg>create(EnvironmentalPhysicalLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalPhysicalLeg> validator() {
		return new EnvironmentalPhysicalLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalPhysicalLeg> typeFormatValidator() {
		return new EnvironmentalPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new EnvironmentalPhysicalLegOnlyExistsValidator();
	}
}
