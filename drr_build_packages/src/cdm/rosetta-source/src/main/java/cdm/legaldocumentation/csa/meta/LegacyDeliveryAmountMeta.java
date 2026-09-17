package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyDeliveryAmount;
import cdm.legaldocumentation.csa.validation.LegacyDeliveryAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyDeliveryAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.LegacyDeliveryAmountOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=LegacyDeliveryAmount.class)
public class LegacyDeliveryAmountMeta implements RosettaMetaData<LegacyDeliveryAmount> {

	@Override
	public List<Validator<? super LegacyDeliveryAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyDeliveryAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyDeliveryAmount> validator(ValidatorFactory factory) {
		return factory.<LegacyDeliveryAmount>create(LegacyDeliveryAmountValidator.class);
	}

	@Override
	public Validator<? super LegacyDeliveryAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyDeliveryAmount>create(LegacyDeliveryAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyDeliveryAmount> validator() {
		return new LegacyDeliveryAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyDeliveryAmount> typeFormatValidator() {
		return new LegacyDeliveryAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyDeliveryAmount, Set<String>> onlyExistsValidator() {
		return new LegacyDeliveryAmountOnlyExistsValidator();
	}
}
