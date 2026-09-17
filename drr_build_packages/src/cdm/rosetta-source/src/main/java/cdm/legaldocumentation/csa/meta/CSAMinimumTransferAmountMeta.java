package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CSAMinimumTransferAmount;
import cdm.legaldocumentation.csa.validation.CSAMinimumTransferAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CSAMinimumTransferAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.CSAMinimumTransferAmountOnlyExistsValidator;
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
@RosettaMeta(model=CSAMinimumTransferAmount.class)
public class CSAMinimumTransferAmountMeta implements RosettaMetaData<CSAMinimumTransferAmount> {

	@Override
	public List<Validator<? super CSAMinimumTransferAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CSAMinimumTransferAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAMinimumTransferAmount> validator(ValidatorFactory factory) {
		return factory.<CSAMinimumTransferAmount>create(CSAMinimumTransferAmountValidator.class);
	}

	@Override
	public Validator<? super CSAMinimumTransferAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAMinimumTransferAmount>create(CSAMinimumTransferAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAMinimumTransferAmount> validator() {
		return new CSAMinimumTransferAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAMinimumTransferAmount> typeFormatValidator() {
		return new CSAMinimumTransferAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAMinimumTransferAmount, Set<String>> onlyExistsValidator() {
		return new CSAMinimumTransferAmountOnlyExistsValidator();
	}
}
