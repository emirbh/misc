package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.MinimumTransferAmount;
import cdm.legaldocumentation.csa.validation.MinimumTransferAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.MinimumTransferAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.MinimumTransferAmountOnlyExistsValidator;
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
@RosettaMeta(model=MinimumTransferAmount.class)
public class MinimumTransferAmountMeta implements RosettaMetaData<MinimumTransferAmount> {

	@Override
	public List<Validator<? super MinimumTransferAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MinimumTransferAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MinimumTransferAmount> validator(ValidatorFactory factory) {
		return factory.<MinimumTransferAmount>create(MinimumTransferAmountValidator.class);
	}

	@Override
	public Validator<? super MinimumTransferAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MinimumTransferAmount>create(MinimumTransferAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MinimumTransferAmount> validator() {
		return new MinimumTransferAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MinimumTransferAmount> typeFormatValidator() {
		return new MinimumTransferAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MinimumTransferAmount, Set<String>> onlyExistsValidator() {
		return new MinimumTransferAmountOnlyExistsValidator();
	}
}
