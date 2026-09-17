package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DividendPaymentDate;
import fpml.consolidated.eq.shared.validation.DividendPaymentDateTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.DividendPaymentDateValidator;
import fpml.consolidated.eq.shared.validation.datarule.DividendPaymentDateChoice;
import fpml.consolidated.eq.shared.validation.exists.DividendPaymentDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendPaymentDate.class)
public class DividendPaymentDateMeta implements RosettaMetaData<DividendPaymentDate> {

	@Override
	public List<Validator<? super DividendPaymentDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DividendPaymentDate>create(DividendPaymentDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendPaymentDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendPaymentDate> validator(ValidatorFactory factory) {
		return factory.<DividendPaymentDate>create(DividendPaymentDateValidator.class);
	}

	@Override
	public Validator<? super DividendPaymentDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendPaymentDate>create(DividendPaymentDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendPaymentDate> validator() {
		return new DividendPaymentDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendPaymentDate> typeFormatValidator() {
		return new DividendPaymentDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPaymentDate, Set<String>> onlyExistsValidator() {
		return new DividendPaymentDateOnlyExistsValidator();
	}
}
