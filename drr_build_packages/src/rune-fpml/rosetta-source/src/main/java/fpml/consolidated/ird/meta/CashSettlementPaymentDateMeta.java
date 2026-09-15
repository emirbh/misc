package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CashSettlementPaymentDate;
import fpml.consolidated.ird.validation.CashSettlementPaymentDateTypeFormatValidator;
import fpml.consolidated.ird.validation.CashSettlementPaymentDateValidator;
import fpml.consolidated.ird.validation.datarule.CashSettlementPaymentDateChoice;
import fpml.consolidated.ird.validation.exists.CashSettlementPaymentDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashSettlementPaymentDate.class)
public class CashSettlementPaymentDateMeta implements RosettaMetaData<CashSettlementPaymentDate> {

	@Override
	public List<Validator<? super CashSettlementPaymentDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CashSettlementPaymentDate>create(CashSettlementPaymentDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CashSettlementPaymentDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashSettlementPaymentDate> validator(ValidatorFactory factory) {
		return factory.<CashSettlementPaymentDate>create(CashSettlementPaymentDateValidator.class);
	}

	@Override
	public Validator<? super CashSettlementPaymentDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashSettlementPaymentDate>create(CashSettlementPaymentDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlementPaymentDate> validator() {
		return new CashSettlementPaymentDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlementPaymentDate> typeFormatValidator() {
		return new CashSettlementPaymentDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlementPaymentDate, Set<String>> onlyExistsValidator() {
		return new CashSettlementPaymentDateOnlyExistsValidator();
	}
}
