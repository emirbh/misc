package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.MetalPhysicalLeg;
import fpml.consolidated.com.validation.MetalPhysicalLegTypeFormatValidator;
import fpml.consolidated.com.validation.MetalPhysicalLegValidator;
import fpml.consolidated.com.validation.datarule.MetalPhysicalLegChoice;
import fpml.consolidated.com.validation.exists.MetalPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MetalPhysicalLeg.class)
public class MetalPhysicalLegMeta implements RosettaMetaData<MetalPhysicalLeg> {

	@Override
	public List<Validator<? super MetalPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MetalPhysicalLeg>create(MetalPhysicalLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MetalPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MetalPhysicalLeg> validator(ValidatorFactory factory) {
		return factory.<MetalPhysicalLeg>create(MetalPhysicalLegValidator.class);
	}

	@Override
	public Validator<? super MetalPhysicalLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MetalPhysicalLeg>create(MetalPhysicalLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MetalPhysicalLeg> validator() {
		return new MetalPhysicalLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MetalPhysicalLeg> typeFormatValidator() {
		return new MetalPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MetalPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new MetalPhysicalLegOnlyExistsValidator();
	}
}
