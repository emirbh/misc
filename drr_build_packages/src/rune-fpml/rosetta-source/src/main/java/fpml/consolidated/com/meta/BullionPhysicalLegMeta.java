package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.BullionPhysicalLeg;
import fpml.consolidated.com.validation.BullionPhysicalLegTypeFormatValidator;
import fpml.consolidated.com.validation.BullionPhysicalLegValidator;
import fpml.consolidated.com.validation.datarule.BullionPhysicalLegChoice;
import fpml.consolidated.com.validation.exists.BullionPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BullionPhysicalLeg.class)
public class BullionPhysicalLegMeta implements RosettaMetaData<BullionPhysicalLeg> {

	@Override
	public List<Validator<? super BullionPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BullionPhysicalLeg>create(BullionPhysicalLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BullionPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BullionPhysicalLeg> validator(ValidatorFactory factory) {
		return factory.<BullionPhysicalLeg>create(BullionPhysicalLegValidator.class);
	}

	@Override
	public Validator<? super BullionPhysicalLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BullionPhysicalLeg>create(BullionPhysicalLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BullionPhysicalLeg> validator() {
		return new BullionPhysicalLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BullionPhysicalLeg> typeFormatValidator() {
		return new BullionPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BullionPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new BullionPhysicalLegOnlyExistsValidator();
	}
}
