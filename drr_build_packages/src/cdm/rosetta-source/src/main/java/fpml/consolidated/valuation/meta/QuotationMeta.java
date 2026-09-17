package fpml.consolidated.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.Quotation;
import fpml.consolidated.valuation.validation.QuotationTypeFormatValidator;
import fpml.consolidated.valuation.validation.QuotationValidator;
import fpml.consolidated.valuation.validation.datarule.QuotationChoice;
import fpml.consolidated.valuation.validation.exists.QuotationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Quotation.class)
public class QuotationMeta implements RosettaMetaData<Quotation> {

	@Override
	public List<Validator<? super Quotation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Quotation>create(QuotationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Quotation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Quotation> validator(ValidatorFactory factory) {
		return factory.<Quotation>create(QuotationValidator.class);
	}

	@Override
	public Validator<? super Quotation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Quotation>create(QuotationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Quotation> validator() {
		return new QuotationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Quotation> typeFormatValidator() {
		return new QuotationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Quotation, Set<String>> onlyExistsValidator() {
		return new QuotationOnlyExistsValidator();
	}
}
