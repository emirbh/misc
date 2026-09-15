package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.BullionDeliveryLocation;
import fpml.consolidated.com.validation.BullionDeliveryLocationTypeFormatValidator;
import fpml.consolidated.com.validation.BullionDeliveryLocationValidator;
import fpml.consolidated.com.validation.exists.BullionDeliveryLocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BullionDeliveryLocation.class)
public class BullionDeliveryLocationMeta implements RosettaMetaData<BullionDeliveryLocation> {

	@Override
	public List<Validator<? super BullionDeliveryLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BullionDeliveryLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BullionDeliveryLocation> validator(ValidatorFactory factory) {
		return factory.<BullionDeliveryLocation>create(BullionDeliveryLocationValidator.class);
	}

	@Override
	public Validator<? super BullionDeliveryLocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BullionDeliveryLocation>create(BullionDeliveryLocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BullionDeliveryLocation> validator() {
		return new BullionDeliveryLocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BullionDeliveryLocation> typeFormatValidator() {
		return new BullionDeliveryLocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BullionDeliveryLocation, Set<String>> onlyExistsValidator() {
		return new BullionDeliveryLocationOnlyExistsValidator();
	}
}
