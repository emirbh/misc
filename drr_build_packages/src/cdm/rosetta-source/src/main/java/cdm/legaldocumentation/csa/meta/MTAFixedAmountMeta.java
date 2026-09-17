package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.MTAFixedAmount;
import cdm.legaldocumentation.csa.validation.MTAFixedAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.MTAFixedAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.MTAFixedAmountOnlyExistsValidator;
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
@RosettaMeta(model=MTAFixedAmount.class)
public class MTAFixedAmountMeta implements RosettaMetaData<MTAFixedAmount> {

	@Override
	public List<Validator<? super MTAFixedAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MTAFixedAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MTAFixedAmount> validator(ValidatorFactory factory) {
		return factory.<MTAFixedAmount>create(MTAFixedAmountValidator.class);
	}

	@Override
	public Validator<? super MTAFixedAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MTAFixedAmount>create(MTAFixedAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MTAFixedAmount> validator() {
		return new MTAFixedAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MTAFixedAmount> typeFormatValidator() {
		return new MTAFixedAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MTAFixedAmount, Set<String>> onlyExistsValidator() {
		return new MTAFixedAmountOnlyExistsValidator();
	}
}
