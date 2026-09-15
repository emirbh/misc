package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.SettlementTerms;
import fpml.consolidated.option.shared.validation.SettlementTermsTypeFormatValidator;
import fpml.consolidated.option.shared.validation.SettlementTermsValidator;
import fpml.consolidated.option.shared.validation.exists.SettlementTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementTerms.class)
public class SettlementTermsMeta implements RosettaMetaData<SettlementTerms> {

	@Override
	public List<Validator<? super SettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementTerms> validator(ValidatorFactory factory) {
		return factory.<SettlementTerms>create(SettlementTermsValidator.class);
	}

	@Override
	public Validator<? super SettlementTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementTerms>create(SettlementTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementTerms> validator() {
		return new SettlementTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementTerms> typeFormatValidator() {
		return new SettlementTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementTerms, Set<String>> onlyExistsValidator() {
		return new SettlementTermsOnlyExistsValidator();
	}
}
