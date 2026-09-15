package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.OilDelivery;
import fpml.consolidated.com.validation.OilDeliveryTypeFormatValidator;
import fpml.consolidated.com.validation.OilDeliveryValidator;
import fpml.consolidated.com.validation.datarule.OilDeliveryChoice0;
import fpml.consolidated.com.validation.datarule.OilDeliveryChoice1;
import fpml.consolidated.com.validation.exists.OilDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OilDelivery.class)
public class OilDeliveryMeta implements RosettaMetaData<OilDelivery> {

	@Override
	public List<Validator<? super OilDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OilDelivery>create(OilDeliveryChoice0.class),
			factory.<OilDelivery>create(OilDeliveryChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super OilDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OilDelivery> validator(ValidatorFactory factory) {
		return factory.<OilDelivery>create(OilDeliveryValidator.class);
	}

	@Override
	public Validator<? super OilDelivery> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OilDelivery>create(OilDeliveryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OilDelivery> validator() {
		return new OilDeliveryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OilDelivery> typeFormatValidator() {
		return new OilDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilDelivery, Set<String>> onlyExistsValidator() {
		return new OilDeliveryOnlyExistsValidator();
	}
}
