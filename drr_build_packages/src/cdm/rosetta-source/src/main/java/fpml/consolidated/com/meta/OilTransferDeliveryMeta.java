package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.OilTransferDelivery;
import fpml.consolidated.com.validation.OilTransferDeliveryTypeFormatValidator;
import fpml.consolidated.com.validation.OilTransferDeliveryValidator;
import fpml.consolidated.com.validation.exists.OilTransferDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OilTransferDelivery.class)
public class OilTransferDeliveryMeta implements RosettaMetaData<OilTransferDelivery> {

	@Override
	public List<Validator<? super OilTransferDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilTransferDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OilTransferDelivery> validator(ValidatorFactory factory) {
		return factory.<OilTransferDelivery>create(OilTransferDeliveryValidator.class);
	}

	@Override
	public Validator<? super OilTransferDelivery> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OilTransferDelivery>create(OilTransferDeliveryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OilTransferDelivery> validator() {
		return new OilTransferDeliveryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OilTransferDelivery> typeFormatValidator() {
		return new OilTransferDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilTransferDelivery, Set<String>> onlyExistsValidator() {
		return new OilTransferDeliveryOnlyExistsValidator();
	}
}
