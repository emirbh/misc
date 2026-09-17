package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.asset.validation.BasicQuotationTypeFormatValidator;
import fpml.consolidated.asset.validation.BasicQuotationValidator;
import fpml.consolidated.asset.validation.datarule.BasicQuotationChoice;
import fpml.consolidated.asset.validation.exists.BasicQuotationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BasicQuotation.class)
public class BasicQuotationMeta implements RosettaMetaData<BasicQuotation> {

	@Override
	public List<Validator<? super BasicQuotation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BasicQuotation>create(BasicQuotationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BasicQuotation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasicQuotation> validator(ValidatorFactory factory) {
		return factory.<BasicQuotation>create(BasicQuotationValidator.class);
	}

	@Override
	public Validator<? super BasicQuotation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasicQuotation>create(BasicQuotationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasicQuotation> validator() {
		return new BasicQuotationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasicQuotation> typeFormatValidator() {
		return new BasicQuotationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasicQuotation, Set<String>> onlyExistsValidator() {
		return new BasicQuotationOnlyExistsValidator();
	}
}
