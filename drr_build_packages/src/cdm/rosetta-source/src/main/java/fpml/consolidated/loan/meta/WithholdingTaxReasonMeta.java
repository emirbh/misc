package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.WithholdingTaxReason;
import fpml.consolidated.loan.validation.WithholdingTaxReasonTypeFormatValidator;
import fpml.consolidated.loan.validation.WithholdingTaxReasonValidator;
import fpml.consolidated.loan.validation.exists.WithholdingTaxReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WithholdingTaxReason.class)
public class WithholdingTaxReasonMeta implements RosettaMetaData<WithholdingTaxReason> {

	@Override
	public List<Validator<? super WithholdingTaxReason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WithholdingTaxReason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WithholdingTaxReason> validator(ValidatorFactory factory) {
		return factory.<WithholdingTaxReason>create(WithholdingTaxReasonValidator.class);
	}

	@Override
	public Validator<? super WithholdingTaxReason> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WithholdingTaxReason>create(WithholdingTaxReasonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WithholdingTaxReason> validator() {
		return new WithholdingTaxReasonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WithholdingTaxReason> typeFormatValidator() {
		return new WithholdingTaxReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WithholdingTaxReason, Set<String>> onlyExistsValidator() {
		return new WithholdingTaxReasonOnlyExistsValidator();
	}
}
