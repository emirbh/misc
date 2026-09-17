package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AdmissionToTrading;
import fpml.consolidated.doc.validation.AdmissionToTradingTypeFormatValidator;
import fpml.consolidated.doc.validation.AdmissionToTradingValidator;
import fpml.consolidated.doc.validation.exists.AdmissionToTradingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdmissionToTrading.class)
public class AdmissionToTradingMeta implements RosettaMetaData<AdmissionToTrading> {

	@Override
	public List<Validator<? super AdmissionToTrading>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdmissionToTrading, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdmissionToTrading> validator(ValidatorFactory factory) {
		return factory.<AdmissionToTrading>create(AdmissionToTradingValidator.class);
	}

	@Override
	public Validator<? super AdmissionToTrading> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdmissionToTrading>create(AdmissionToTradingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdmissionToTrading> validator() {
		return new AdmissionToTradingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdmissionToTrading> typeFormatValidator() {
		return new AdmissionToTradingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdmissionToTrading, Set<String>> onlyExistsValidator() {
		return new AdmissionToTradingOnlyExistsValidator();
	}
}
